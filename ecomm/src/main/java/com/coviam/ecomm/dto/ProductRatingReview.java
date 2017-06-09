package com.coviam.ecomm.dto;

/**
 * Created by gaurav on 06/06/17.
 */
public class ProductRatingReview {
    private int rating;
    private String review;

    public ProductRatingReview() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ProductRatingReview{" +
                "rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
