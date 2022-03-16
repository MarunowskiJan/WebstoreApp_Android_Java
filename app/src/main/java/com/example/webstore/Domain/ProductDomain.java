package com.example.webstore.Domain;

import java.io.Serializable;

public class ProductDomain implements Serializable {
    private String title;
    private String pic;



    public ProductDomain(String title, String pic, String description, Double fee, String currency, String warehouse, double star, int time) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.currency = currency;
        this.star = star;
        this.time = time;
        this.warehouse = warehouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String description;
    private Double fee;
    private String currency;
    private double star;
    private int time;

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    private String warehouse;

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    private int numberInCart;
}
