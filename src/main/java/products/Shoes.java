package products;

import rolls.Admin;

import java.io.Serializable;

public class Shoes extends Clothing implements Serializable {
    public enum ShoeType
    {
        BOOTS,SNEAKERS,FLIPFLOPS,SANDAL,OXFORDS;
    }
    private int shoeSize;
    private ShoeType shoeType;
    private String address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/clothing/shoes/shoesList";
    static int index = 0;
    private int code;
    //........Constructor....................
    public Shoes( String productId, String name1, String company, double price,
                 String seller, String detail, String producerCountry,
                 Material clothMaterial, int shoeSize, ShoeType shoeType) {
        super( productId, name1, company, price, seller, true, detail,
                producerCountry, clothMaterial);
        this.code = ++index;
        this.shoeSize = shoeSize;
        this.shoeType = shoeType;
        Admin.allProducts.add(this);
        this.setTag("shoe");
    }
    //..........Set&Get........................
    public int getShoeSize() {
        return shoeSize;
    }
    public ShoeType getShoeType() {
        return shoeType;
    }
    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }
    public void setShoeType(ShoeType shoeType) {
        this.shoeType = shoeType;
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
        Shoes.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //......Methods............................
    @Override
    public String toString() {
        return super.toString()+"products.Shoes{" +
                "shoeSize=" + shoeSize +
                ", shoeType=" + shoeType +
                '}';
    }
}
