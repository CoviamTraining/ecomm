package com.coviam.ecomm.entity;

/**
 * Created by gaurav on 06/06/17.
 */
public class ProductInfoToUI {
    private int productid;
    private String name;
    private String imageurl;
    private double rating;
    private double price;

    public ProductInfoToUI() {
    }

    public ProductInfoToUI(String name, String imageurl, double rating, double price) {
        this.name = name;
        this.imageurl = imageurl;
        this.rating = rating;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductInfoToUI{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }


}
