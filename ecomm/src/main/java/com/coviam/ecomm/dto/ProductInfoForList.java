package com.coviam.ecomm.dto;

/**
 * Created by gaurav on 05/06/17.
 */
public class ProductInfoForList {
    private int productid;
    private String name;
    private String imageurl;
    private double rating;

    public ProductInfoForList(int productid, String name, String imageurl, double rating) {
        this.productid = productid;
        this.name = name;
        this.imageurl = imageurl;
        this.rating = rating;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", rating=" + rating +
                '}';
    }

}
