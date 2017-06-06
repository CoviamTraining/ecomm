package com.coviam.ecomm.entity;

/**
 * Created by gaurav on 06/06/17.
 */
public class OtherMerchantToOffer {
    private int price;
    private String name;
    private double rating;

    public OtherMerchantToOffer() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "OtherMerchantToOffer{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

}
