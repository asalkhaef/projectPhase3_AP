package menu;

import exceptions.InvalidInput;
import rolls.*;
import sqlPack.MySql;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menus implements Serializable {
    private static Scanner input = new Scanner(System.in);

    public static int addProMenu()throws IOException, FileNotFoundException {
        System.out.println("*** Add product Menu ***");
        System.out.println("what do you want to add? ");
        System.out.println("Digital category: ");
        System.out.println("1 : products.Mobile ");
        System.out.println("2 : products.Laptop ");
        System.out.println("products.Clothing category: ");
        System.out.println("3 : products.Clothes ");
        System.out.println("4 : products.Shoes ");
        System.out.println("Homeappliances category: ");
        System.out.println("5 : products.TV ");
        System.out.println("6 : products.Refrigerators ");
        System.out.println("7 : products.Stove ");
        System.out.println("products.Food category: ");
        System.out.println("8 : products.Food ");
        System.out.println();
        System.out.println("Enter your order : => ");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            input = new Scanner(System.in);
            Menus.addProMenu();
        }
        return order;
    }

    public static int deleteProMenu()throws IOException, FileNotFoundException {
        System.out.println("*** Delete product Menu ***");
        System.out.println("what do you want to delete? ");
        System.out.println("Digital category: ");
        System.out.println("1 : products.Mobile ");
        System.out.println("2 : products.Laptop ");
        System.out.println("products.Clothing category: ");
        System.out.println("3 : products.Clothes ");
        System.out.println("4 : products.Shoes ");
        System.out.println("Homeappliances category: ");
        System.out.println("5 : products.TV ");
        System.out.println("6 : products.Refrigerators ");
        System.out.println("7 : products.Stove ");
        System.out.println("products.Food category: ");
        System.out.println("8 : products.Food ");
        System.out.println();
        System.out.println("Enter your order : => ");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            input = new Scanner(System.in);
            Menus.deleteProMenu();
        }
        return order;
    }

    public static int editProMenu()throws IOException, FileNotFoundException {
        System.out.println("*** Edit product Menu ***");
        System.out.println("what do you want to edit? ");
        System.out.println("Digital category: ");
        System.out.println("1 : products.Mobile ");
        System.out.println("2 : products.Laptop ");
        System.out.println("products.Clothing category: ");
        System.out.println("3 : products.Clothes ");
        System.out.println("4 : products.Shoes ");
        System.out.println("Homeappliances category: ");
        System.out.println("5 : products.TV ");
        System.out.println("6 : products.Refrigerators ");
        System.out.println("7 : products.Stove ");
        System.out.println("products.Food category: ");
        System.out.println("8 : products.Food ");
        System.out.println();
        System.out.println("Enter your order : => ");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            input = new Scanner(System.in);
            Menus.editProMenu();
        }
        return order;
    }

    public static void buyerMethods() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("*** Welcome to your panel ***");
        System.out.println("These are your accesses : ");
        System.out.println("1 : Show Products ");
        System.out.println("2 : Filter Products ");
        System.out.println("3 : Buy Products ");
        System.out.println("4 : showCart ");
        System.out.println("5 : rate ");
        System.out.println("6 : write a review ");
        System.out.println("7 : editProfile ");
        System.out.println("8 : delete account");
        System.out.println("9: MainMenu ");
        System.out.println("Enter your order : => ");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            input = new Scanner(System.in);
            Menus.buyerMethods();
        }
        switch (order) {
            case 1:
                BuyerManage.showProducts();
                break;
            case 2:
                BuyerManage.filterProduct();
                break;
            case 3: {
                System.out.println("Enter your id : ");
                String id = input.next();
                BuyerPanel.buy(id);
                break;
            }
            case 4:
                BuyerManage.showCart();
                break;
            case 5:
                BuyerPanel.rateProdect();
                break;
            case 6:
                BuyerPanel.ReviewProduct();
                break;
            case 7:
                AccountOperation.editAccount();
                break;
            case 8:
                AccountOperation.deleteAccount();
                break;
            case 9:
                FirstPage.firstMenu();
            default: {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    Menus.buyerMethods();
                }
            }
        }
    }

    public static void sellerMethods() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("*** Welcome to your panel ***");
        System.out.println("These are your accesses : ");
        System.out.println("1 : Show Products ");
        System.out.println("2 : Add product to my store ");
        System.out.println("3 : Delete product from my store");
        System.out.println("4 : Edit profile");
        System.out.println("5 : delete account");
        System.out.println("6 : MainMenu");
        System.out.println("Enter your order : => ");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            input = new Scanner(System.in);
            Menus.sellerMethods();
        }
        switch (order) {
            case 1:
                SellerManage.showProducts();
                break;
            case 2:
                SellerManage.addProRequest();
                break;
            case 3:
                SellerManage.deleteProRequest();
                break;
            case 4:
                AccountOperation.editAccount();
                break;
            case 5:
                AccountOperation.deleteAccount();
                break;
            case 6:
                FirstPage.firstMenu();
                break;
            default: {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    Menus.sellerMethods();
                }
            }
        }
    }

    public static void adminMethods() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("*** Welcome to your panel ***");
        System.out.println("These are your accesses : ");
        System.out.println("1 : Edit profile ");
        System.out.println("2 : Show add product requests ");
        System.out.println("3 : Delete an Account");
        System.out.println("4 : Show add account request");
        System.out.println("5 : Show category list");
        System.out.println("6 : Show accounts list");
        System.out.println("7 : MainMenu ");
        System.out.println("Enter your order : => ");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            Menus.adminMethods();
        }
        switch (order) {
            case 1:
                AccountOperation.editAccount();
                break;
            case 2:
                AdminManage.addProductRequest();
                break;
            case 3:
                AdminManage.deleteAccount();
                break;
            case 4:
                AdminPanel.addSellerReq();
                break;
            case 5:
                AdminManage.categoryList();
                break;
            case 6:
                AdminManage.showAccountsList();
                break;
            case 7:
                FirstPage.firstMenu();
                break;
            default: {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",y.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    Menus.adminMethods();
                }
            }
        }
    }
}
