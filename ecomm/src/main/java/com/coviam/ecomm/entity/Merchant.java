package com.coviam.ecomm.entity;

import javax.persistence.*;

/**
 * Created by gaurav on 03/06/17.
 */
@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @Column(name = "merchantid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "logo")
    private String logo;

    @Column(name = "rating")
    private int rating;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "productsold",nullable = false)
    private long productsold;

    @Column(name = "distinctproduct", nullable = false)
    private String distinctproduct;

    public Merchant() {
    }

    public int getMerchantid() {
        return id;
    }

    public void setMerchantid(int merchantid) {
        this.id = merchantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getProductsold() {
        return productsold;
    }

    public void setProductsold(long productsold) {
        this.productsold = productsold;
    }

    public String getDistinctproduct() {
        return distinctproduct;
    }

    public void setDistinctproduct(String distinctproduct) {
        this.distinctproduct = distinctproduct;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantid=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", rating=" + rating +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", productsold=" + productsold +
                ", distinctproduct='" + distinctproduct + '\'' +
                '}';
    }
}
