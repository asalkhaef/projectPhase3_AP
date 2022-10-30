package rolls;

import buyprocess.BuyBill;
import sqlPack.MySql;
import products.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Buyer  extends Person implements Serializable {
    private ArrayList<Product> cart;
    private ArrayList<Product> buyerProdects;
    private static ArrayList<Buyer> buyersList = new ArrayList<Buyer>();
    private ArrayList<BuyBill> buyBills;
    private boolean signIn = false;
    private String Address = null;
    private String codezip = null;
    static int index = 0;
    private int code;
    //......Constructor......................
    public Buyer(String accountId, String name, String familyName, String email, String phoneNumber, String password, double wealth) throws SQLException {
        super(accountId, name, familyName, email, phoneNumber, password, Person.Roll.BUYER, wealth);
        index = MySql.getMySql().GetMaxIntBuyer();
        this.code = ++index;
        cart = new ArrayList<Product>();
        buyerProdects = new ArrayList<Product>();
        buyBills = new ArrayList<BuyBill>();
        signIn = false;
        Admin.allUsers.add(this);
        buyersList.add(this);
    }
    //.....Set&Get.............................
    public ArrayList<Product> getCart() {
        return cart;
    }
    public void setCart(Product x) {
        this.cart.add(x);
    }
    public static ArrayList<Buyer> getBuyersList() {
        return buyersList;
    }
    public static void setBuyersList(Buyer x) {
        Buyer.buyersList.add(x);
    }
    public boolean isSignIn() {
        return signIn;
    }
    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }
    public ArrayList<Product> getBuyerProdects() {
        return buyerProdects;
    }
    public void setBuyerProdects(Product x ) {
        this.buyerProdects.add(x);
    }
    public String getAddress() {
        return Address;
    }
    public String getCodezip() {
        return codezip;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setCodezip(String codezip) {
        this.codezip = codezip;
    }
    public ArrayList<BuyBill> getBuyBills() {
        return buyBills;
    }
    public void setBuyBills(BuyBill x) {
        this.buyBills.add(x);
    }
    public static int getIndex() {
        return index;
    }
    public int getCode() {
        return code;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public void setBuyerProdects(ArrayList<Product> buyerProdects) {
        this.buyerProdects = buyerProdects;
    }

    public static void setBuyersList(ArrayList<Buyer> buyersList) {
        Buyer.buyersList = buyersList;
    }

    public void setBuyBills(ArrayList<BuyBill> buyBills) {
        this.buyBills = buyBills;
    }

    public static void setIndex(int index) {
        Buyer.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //........Methods........................
    void editAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        AccountOperation.editAccount();
    }
    @Override
    public String toString() {
        return super.toString()+"rolls.Buyer{" +
                "cart=" + cart +
                '}';
    }


}

