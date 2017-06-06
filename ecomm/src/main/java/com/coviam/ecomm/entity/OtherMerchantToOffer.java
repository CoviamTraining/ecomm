package com.coviam.ecomm.entity;

/**
 * Created by gaurav on 06/06/17.
 */
public class OtherMerchantToOffer {
    private double price;
    private String name;
    private String logo;
    private double rating;

    public OtherMerchantToOffer() {
    }

    public OtherMerchantToOffer(double price, String name, String logo, double rating) {
        this.price = price;
        this.name = name;
        this.logo = logo;
        this.rating = rating;
    }

    public String getImageurl() {
        return logo;
    }

    public void setImageurl(String logo) {
        this.logo = logo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
