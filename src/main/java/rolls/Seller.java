package rolls;

import buyprocess.SellBill;
import sqlPack.MySql;
import products.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Seller extends Person implements Serializable {
    private static ArrayList<Product> listForSell;
    private ArrayList<Product> proList;
    private static ArrayList<Seller> SellersList = new ArrayList<Seller>();
    private ArrayList<SellBill> sellBills;
    private boolean signIn = false;
    static int index = 0;
    private int code;
    //.......Constructor.......................
    public Seller(String accountId, String name, String familyName, String email, String phoneNumber,
           String password, double wealth) throws SQLException {
        super(accountId, name, familyName, email, phoneNumber, password, Person.Roll.SELLER, wealth);
        index = MySql.getMySql().GetMaxIntSeller();
        this.code = ++index;
        listForSell = new ArrayList<Product>();
        sellBills = new ArrayList<SellBill>();
        proList = new ArrayList<Product>();
        signIn = false;
        Admin.allUsers.add(this);
    }
    //.....Set&Get.............................
    public static ArrayList<Product> getListForSell() {
        return listForSell;
    }
    public void setListForSell(Product x) {
        this.listForSell.add(x);
    }
    public static ArrayList<Seller> getSellersList() {
        return SellersList;
    }
    public static void setSellersList(Seller x) {
        Seller.SellersList.add(x);
    }
    public boolean isSignIn() {
        return signIn;
    }
    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }
    public ArrayList<Product> getProList() {
        return proList;
    }
    public void setProList(Product x) {
        this.proList.add(x);
    }
    public int getCode() {
        return code;
    }
    public static int getIndex() {
        return index;
    }

    public static void setListForSell(ArrayList<Product> listForSell) {
        Seller.listForSell = listForSell;
    }

    public void setProList(ArrayList<Product> proList) {
        this.proList = proList;
    }

    public static void setSellersList(ArrayList<Seller> sellersList) {
        SellersList = sellersList;
    }

    public void setSellBills(ArrayList<SellBill> sellBills) {
        this.sellBills = sellBills;
    }

    public static void setIndex(int index) {
        Seller.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //........Methods..........................
    void editAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        AccountOperation.editAccount();
    }
    @Override
    public String toString() {
        return super.toString()+"rolls.Seller{" +
                "listForSell=" + listForSell +
                '}';
    }
    void editProRequest(){

    }


}