package com.coviam.ecomm.entity;

import java.util.List;

/**
 * Created by gaurav on 06/06/17.
 */
public class ProductOnDetailPage {

    private int productid;
    private String name;
    private String usp;
    private String brand;
    private String description;
    private String attributes;
    private String imageurl;
    private double rating;
    private List<OtherMerchantToOffer> otherMerchantToOffer;
    private List<ProductRatingReview> productRatingReviews;

    public ProductOnDetailPage() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<OtherMerchantToOffer> getOtherMerchantToOffer() {
        return otherMerchantToOffer;
    }

    public void setOtherMerchantToOffer(List<OtherMerchantToOffer> otherMerchantToOffer) {
        this.otherMerchantToOffer = otherMerchantToOffer;
    }

    public List<ProductRatingReview> getProductRatingReviews() {
        return productRatingReviews;
    }

    public void setProductRatingReviews(List<ProductRatingReview> productRatingReviews) {
        this.productRatingReviews = productRatingReviews;
    }

    @Override
    public String toString() {
        return "ProductOnDetailPage{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", usp='" + usp + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", attributes='" + attributes + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", rating=" + rating +
                ", otherMerchantToOffer=" + otherMerchantToOffer +
                ", productRatingReviews=" + productRatingReviews +
                '}';
    }
}
