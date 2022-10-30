package products;

import java.io.Serializable;

public class Food extends Product implements Serializable {
    private String productionDate;
    private String expirationDate;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/food/foodList";
    static int index = 0;
    private int code;
    //.............Constructor................
    public Food(String productId, String name1, String company,
                double price, String seller, String detail,
                String productionDate, String expirationDate) {
        super( productId, name1, company, price, seller, true, detail);
        this.code = ++index;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.setTag("food");
    }
    //..........Set&Get.......................
    public String getProductionDate() {
        return productionDate;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
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
        Food.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //.........Methods........................
    @Override
    public String toString() {
        return super.toString()+"products.Food{" +
                "productionDate='" + productionDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}