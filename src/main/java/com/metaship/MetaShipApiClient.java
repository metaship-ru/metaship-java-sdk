package com.metaship;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaship.dto.offer.Offer;
import com.metaship.dto.order.Order;
import com.metaship.dto.pickupPoint.PickupPoint;
import com.metaship.request.offer.OfferRequest;
import com.metaship.request.order.CreateOrderRequest;
import com.metaship.request.pickupPoint.GetPickupPointsRequest;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class MetaShipApiClient implements IMetaShipApiClient {
    private ObjectMapper mapper = new ObjectMapper();

    private HttpClient client = new DefaultHttpClient();
    private HttpResponse response = null;

    private String url;
    private String apiKey;
    private String apiSecret;

    MetaShipApiClient(String url, String apiKey, String apiSecret) {
        this.url = url;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public PickupPoint searchPickupPoint(GetPickupPointsRequest getPickupPointsRequest) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        String query = mapper.writeValueAsString(getPickupPointsRequest);
        HttpGet request = new HttpGet(url + GetPickupPointsRequest.PATH + "?" + query);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", generateSignatureFromRequest(GetPickupPointsRequest.METHOD, GetPickupPointsRequest.PATH, "", query));
        response = client.execute(request);
        return mapper.readValue(readResponse(response), PickupPoint.class);
    }

    public List<Offer> getOffers(OfferRequest offerRequest) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        String query = paramString(mapper.readValue(mapper.writeValueAsString(offerRequest), new TypeReference<HashMap<String, String>>() {}));
        HttpGet request = new HttpGet(url + OfferRequest.PATH + "?" + query);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", generateSignatureFromRequest(OfferRequest.METHOD, OfferRequest.PATH, "", query));
        response = client.execute(request);
        return mapper.readValue(readResponse(response), new TypeReference<List<Offer>>(){});
    }

    public Order createOrder(CreateOrderRequest createOrderRequest) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        String body = mapper.writeValueAsString(createOrderRequest);
        HttpPost request = new HttpPost(url + CreateOrderRequest.PATH);
        HttpEntity entity = new ByteArrayEntity(body.getBytes(StandardCharsets.UTF_8));
        request.setEntity(entity);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", generateSignatureFromRequest(CreateOrderRequest.METHOD, CreateOrderRequest.PATH, body, ""));
        response = client.execute(request);
        return mapper.readValue(readResponse(response), Order.class);
    }

    private String readResponse(HttpResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseBuilder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            responseBuilder.append(output);
        }
        return responseBuilder.toString();
    }

    private String generateSignatureFromRequest(String method, String slug, String body, String parameters) throws NoSuchAlgorithmException, InvalidKeyException {
        String hashedPayload = getSHA256(body);
        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        String[] requestData = {method, slug, parameters, dateTime, hashedPayload};
        String requestJoin = String.join(" ", requestData);
        String hashedRequestData = getSHA256(requestJoin);
        String generatedInternalSecretKey = hmacSha256(hashedRequestData, apiSecret);
        String[] headerParams = {"HMAC-SHA256", dateTime, apiKey, generatedInternalSecretKey};
        return String.join(", ", headerParams);
    }

    private static String getSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    private String hmacSha256(String value, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(value.getBytes());
        byte[] hexBytes = new Hex().encode(rawHmac);
        return new String(hexBytes, StandardCharsets.UTF_8);
    }

    private static String paramString(Map<String, ?> paramMap) {
        List<NameValuePair> params = new ArrayList<>();
        if (paramMap != null) {
            for (Map.Entry<String, ?> paramEntry : paramMap.entrySet()) {
                Object value = paramEntry.getValue();
                if (value != null) {
                    params.add(new BasicNameValuePair(paramEntry.getKey(), value.toString()));
                }
            }
        }
        return URLEncodedUtils.format(params, "UTF-8");
    }
}