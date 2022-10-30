package buyprocess;
import java.io.Serializable;
import java.util.Random;

public class Discount implements Serializable {
    private double discountPercent;
    private String expireDate;
    private int number;
    private String discountCode;
    //....Constructor......................
    public Discount(double discountPercent, String expireDate, int number,String productName) {
        this.discountPercent = discountPercent;
        this.expireDate = expireDate;
        this.number = number;
        Random code = new Random(); //settingDiscountCode
        int disCode = 1000+code.nextInt(9999);
        this.discountCode=productName+String.valueOf(disCode);
    }
    //......Set&Get.........................
    public double getDiscountPercent() {
        return discountPercent;
    }
    public String getExpireDate() {
        return expireDate;
    }
    public int getNumber() {
        return number;
    }
    public String getDiscountCode() {
        return discountCode;
    }
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
