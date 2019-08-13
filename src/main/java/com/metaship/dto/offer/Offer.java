package com.metaship.dto.offer;

import com.metaship.dto.delivery.Cost;
import com.metaship.dto.delivery.Delivery;

import java.util.Objects;

public class Offer {
    private Delivery delivery;
    private Cost cost;
    private int daysMin;
    private int daysMax;
    private Tariff tariff;
    private int costPriority;

    private int buyPriority;

    public int getCostPriority() {
        return costPriority;
    }
    public void setCostPriority(int costPriority) {
        this.costPriority = costPriority;
    }

    public int getBuyPriority() {
        return buyPriority;
    }
    public void setBuyPriority(int buyPriority) {
        this.buyPriority = buyPriority;
    }

    public int getDaysMin() {
        return daysMin;
    }
    public void setDaysMin(int daysMin) {
        this.daysMin = daysMin;
    }

    public int getDaysMax() {
        return daysMax;
    }
    public void setDaysMax(int daysMax) {
        this.daysMax = daysMax;
    }

    public Tariff getTariff() {
        return tariff;
    }
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Delivery getDelivery() {
        return delivery;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Cost getCost() {
        return cost;
    }
    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "delivery=" + delivery +
                ", cost=" + cost +
                ", daysMin=" + daysMin +
                ", daysMax=" + daysMax +
                ", tariff=" + tariff +
                ", costPriority=" + costPriority +
                ", buyPriority=" + buyPriority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return delivery.equals(offer.delivery) &&
                tariff.equals(offer.tariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delivery, tariff);
    }
}
