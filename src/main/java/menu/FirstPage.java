package menu;

import exceptions.InvalidInput;
import products.Product;
import rolls.AccountOperation;
import rolls.Admin;
import rolls.Buyer;
import rolls.BuyerPanel;
import sqlPack.MySql;

import java.io.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FirstPage implements Serializable{
    private static Scanner input = new Scanner(System.in);
    public static void firstMenu () throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("****** Welcome to Small-Digi ******");
        System.out.println("Please select number of your order:");
        System.out.println("1 : Go to MyAccount");
        System.out.println("2 : Go to ProductsPage");
        System.out.println("3 : Go to buy process");
        System.out.println("4 : Exit from this Web");
        System.out.println("Your order is =>");
        int order1 = 0;
        try{
            order1 = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            FirstPage.firstMenu();
        }
        switch (order1) {
            case 1:
                    secoundMenu();
                    break;
            case 2:
                    FirstPage.fourthMenu();
                    break;
            case 3:
            {
                System.out.println("enter your id : ");
                String idaccount = input.next();
                for(Buyer temp : Buyer.getBuyersList())
                {
                    if(!temp.isSignIn())
                    {
                        System.out.println("you are not signIn");
                        FirstPage.thirdMenu();
                    }
                    else
                    {
                        BuyerPanel.buy(idaccount);
                    }
                }
            }
            case 4 :
            {
                System.out.println("Best Wishes! GOODBYE ");
                System.exit(0);
            }
            default:
            {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",y.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    FirstPage.firstMenu();
                }
            }

        }
    }
    public static void secoundMenu() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Please select number of your order:");
        System.out.println("1 : SignIN");
        System.out.println("2 : SignUP");
        System.out.println("3 : SignOUT");
        System.out.println("4 : editAccount");
        System.out.print("Your order is =>");
        int order2 = 0;
        try{
            order2 = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            FirstPage.secoundMenu();
        }
        switch (order2){
            case 1:
            {
                AccountOperation.signIn();
                break;
            }
            case 2:
            {
                AccountOperation.signUp();
                break;
            }
            case 3:
            {
                AccountOperation.signOut();
                FirstPage.firstMenu();
                break;
            }
            case 4:
            {
                AccountOperation.editAccount();
                break;
            }
            default:
            {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",y.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    FirstPage.secoundMenu();
                }
            }

        }
    }
    public static void thirdMenu() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Please select number of your order:");
        System.out.println("1 : SignIN");
        System.out.println("2 : SignUP");
        System.out.print("Your order is =>");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            FirstPage.thirdMenu();
        }
        switch (order) {
            case 1:
                AccountOperation.signIn();
                break;
            case 2:
                AccountOperation.signUp();
                break;
            default: {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",y.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    FirstPage.thirdMenu();
                }
            }
        }
    }
    public static void fourthMenu() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Select category: ");
        System.out.println("1 : digiProducts");
        System.out.println("2 : homeAppliances");
        System.out.println("3 : clothing");
        System.out.println("4 : food");
        System.out.println("5 : allProduct!");
        System.out.println("6 : search for special product by product id ");
        System.out.println("7 : main menu");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            FirstPage.fourthMenu();
        }
        switch (order)
        {
            case 1:
            {
                for(Product temp : Admin.digiProducts.getCategoryList())
                    System.out.println(temp.toString());
                break;
            }
            case 2:
            {
                for(Product temp : Admin.homeAppliances.getCategoryList())
                    System.out.println(temp.toString());
                break;
            }
            case 3:
            {
                for(Product temp : Admin.clothing.getCategoryList())
                    System.out.println(temp.toString());
                break;
            }
            case 4:
            {
                for(Product temp : Admin.food.getCategoryList())
                    System.out.println(temp.toString());
                break;
            }
            case 5:
            {
                for (Product temp : Admin.allProducts)
                    System.out.println(temp.toString());
                break;
            }
            case 6:
            {
                System.out.println("Enter product id : ");
                String id = input.next();
                for (Product temp : Admin.allProducts)
                    if(temp.getProductId().equals(id))
                        System.out.println(temp.toString());
                break;
            }
            case 7:
            {
                FirstPage.firstMenu();
                break;
            }
            default:
            {
                try {
                    throw new InvalidInput();
                }
                catch (InvalidInput y){
                    System.out.println(y.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",y.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    FirstPage.fourthMenu();
                }
            }
        }
        FirstPage.firstMenu();

    }


}
