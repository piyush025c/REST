package org.example.model;

import javax.json.bind.annotation.JsonbAnnotation;

@JsonbAnnotation
public class DrugOfMonthDetails {

    private String product;
    private int totalByCityForCurMonth;

    public DrugOfMonthDetails() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getTotalByCityForCurMonth() {
        return totalByCityForCurMonth;
    }

    public void setTotalByCityForCurMonth(int totalByCityForCurMonth) {
        this.totalByCityForCurMonth = totalByCityForCurMonth;
    }
}
