package buyprocess;

import products.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class SellBill implements Serializable {
    private static int billId;
    private String date;
    private double received;
    private ArrayList<Product> sellList;
    private String buyerName;
    private boolean deliveryStatus;
    private static int proId = 1;
    //..........Constructor................................
    public SellBill(int billId, String date, double received, String buyerName, boolean deliveryStatus) {
        this.billId = billId;
        this.date = date;
        this.received = received;
        this.buyerName = buyerName;
        this.deliveryStatus = deliveryStatus;
    }
    //..........Set&Get....................................
    public static int getBillId() {
        return billId;
    }
    public String getDate() {
        return date;
    }
    public double getReceived() {
        return received;
    }
    public String getBuyerName() {
        return buyerName;
    }
    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }
    public static void setBillId(int billId) {
        SellBill.billId = billId;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setReceived(double received) {
        this.received = received;
    }
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public ArrayList<Product> getSellList() {
        return sellList;
    }
    public void setSellList(ArrayList<Product> sellList) {
        this.sellList = sellList;
    }
}
