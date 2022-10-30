package products;

import buyprocess.Discount;
import buyprocess.Review;

import java.io.Serializable;
import java.util.ArrayList;

abstract public class Product implements Comparable , Serializable {
    private String productId;
    private String name;
    private String company;
    private double price;
    private String seller;
    private boolean status;
    private String detail;
    private double rate = 0;
    private double rateNumber = 0;
    private double average = (double) (rate / rateNumber) ;
    private ArrayList<Review> reviewList;
    private String sellerName;
    private String tag; //it is necessary for category
    private ArrayList<Discount> discountList;
    //...........Constructor..................
    public Product(String productId, String name1,
                   String company, double price, String seller, boolean status,
                   String detail) {
        this.productId = productId;
        this.name = name1;
        this.company = company;
        this.price = price;
        this.seller = seller;
        this.status = status;
        this.detail = detail;
        reviewList = new ArrayList<Review>();
        discountList = new ArrayList<Discount>();

    }
    //..........Set&Get........................
    public String getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public String getCompany() {
        return company;
    }
    public double getPrice() {
        return price;
    }
    public String getSeller() {
        return seller;
    }
    public boolean isStatus() {
        return status;
    }
    public String getDetail() {
        return detail;
    }
    public double getRate() {
        return rate;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public ArrayList<Review> getReviewList() {
        return reviewList;
    }
    public void setReviewList(Review x) {
        this.reviewList.add(x);
    }
    public String getSellerName() {
        return sellerName;
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public double getRateNumber() {
        return rateNumber;
    }
    public void setRateNumber(double rateNumber) {
        this.rateNumber = rateNumber;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public double getAverage() {
        return average;
    }
    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }
    public void setDiscountList(Discount z) {
        this.discountList.add(z);
    }

    //....Methods...........................
    @Override
    public String toString() {
        return super.toString()+ "products.Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                ", status=" + status +
                ", detail='" + detail + '\'' +
                ", avaregerate=" + average +
                ", reviewList=" + reviewList +
                '}';
    }

    public int compareTo(Object x)
    {
        Product x2 = (Product) x;
        if(this.name.compareTo(x2.name) < 0)
            return 1;
        else if(this.name.compareTo(x2.name) == 0)
        {
            if(this.average > x2.average)
                return 1;
            else if(this.average == x2.average)
            {
                if(this.price > x2.price)
                    return 1;
                else if(this.price == x2.price)
                {
                    if(this.status == true && x2.status == false)
                        return 1;
                    else
                        return -1;
                }
                else
                    return -1;
            }
            else
                return -1;
        }
        else return -1;

    }
}
