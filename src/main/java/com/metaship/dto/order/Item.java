package com.metaship.dto.order;

import java.math.BigDecimal;

public class Item {
    private String name;
    private String vendorCode;
    private String vatCode;
    private double weight;
    private BigDecimal cost;
    private int quantity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }
    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVatCode() {
        return vatCode;
    }
    public void setVatCode(String vatCode) {
        this.vatCode = vatCode;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", vatCode='" + vatCode + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
