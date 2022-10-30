package rolls;

import menu.Menus;
import products.Category;
import products.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminManage implements Serializable {
    public static void addProductRequest() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        AdminPanel.addProReq();
    }
    public static void editProductRequest()throws IOException, FileNotFoundException,ClassNotFoundException{
        //loading..........
    }
    public static void showAccountsList() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        for(Seller temp : Seller.getSellersList())
            System.out.println(temp.toString());
        for(Buyer temp1 : Buyer.getBuyersList())
            System.out.println(temp1.toString());
        Menus.adminMethods();
    }
    public static void deleteAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        AdminPanel.deleteAccount();
    }
    public static void categoryList() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        for(Category temp : Admin.allCategories)
            System.out.println(temp.getName());
        Menus.adminMethods();
    }

}
