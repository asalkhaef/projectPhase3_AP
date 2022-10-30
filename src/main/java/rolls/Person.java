package rolls;

import buyprocess.BuyBill;
import buyprocess.SellBill;
import exceptions.InvalidEmail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Person implements Serializable {
    public enum Roll
    {
        ADMIN,SELLER,BUYER;
    }
    private String accountId;
    private String name;
    private String familyName;
    private String email;
    private String phoneNumber;
    private String password;
    private Roll role;
    private double wealth;
    private ArrayList<BuyBill> buyHistory;
    private ArrayList<SellBill> sellHistory;
    //............Constructor...............
    Person(String accountId,String name ,String familyName ,String email ,String phoneNumber ,
           String password ,Roll role ,double wealth)
    {
        this.accountId = accountId;
        this.email = email;
        this.familyName = familyName;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.wealth = wealth;
    }
    //..........Set&Get....................
    public String getAccountId() {
        return accountId;
    }
    public String getName() {
        return name;
    }
    public String getFamilyName() {
        return familyName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public double getWealth() {
        return wealth;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setWealth(double wealth) {
        this.wealth = wealth;
    }
    public ArrayList<BuyBill> getBuyHistory() {
        return buyHistory;
    }
    public ArrayList<SellBill> getSellHistory() {
        return sellHistory;
    }
    public void setBuyHistory(ArrayList<BuyBill> buyHistory) {
        this.buyHistory = buyHistory;
    }
    public void setSellHistory(ArrayList<SellBill> sellHistory) {
        this.sellHistory = sellHistory;
    }
    public Roll getRole() {
        return role;
    }
    public void setRole(Roll role) {
        this.role = role;
    }
    //..........Method...................
    //abstract void editAccount();
    @Override
    public String toString() {
        return "rolls.Person{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", wealth=" + wealth +
                ", buyHistory=" + buyHistory +
                ", sellHistory=" + sellHistory +
                '}';
    }
}
