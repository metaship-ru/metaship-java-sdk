package com.metaship;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaship.entity.pickupPoint.PickupPoint;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class MetaShipApiClient implements IMetaShipApiClient {

    private String url;
    private String apiKey;
    private String apiSecret;

    MetaShipApiClient(String url, String apiKey, String apiSecret){
        this.url = url;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    private String sendRequest(String method, String slug, String queryParameters) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        URL urlBuilder = new URL(url + slug + "?" + queryParameters);
        HttpURLConnection con = (HttpURLConnection) urlBuilder.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", generateSignatureFromRequest(method, slug, "", queryParameters));

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        return sb.toString();
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

    public PickupPoint searchPickupPoint(String serviceNumber, String externalDeliveryCode) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        List<BasicNameValuePair> queryParams = new ArrayList<>();
        BasicNameValuePair serviceNumberParam = new BasicNameValuePair("serviceNumber", serviceNumber);
        BasicNameValuePair externalDeliveryCodeParam = new BasicNameValuePair("externalDeliveryCode", externalDeliveryCode);
        queryParams.add(serviceNumberParam);
        queryParams.add(externalDeliveryCodeParam);

        String query = URLEncodedUtils.format(queryParams, Charset.defaultCharset());
        String pickupPointResponse = sendRequest("GET", "/v1/search/pickuppoint", query);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(pickupPointResponse, PickupPoint.class);
    }
}
