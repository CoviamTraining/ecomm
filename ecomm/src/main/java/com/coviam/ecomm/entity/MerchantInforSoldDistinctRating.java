package com.coviam.ecomm.entity;

/**
 * Created by gaurav on 05/06/17.
 */
public class MerchantInforSoldDistinctRating {
    private long productsold;
    private int distinctproduct;
    private double rating;

    public MerchantInforSoldDistinctRating(long productsold, int distinctproduct, double rating) {
        this.productsold = productsold;
        this.distinctproduct = distinctproduct;
        this.rating = rating;
    }

    public MerchantInforSoldDistinctRating() {
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getProductsold() {
        return productsold;
    }

    public void setProductsold(long productsold) {
        this.productsold = productsold;
    }

    public int getDistinctproduct() {
        return distinctproduct;
    }

    public void setDistinctproduct(int distinctproduct) {
        this.distinctproduct = distinctproduct;
    }

    @Override
    public String toString() {
        return "MerchantInforSoldDistinctRating{" +
                "productsold=" + productsold +
                ", distinctproduct=" + distinctproduct +
                ", rating=" + rating +
                '}';
    }
}

