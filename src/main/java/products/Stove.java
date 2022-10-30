package products;

import rolls.Admin;

import java.io.Serializable;

public class Stove extends HomeAppliances implements Serializable {
    public enum StoveType
    {
        GLASS,STEEL,METAL;
    }
    private int burnerNumber;
    private StoveType stoveType;
    private boolean haveOven;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/clothing/shoes/shoesList";
    static int index = 0;
    private int code;
    //......Constructor......................
    public Stove(String productId, String name1, String company, double price,
                 String seller, String detail, Degree degreeOfConsumption,
                 boolean warranty, int burnerNumber, StoveType stoveType, boolean haveOven) {
        super(productId, name1, company, price, seller, true, detail,
                degreeOfConsumption, warranty);
        this.code = ++index;
        this.burnerNumber = burnerNumber;
        this.stoveType = stoveType;
        this.haveOven = haveOven;
        Admin.allProducts.add(this);
        this.setTag("stove");
    }
    //........Set&Get..........................
    public int getBurnerNumber() {
        return burnerNumber;
    }
    public StoveType getStoveType() {
        return stoveType;
    }
    public boolean isHaveOven() {
        return haveOven;
    }
    public void setBurnerNumber(int burnerNumber) {
        this.burnerNumber = burnerNumber;
    }
    public void setStoveType(StoveType stoveType) {
        this.stoveType = stoveType;
    }
    public void setHaveOven(boolean haveOven) {
        this.haveOven = haveOven;
    }
    public String getAddress() {
        return address;
    }
    public int getCode() {
        return code;
    }
    public static int getIndex() {
        return index;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void setIndex(int index) {
        Stove.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //........Methods...........................
    @Override
    public String toString() {
        return super.toString()+"products.Stove{" +
                "burnerNumber=" + burnerNumber +
                ", stoveType=" + stoveType +
                ", haveOven=" + haveOven +
                '}';
    }
}
