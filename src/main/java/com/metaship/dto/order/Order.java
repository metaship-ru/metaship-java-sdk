package com.metaship.dto.order;

import com.metaship.dto.delivery.Delivery;
import com.metaship.dto.recipient.Recipient;


import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;

public class Order {
    private int id;
    private String deliveryName;
    private int shopId;
    private BigDecimal deliveryCost;
    private int tariffId;
    private String shopNumber;
    private String trackNumber;
    private String deliveryType;
    private int length;
    private int width;
    private double weight;
    private int height;
    private Delivery delivery;
    private String created;
    private String status;
    private Array errors;
    private String statusName;
    private int parcelId;
    private BigDecimal paymentSum;
    private BigDecimal assessedValue;
    private BigDecimal prepaidValue;

    public Recipient recipient;

    public Item[] items;

    public int getShopId() {
        return shopId;
    }
    public void setShopId(int shopServiceCode) {
        this.shopId = shopServiceCode;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryName() {
        return deliveryName;
    }
    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }
    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public int getTariffId() {
        return tariffId;
    }
    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public String getShopNumber() {
        return shopNumber;
    }
    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getDeliveryType() {
        return deliveryType;
    }
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public BigDecimal getPaymentSum() {
        return paymentSum;
    }
    public void setPaymentSum(BigDecimal paymentSum) {
        this.paymentSum = paymentSum;
    }

    public BigDecimal getAssessedValue() {
        return assessedValue;
    }
    public void setAssessedValue(BigDecimal assessedValue) {
        this.assessedValue = assessedValue;
    }

    public BigDecimal getPrepaidValue() {
        return prepaidValue;
    }
    public void setPrepaidValue(BigDecimal prepaidValue) {
        this.prepaidValue = prepaidValue;
    }

    public String getTrackNumber() {
        return trackNumber;
    }
    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getParcelId() {
        return parcelId;
    }
    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }

    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Array getErrors() {
        return errors;
    }
    public void setErrors(Array errors) {
        this.errors = errors;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created;
    }

    public Delivery getDelivery() {
        return delivery;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", deliveryName='" + deliveryName + '\'' +
                ", shopId=" + shopId +
                ", deliveryCost=" + deliveryCost +
                ", tariffId=" + tariffId +
                ", shopNumber='" + shopNumber + '\'' +
                ", trackNumber='" + trackNumber + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", weight=" + weight +
                ", height=" + height +
                ", delivery=" + delivery +
                ", created='" + created + '\'' +
                ", status='" + status + '\'' +
                ", errors=" + errors +
                ", statusName='" + statusName + '\'' +
                ", parcelId=" + parcelId +
                ", paymentSum=" + paymentSum +
                ", assessedValue=" + assessedValue +
                ", prepaidValue=" + prepaidValue +
                ", recipient=" + recipient +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
