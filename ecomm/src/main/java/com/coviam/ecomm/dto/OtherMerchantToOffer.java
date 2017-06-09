package com.coviam.ecomm.dto;

/**
 * Created by gaurav on 06/06/17.
 */
public class OtherMerchantToOffer {
    private double price;
    private int merchantId;
    private String name;
    private String logo;
    private double rating;

    public OtherMerchantToOffer() {
    }

    public OtherMerchantToOffer(double price, int id, String name, String logo, double rating) {
        this.price = price;
        this.merchantId = id;
        this.name = name;
        this.logo = logo;
        this.rating = rating;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
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
                ", id=" + merchantId +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", rating=" + rating +
                '}';
    }

}
