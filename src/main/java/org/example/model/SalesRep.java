package org.example.model;

import javax.json.bind.annotation.JsonbAnnotation;

@JsonbAnnotation
public class SalesRep {

    private int salesRepId;
    private String salesRepName;
    private String country;
    private String city;
    private int pincode;
    private String gender;

    public SalesRep() {
    }

    public SalesRep(int salesRepId, String salesRepName, String country, String city, int pincode, String gender) {
        this.salesRepId = salesRepId;
        this.salesRepName = salesRepName;
        this.country = country;
        this.city = city;
        this.pincode = pincode;
        this.gender = gender;
    }

    public int getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(int salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
