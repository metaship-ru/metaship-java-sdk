package com.metaship.dto.parcel;

import com.metaship.dto.delivery.Delivery;
import com.metaship.dto.order.Order;

import java.util.List;

public class Parcel {
    public int id;
    public String deliveryServiceNumber;
    public String shipmentDate;
    public Delivery delivery;
    public List<Order> orders;
}
