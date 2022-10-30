package buyprocess;

import java.io.Serializable;

public class Review implements Serializable {
    public enum status
    {
        PENDING,CONFIRMED,UNCONFIRMED;
    }
    private String viewer;
    private String product;
    private String reviewText;
    private status reviewStatus;
    private boolean bought;
    //.......Constructor..................
    public Review(String viewer, String product, String reviewText, status reviewStatus, boolean bought) {
        this.viewer = viewer;
        this.product = product;
        this.reviewText = reviewText;
        this.reviewStatus = reviewStatus;
        this.bought = bought;
    }
    //........Set&Get.....................
    public String getViewer() {
        return viewer;
    }
    public String getProduct() {
        return product;
    }
    public String getReviewText() {
        return reviewText;
    }
    public status getReviewStatus() {
        return reviewStatus;
    }
    public boolean isBought() {
        return bought;
    }
    public void setViewer(String viewer) {
        this.viewer = viewer;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    public void setReviewStatus(status reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
