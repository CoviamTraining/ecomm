package com.coviam.ecomm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Set;

/**
 * Created by gaurav on 03/06/17.
 */
@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @Column(name = "productid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "usp",length = 1024,nullable = false)
    private String usp;

    @Column(name = "brand",length = 50, nullable = false)
    private String brand;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "attributes", length = 1024, nullable = false)
    private String attributes;

    @Column(name="imageurl",length = 1024)
    private String imageurl;

    @Column(name = "rating", scale = 1, precision = 2)
    private double rating;

    @Column(name = "merchantlist", length = 1024)
    private String merchantlist;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Product() {
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

    public String getMerchantlist() {
        return merchantlist;
    }

    public void setMerchantlist(String merchantlist) {
        this.merchantlist = merchantlist;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", usp='" + usp + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", attributes='" + attributes + '\'' +
                ", imageurl=" + imageurl +
                ", rating=" + rating +
                ", merchantlist=" + merchantlist +
                '}';
    }
}
