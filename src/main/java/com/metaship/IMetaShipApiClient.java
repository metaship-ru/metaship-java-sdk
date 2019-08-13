package com.metaship;

import com.metaship.dto.offer.Offer;
import com.metaship.dto.order.Order;
import com.metaship.dto.pickupPoint.PickupPoint;
import com.metaship.request.offer.OfferRequest;
import com.metaship.request.order.CreateOrderRequest;
import com.metaship.request.pickupPoint.GetPickupPointsRequest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

interface IMetaShipApiClient {
    PickupPoint searchPickupPoint(GetPickupPointsRequest getPickupPointsRequest) throws IOException, NoSuchAlgorithmException, InvalidKeyException;
    List<Offer> getOffers(OfferRequest offerRequest) throws NoSuchAlgorithmException, InvalidKeyException, IOException;
    Order createOrder(CreateOrderRequest createOrderRequest) throws NoSuchAlgorithmException, InvalidKeyException, IOException;
}
