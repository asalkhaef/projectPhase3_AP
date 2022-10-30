package products;

import rolls.Admin;

import java.io.Serializable;

public class TV extends HomeAppliances implements Serializable {
    private int resolution;
    private int screenSize;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/homeAppliances/tv/tvList";
    static int index = 0;
    private int code;
    //.....Constructor.................
    public TV( String productId, String name1, String company, double price,
              String seller, String detail, Degree degreeOfConsumption,
              boolean warranty, int resolution, int screenSize) {
        super( productId, name1, company, price, seller, true, detail, degreeOfConsumption,
                warranty);
        this.code = ++index;
        this.resolution = resolution;
        this.screenSize = screenSize;
        Admin.allProducts.add(this);
        this.setTag("tv");
    }
    //.....Set&Get.........................
    public int getResolution() {
        return resolution;
    }
    public int getScreenSize() {
        return screenSize;
    }
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }
    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
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
        TV.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }
    //.....Methods...........................

    @Override
    public String toString() {
        return super.toString()+"products.TV{" +
                "resolution=" + resolution +
                ", screenSize=" + screenSize +
                '}';
    }
}
