package buyprocess;

import products.Product;
import rolls.Buyer;

import java.io.Serializable;

public class Point implements Serializable {
    enum Pointing
    {
        ONE,TWO,THREE,FOUR,FIVE;
    }
    private Buyer buyerName;
    private Pointing viewerPoint;
    private Product productName;
    //............Constructor...............
    public Point(Buyer buyerName, Pointing viewerPoint, Product productName) {
        this.buyerName = buyerName;
        this.viewerPoint = viewerPoint;
        this.productName = productName;
    }
    //............Set&Get...................
    public Buyer getBuyerName() {
        return buyerName;
    }
    public Pointing getViewerPoint() {
        return viewerPoint;
    }
    public Product getProductName() {
        return productName;
    }
    public void setBuyerName(Buyer buyerName) {
        this.buyerName = buyerName;
    }
    public void setViewerPoint(Pointing viewerPoint) {
        this.viewerPoint = viewerPoint;
    }
    public void setProductName(Product productName) {
        this.productName = productName;
    }
}
