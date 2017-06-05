package com.coviam.ecomm.entity;

/**
 * Created by gaurav on 05/06/17.
 */
public class ProductInfoForList {
    private String name;
    private double rating;

    public ProductInfoForList(String name, double rating) {
        this.name = name;
        this.rating = rating;
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
        return "ProductInfoForList{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
