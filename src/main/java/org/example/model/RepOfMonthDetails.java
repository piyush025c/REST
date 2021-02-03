package org.example.model;

import javax.json.bind.annotation.JsonbAnnotation;

@JsonbAnnotation
public class RepOfMonthDetails {

    private int salesRepId;
    private String salesRepName;
    private int monthlyTotal;

    public RepOfMonthDetails() {
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

    public int getMonthlyTotal() {
        return monthlyTotal;
    }

    public void setMonthlyTotal(int monthlyTotal) {
        this.monthlyTotal = monthlyTotal;
    }
}
