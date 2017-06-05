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

    @Column(name = "categoryid",scale = 4, nullable = false)
    private int categoryid;

    @Column(name="imageurl",length = 50)
    private List<String> imageurl;

    @Column(name = "rating", scale = 1, precision = 2)
    private double rating;

    @Column(name = "merchantlist", length = 1024)
    private List<String> merchantlist;

    @ManyToOne
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

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public List<String> getImageurl() {
        return imageurl;
    }

    public void setImageurl(List<String> imageurl) {
        this.imageurl = imageurl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getMerchantlist() {
        return merchantlist;
    }

    public void setMerchantlist(List<String> merchantlist) {
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
                ", categoryid=" + categoryid +
                ", imageurl=" + imageurl +
                ", rating=" + rating +
                ", merchantlist=" + merchantlist +
                '}';
    }
}
