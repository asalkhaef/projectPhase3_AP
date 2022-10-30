package buyprocess;

import products.Product;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class BuyBill implements Serializable {
    private int billId;
    private String date;
    private double paid;
    private ArrayList<Product> buyList;
    private boolean deliveryStatus;
    private static int proId = 1;
    //.......Constructor...................
    public BuyBill(int billId, String date, double paid, boolean deliveryStatus,ArrayList<Product> list) {
        this.billId = billId;
        this.date = date;
        this.paid = paid;
        this.deliveryStatus = deliveryStatus;
        buyList = new ArrayList<Product>();
        this.buyList = list;
    }
    //........Set&Get.......................
    public int getBillId() {
        return billId;
    }
    public String getDate() {
        return date;
    }
    public double getPaid() {
        return paid;
    }
    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPaid(double paid) {
        this.paid = paid;
    }
    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public ArrayList<Product> getBuyList() {
        return buyList;
    }
    public void setBuyList(ArrayList<Product> buyList) {
        this.buyList = buyList;
    }
    public static int getProId() {
        return proId;
    }
    public static void setProId(int proId) {
        BuyBill.proId = proId;
    }
    //........Methods.......................

    @Override
    public String toString() {
        return "buyproccess.BuyBill{" +
                "billId=" + billId +
                ", date='" + date + '\'' +
                ", paid=" + paid +
                ", buyList=" + buyList +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}