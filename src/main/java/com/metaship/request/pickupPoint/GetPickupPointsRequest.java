package com.metaship.request.pickupPoint;

public class GetPickupPointsRequest {
    public static final String  METHOD = "GET";
    public static final String  PATH = "/v1/pickuppoints";

    public String kladrId;
    public String deliveryName;
}
