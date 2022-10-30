package products;

import rolls.Admin;

import java.io.Serializable;

public class Laptop extends Digiproducts implements Serializable {
    private String CpuModel;
    private boolean isGamming;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/digiProduct/laptop/laptopList";
    static int index = 0;
    private int code;
    //..........Constructor...............
    public Laptop(String productId, String name1, String company, double price,
                  String seller, String detail, int memory, int ram,
                  String operatingSystem, double weight, String dimensions, String cpuModel, boolean isGamming) {
        super( productId, name1, company, price, seller, true, detail,
                memory, ram, operatingSystem, weight, dimensions);
        this.code = ++index;
        CpuModel = cpuModel;
        this.isGamming = isGamming;
        Admin.allProducts.add(this);
        this.setTag("laptop");
    }
    //...........Set&Get.....................
    public String getCpuModel() {
        return CpuModel;
    }
    public boolean isGamming() {
        return isGamming;
    }
    public void setCpuModel(String cpuModel) {
        CpuModel = cpuModel;
    }
    public void setGamming(boolean gamming) {
        isGamming = gamming;
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
        Laptop.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }
    //..........Methods...........................

    @Override
    public String toString() {
        return super.toString()+"products.Laptop{" +
                "CpuModel='" + CpuModel + '\'' +
                ", isGamming=" + isGamming +
                '}';
    }
}

