package com.metaship.dto.address;

public class Address {
    private String kladrId;
    private String city;
    private int zip;
    private String street;
    private String house;
    private String building;

    public String getKladrId() {
        return kladrId;
    }
    public void setKladrId(String kladrId) {
        this.kladrId = kladrId;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
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

    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address{" +
                "kladrId='" + kladrId + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}