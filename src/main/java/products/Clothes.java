package products;

import buyprocess.Discount;
import inter_face.SetDiscount;
import rolls.Admin;

import java.io.Serializable;

public class Clothes extends Clothing implements SetDiscount , Serializable {
    public enum Size
    {
        XXL,XL,L,M,S,XS;
    }
    public enum Kind
    {
        TSHIRT,PANTS,DRESS,COAT,HOODIES;
    }
    private Size clothSize;
    private Kind clothKind;
    private String  address = "D:/programming/INTJ/Project1/ProjectOne/saveData/category/clothing/clothes/clothesList";
    static int index = 0;
    private int code;
    //............Constructor.................
    public Clothes(String productId, String name1, String company, double price,
                   String seller, String detail, String producerCountry,
                   Material clothMaterial, Size clothSize, Kind clothKind) {
        super( productId, name1, company, price, seller, true, detail, producerCountry, clothMaterial);
        this.code = ++index;
        this.clothSize = clothSize;
        this.clothKind = clothKind;
        Admin.allProducts.add(this);
        this.setTag("cloth");
    }
    //............Set&Get......................
    public Size getClothSize() {
        return clothSize;
    }
    public Kind getClothKind() {
        return clothKind;
    }
    public void setClothSize(Size clothSize) {
        this.clothSize = clothSize;
    }
    public void setClothKind(Kind clothKind) {
        this.clothKind = clothKind;
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
        Clothes.index = index;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //..........Methods........................
    @Override
    public String toString() {
        return super.toString()+"products.Clothes{" +
                "clothSize=" + clothSize +
                ", clothKind=" + clothKind +
                '}';
    }

    @Override
    public void addDiscountCode(double discountPercentage, int discountNum, String expire) {
        Discount z = new Discount(discountPercentage,expire,discountNum,"cth");
        System.out.println("code of this discount is:" + z.getDiscountCode());
        this.setDiscountList(z);
    }

    @Override
    public void normalDiscount() {

    }
}
