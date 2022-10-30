package rolls;

import inter_face.SetDiscount;
import menu.Menus;
import products.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class SellerManage implements Serializable {
    public static void addProRequest() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        int number = Menus.addProMenu();
        switch (number)
        {
            case 1 :
                SellerPanel.addMobile();
                break;
            case 2 :
                SellerPanel.addLaptop();
                break;
            case 3 :
                SellerPanel.addClothes();
                break;
            case 4 :
                SellerPanel.addShoes();
                break;
            case 5 :
                SellerPanel.addTv();
                break;
            case 6 :
                SellerPanel.addRefrigerators();
                break;
            case 7 :
                SellerPanel.addStove();
                break;
            case 8 :
                SellerPanel.addFood();
                break;
        }
    Menus.sellerMethods();
    }
    public static void deleteProRequest() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        SellerPanel.deleteProduct();
    }
    public static void editProRequest()throws IOException, FileNotFoundException,ClassNotFoundException{
        int order = Menus.editProMenu();
        switch (order)
        {
            case 1 :

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            default:
            {
                System.out.println("invalid order! ");
                Menus.editProMenu();
            }

        }
    }
    public static void showProducts() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        SellerPanel.showProducts();
    }

}
