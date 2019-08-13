package com.metaship.dto.pickupPoint;

import com.metaship.dto.photo.Photo;

import java.util.List;
import java.util.Objects;

public class PickupPoint {
    private int id;
    private float lat;
    private float lng;
    private String serviceNumber;
    private String externalDeliveryCode;
    private String cityId;
    private String name;
    private String isOnlyPrepaid;
    private String isAcquiringAvailable;
    private String city;
    private String street;
    private String house;
    private String postCode;
    private String region;
    private String comment;
    private String deliveryUniqueName;
    private String type;
    private String workTimeRaw;
    private String phone;
    private String metroStation;
    private String tariff;
    private String nearestStation;
    private List workTime;
    private List<Photo> photos;

    public String getIsAcquiringAvailable() {
        return isAcquiringAvailable;
    }
    public void setIsAcquiringAvailable(String isAcquiringAvailable) {
        this.isAcquiringAvailable = isAcquiringAvailable;
    }

    public String getTariff() {
        return tariff;
    }
    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getIsOnlyPrepaid() {
        return isOnlyPrepaid;
    }
    public void setIsOnlyPrepaid(String isOnlyPrepaid) {
        this.isOnlyPrepaid = isOnlyPrepaid;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeliveryUniqueName() {
        return deliveryUniqueName;
    }
    public void setDeliveryUniqueName(String deliveryUniqueName) {
        this.deliveryUniqueName = deliveryUniqueName;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getWorkTimeRaw() {
        return workTimeRaw;
    }
    public void setWorkTimeRaw(String workTimeRaw) {
        this.workTimeRaw = workTimeRaw;
    }

    public String getMetroStation() {
        return metroStation;
    }
    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getNearestStation() {
        return nearestStation;
    }
    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List getWorkTime() {
        return workTime;
    }
    public void setWorkTime(List workTime) {
        this.workTime = workTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getLat() {
        return lat;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }
    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }

    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }
    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getExternalDeliveryCode() {
        return externalDeliveryCode;
    }
    public void setExternalDeliveryCode(String externalDeliveryCode) {
        this.externalDeliveryCode = externalDeliveryCode;
    }

    @Override
    public String toString() {
        return "PickupPoint{" +
                "serviceNumber='" + serviceNumber + '\'' +
                ", externalDeliveryCode='" + externalDeliveryCode + '\'' +
                ", id=" + id +
                ", cityId='" + cityId + '\'' +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", isOnlyPrepaid='" + isOnlyPrepaid + '\'' +
                ", isAcquiringAvailable='" + isAcquiringAvailable + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", postCode='" + postCode + '\'' +
                ", region='" + region + '\'' +
                ", photos=" + photos +
                ", comment='" + comment + '\'' +
                ", workTime=" + workTime +
                ", deliveryUniqueName='" + deliveryUniqueName + '\'' +
                ", type='" + type + '\'' +
                ", workTimeRaw='" + workTimeRaw + '\'' +
                ", phone='" + phone + '\'' +
                ", metroStation='" + metroStation + '\'' +
                ", tariff='" + tariff + '\'' +
                ", nearestStation='" + nearestStation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PickupPoint that = (PickupPoint) o;
        return Objects.equals(serviceNumber, that.serviceNumber) &&
                Objects.equals(externalDeliveryCode, that.externalDeliveryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceNumber, externalDeliveryCode);
    }
}
