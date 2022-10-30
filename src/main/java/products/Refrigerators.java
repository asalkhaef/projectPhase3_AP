package products;

import rolls.Admin;

import java.io.Serializable;

public class Refrigerators extends HomeAppliances implements Serializable {
    public enum RefType
    {
        TOP_FREEZER,BOTTOM_FREEZER,FRENCH_DOOR,FOR_RESTAURANT;
    }
    private int capacity;
    private RefType refrigeratorsType;
    private boolean withFreezer;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/homeAppliances/refrigerator/refrigeratorList";
    static int index = 0;
    private int code;
    //....Constructor.................
    public Refrigerators(String productId, String name1, String company, double price,
                         String seller, String detail, Degree degreeOfConsumption,
                         boolean warranty, int capacity, RefType refrigeratorsType, boolean withFreezer) {
        super(productId, name1, company, price, seller, true, detail,
                degreeOfConsumption, warranty);
        this.code = ++index;
        this.capacity = capacity;
        this.refrigeratorsType = refrigeratorsType;
        this.withFreezer = withFreezer;
        Admin.allProducts.add(this);
        this.setTag("refrigerator");
    }
    //..........Set&Get...............
    public int getCapacity() {
        return capacity;
    }
    public RefType getRefrigeratorsType() {
        return refrigeratorsType;
    }
    public boolean isWithFreezer() {
        return withFreezer;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setRefrigeratorsType(RefType refrigeratorsType) {
        this.refrigeratorsType = refrigeratorsType;
    }
    public void setWithFreezer(boolean withFreezer) {
        this.withFreezer = withFreezer;
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
        Refrigerators.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //.........Methods..................
    @Override
    public String toString() {
        return super.toString()+"products.Refrigerators{" +
                "capacity=" + capacity +
                ", refrigeratorsType=" + refrigeratorsType +
                ", withFreezer=" + withFreezer +
                '}';
    }
}