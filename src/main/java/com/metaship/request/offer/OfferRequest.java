package com.metaship.request.offer;

public class OfferRequest {
    public static final String METHOD = "GET";
    public static final String PATH = "/v1/offers";

    public String cityFrom;
    public String cityTo;
    public String regionFrom;
    public String regionTo;
    public long kladrIdFrom;
    public long kladrIdTo;
    public String fiasIdFrom;
    public String fiasIdTo;
    public int zipFrom;
    public int zipTo;
    public String tariffId;
    public float weight;
    public int width;
    public int length;
    public int height;
    public float itemsSum;
    public float paymentSum;
    public float assessedValue;
    public int pickupPointId;
    public String deliveryType;
}
