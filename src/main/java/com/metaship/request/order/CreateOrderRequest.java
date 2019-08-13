package com.metaship.request.order;

import com.metaship.request.item.CreateItemRequest;
import com.metaship.request.recipient.CreateRecipientRequest;

import java.util.List;

public class CreateOrderRequest {
    public static final String METHOD = "POST";
    public static final String PATH = "/v1/orders";

    public int length;
    public int width;
    public int height;
    public float weight;
    public String deliveryName;
    public String shopServiceCode;
    public float assessedValue;
    public float paymentSum;
    public String shopNumber;
    public String deliveryType;
    public float deliveryCost;
    public float prepaidValue;
    public float tariffId;
    public CreateRecipientRequest recipient;
    public CreateItemRequest[] items;
}
