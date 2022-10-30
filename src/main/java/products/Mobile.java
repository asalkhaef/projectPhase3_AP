package products;

import rolls.Admin;

import java.io.Serializable;

public class Mobile extends Digiproducts implements Serializable {
    private int simNumber;
    private int cameraResolution;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/digiProduct/mobile/mobileList";
    static int index = 0;
    private int code;
    //.....Constructor....................
    public Mobile(String productId, String name1, String company,
                  double price, String seller,String detail, int memory,
                  int ram, String operatingSystem, double weight, String dimensions, int simNumber,
                  int cameraResolution) {
        super(productId, name1, company, price, seller, true ,
                detail, memory, ram, operatingSystem, weight, dimensions);
        this.code=++index;
        this.simNumber = simNumber;
        this.cameraResolution = cameraResolution;
        Admin.allProducts.add(this);
        this.setTag("mobile");
    }
    //.........Set&Get......................
    public int getSimNumber() {
        return simNumber;
    }
    public int getCameraResolution() {
        return cameraResolution;
    }
    public void setSimNumber(int simNumber) {
        this.simNumber = simNumber;
    }
    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
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
        Mobile.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //......Methods..........................
    @Override
    public String toString() {
        return super.toString()+"products.Mobile{" +
                "simNumber=" + simNumber +
                ", cameraResolution=" + cameraResolution +
                '}';
    }
}
