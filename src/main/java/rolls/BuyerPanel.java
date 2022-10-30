package rolls;

import buyprocess.BuyBill;
import buyprocess.Review;
import buyprocess.SellBill;
import exceptions.AccountBalanceEx;
import exceptions.InvalidInput;
import exceptions.LackOfInventory;
import sqlPack.MySql;
import menu.FirstPage;
import menu.Menus;
import products.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BuyerPanel implements Serializable {
    private static Scanner input = new Scanner(System.in);

    public static void buy(String idaccount) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        boolean found = false;
        for (Buyer temp1 : Buyer.getBuyersList())
            if (temp1.getAccountId().equals(idaccount)) {
                System.out.println("Enter id of product that you want add to your cart: ");
                String proId = input.next();
                for (Product temp : Admin.allProducts)
                    if (temp.getProductId().equals(proId)) {
                        if (temp.isStatus() == true) {
                            temp1.setCart(temp);
                            temp1.setBuyerProdects(temp);
                            System.out.println("This product successfully added to your cart");
                            temp.setStatus(false);
                            found = true;
                            Menus.buyerMethods(); //end of process
                        }
                        try{
                            if(found == false)
                            {
                                throw new LackOfInventory();
                            }
                        }
                        catch (LackOfInventory x) {
                            System.out.println(x.getMessage());
                            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                            MySql.getMySql().ExecuteSQL(sqlcmd);
                            Menus.buyerMethods();
                        }

                    }
            }
            else
            {
                System.out.println("account NotFound");
                FirstPage.firstMenu();
            }
    }

    public static void showcart() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        double totalMoney = 0.0;
        System.out.println("Enter your id : ");
        String id = input.next();
        for (Buyer temp : Buyer.getBuyersList())
            if (temp.getAccountId().equals(id)) {
                System.out.println(temp.getCart());
                System.out.println("do you want to delete any thing?(1 for YES 2 for NO)");
                int order = 0;
                try {
                    order=input.nextInt();
                }
                catch (InputMismatchException x){
                    System.out.println("type error!");
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    input = new Scanner(System.in);
                    BuyerPanel.showcart();
                }
                if (order == 1) {
                    System.out.println("Enter product id: ");
                    String idProduct = input.next();
                    for (int i = 0; i < temp.getCart().size(); i++) {
                        if (temp.getCart().get(i).getProductId().equals(idProduct))
                            temp.getCart().remove(i);
                        System.out.println("product removed!");
                        File b = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\users\\buyers","buyer"+temp.getCode()+".txt");
                        b.createNewFile();
                        FileOutputStream v = new FileOutputStream(b);
                        ObjectOutputStream c = new ObjectOutputStream(v);
                        ArrayList<Product> cart = temp.getCart();
                        c.writeObject(cart);
                        c.close();
                        v.close();
                        //....................................
                        System.out.println("@@ Loading shipping page @@ ");
                        System.out.println("Now you should accept shipping process!");
                        System.out.println("Enter your Address:");
                        temp.setAddress(input.next());
                        System.out.println("Enter your ZipCode:");
                        temp.setCodezip(input.next());
                        for (int j = 0; j < temp.getCart().size(); j++) {
                            totalMoney += temp.getCart().get(j).getPrice();
                        }
                        System.out.println("You should pay : " + totalMoney);
                        if (totalMoney <= temp.getWealth()) {
                            temp.setWealth(temp.getWealth() - totalMoney);
                        }
                        else {
                            try{
                                throw new AccountBalanceEx();
                            }
                            catch (AccountBalanceEx x)
                            {
                                System.out.println(x.getMessage());
                                String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                                MySql.getMySql().ExecuteSQL(sqlcmd);
                                FirstPage.firstMenu();
                            }
                        }
                        System.out.println("**Now we want creat buyproccess.BuyBill**");
                        System.out.println("input date of today : ");
                        String date = input.next();
                        ArrayList<Product> templist = new ArrayList<Product>();
                        for (int k = 0; k < temp.getCart().size(); k++) {
                            templist.add(temp.getCart().get(k));
                            temp.getCart().remove(k);
                        }

                        BuyBill a = new BuyBill(BuyBill.getProId(), date, totalMoney, false, templist);

                        for(int j = 0 ; j<templist.size() ; j++){
                            String sellerName = templist.get(i).getSeller();
                            String proName = templist.get(i).getName();
                            SellBill x = new SellBill(SellBill.getBillId(),date,templist.get(i).getPrice(),templist.get(i).getSeller(),false);

                            for(Seller p : Seller.getSellersList())
                                if(p.getFamilyName().equals(sellerName))
                                {
                                    File bill = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\users\\sellers","seller"+p.getCode());
                                    File bill1 =new File(bill,"sellBill.txt");
                                    bill1.createNewFile();
                                    FileOutputStream z = new FileOutputStream(bill1);
                                    ObjectOutputStream y = new ObjectOutputStream(z);
                                    y.writeObject(a);
                                }
                        }

                        File bill = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\users\\buyers","buyer"+temp.getCode());
                        File bill1 =new File(bill,"buyBill.txt");
                        bill1.createNewFile();
                        FileOutputStream x = new FileOutputStream(bill1);
                        ObjectOutputStream y = new ObjectOutputStream(x);
                        y.writeObject(a);

                        BuyBill.setProId(BuyBill.getProId() + 1);
                        temp.setBuyBills(a);
                        System.out.println("your Bill is : ");
                        System.out.println(a.toString());
                        Menus.buyerMethods();
                    }
                }
                if (order == 2) {
                    System.out.println("@@ Loading shipping page @@ ");
                    System.out.println("Now you should accept shipping process!");
                    System.out.println("Enter your Address:");
                    temp.setAddress(input.next());
                    System.out.println("Enter your ZipCode:");
                    temp.setCodezip(input.next());
                    for (int j = 0; j < temp.getCart().size(); j++) {
                        totalMoney += temp.getCart().get(j).getPrice();
                    }
                    System.out.println("You should pay : " + totalMoney);
                    if (totalMoney <= temp.getWealth()) {
                        temp.setWealth(temp.getWealth() - totalMoney);
                    }
                    else {
                        try{
                            throw new AccountBalanceEx();
                        }
                        catch (AccountBalanceEx x)
                        {
                            System.out.println(x.getMessage());
                            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                            MySql.getMySql().ExecuteSQL(sqlcmd);
                            FirstPage.firstMenu();
                        }
                    }
                    System.out.println("**Now we want create subprocess.BuyBill**");
                    System.out.println("input date of today : ");
                    String date = input.next();
                    ArrayList<Product> templist = new ArrayList<Product>();
                    for (int k = 0; k < temp.getCart().size(); k++) {
                        templist.add(temp.getCart().get(k));
                        temp.getCart().remove(k);
                    }
                    BuyBill a = new BuyBill(BuyBill.getProId(), date, totalMoney, false, templist);
                    BuyBill.setProId(BuyBill.getProId() + 1);
                    temp.setBuyBills(a);
                    System.out.println("your Bill is : ");
                    System.out.println(a.toString());
                    Menus.buyerMethods();
                }
                else{
                    try {
                        throw new InvalidInput();
                    }
                    catch (InvalidInput x){
                        System.out.println(x.getMessage());
                        String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                        MySql.getMySql().ExecuteSQL(sqlcmd);
                        BuyerPanel.showcart();
                    }
                }

            }

    }

    public static void rateProdect() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        boolean submite = false;
        System.out.println("*** this is rateing panel ***");
        System.out.println("Please enter you id : => ");
        String id = input.next();
        for (Buyer temp : Buyer.getBuyersList()) {
            if (temp.getAccountId().equals(id)) {
                System.out.println("you buy history list is : ");
                for (Product temp1 : temp.getBuyerProdects())
                    System.out.println(temp1.toString());
            }
            System.out.println("Please enter productid that you want to rate : => ");
            String proId = input.next();
            {
                for (Product temp4 : temp.getBuyerProdects()) {
                    if (temp4.getProductId().equals(proId)) {
                        System.out.println("rate this product from 1 to 20");
                        double rate = 0;
                        try {
                            rate = input.nextDouble();
                            if(rate < 0 || rate > 20)
                                throw new InvalidInput();
                        }
                        catch (InputMismatchException x){
                            System.out.println("type error!");
                            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
                            MySql.getMySql().ExecuteSQL(sqlcmd);
                            input = new Scanner(System.in);
                            BuyerPanel.rateProdect();
                        }
                        catch (InvalidInput y){
                            System.out.println(y.getMessage());
                            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",y.getMessage());
                            MySql.getMySql().ExecuteSQL(sqlcmd);
                            BuyerPanel.rateProdect();
                        }
                        temp4.setRate(rate);
                        if(temp4 instanceof Mobile)
                        {
                            File rateing = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\digiProduct\\mobile\\mobileList","mobpoint"+((Mobile) temp4).getCode()+".txt");
                            rateing.createNewFile();
                            RandomAccessFile submitateing = new RandomAccessFile(rateing,"rws");
                            submitateing.writeDouble(rate);
                            submitateing.close();
                        }
                        temp4.setRateNumber(temp4.getRateNumber() + 1);
                        submite = true;
                        System.out.println("Done ! thanks");
                    }
                }
                if(submite == false)
                    System.out.println("You did not buy this product!");
            }
        }
        Menus.buyerMethods();
    }

    public static void ReviewProduct() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        boolean submited = false;
        System.out.println("*** this is review panel ***");
        System.out.println("Please enter you id : => ");
        String id = input.next();
        for (Buyer temp : Buyer.getBuyersList()) {
            if (temp.getAccountId().equals(id)) {
                System.out.println("you buy history list is : ");
                for (Product temp1 : temp.getBuyerProdects())
                    System.out.println(temp1.toString());
            }
            System.out.println("Please enter productid that you want to review : => ");
            String proId = input.next();
            {
                for (Product temp4 : temp.getBuyerProdects()) {
                    if (temp4.getProductId().equals(proId)) {
                        System.out.println("Write a review for this product");
                        String review = input.nextLine();
                        input.next();
                        Review a = new Review(temp.getName() + temp.getFamilyName(), temp4.getProductId() + temp4.getName(), review, Review.status.PENDING, true);
                        temp4.setReviewList(a);
                        if(temp4 instanceof Clothes)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\clothing\\clothes\\clotheList","cloth"+((Clothes) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof Shoes)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\clothing\\shoes\\shoeList","shoe"+((Shoes) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof Food)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\food\\foodList","food"+((Food) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof Laptop)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\digiProduct\\laptop\\laptopList","laptop"+((Laptop) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof Mobile)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\digiProduct\\mobile\\mobileList","mobile"+((Mobile) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof Refrigerators)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\homeAppliances\\refrigerator\\refrigeratorList","refrigerator"+((Refrigerators) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof Stove)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\homeAppliances\\stove\\stoveList","stove"+((Stove) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }
                        else if(temp4 instanceof TV)
                        {
                            File yourReview = new File("D:\\programming\\INTJ\\Project1\\ProjectOne\\saveData\\category\\homeAppliances\\tv\\tvList","tv"+((TV) temp4).getCode());
                            if(!yourReview.exists())
                                yourReview.mkdirs();
                            File s = new File(yourReview,"review.txt");
                            FileOutputStream out = new FileOutputStream(s);
                            ObjectOutputStream obj = new ObjectOutputStream(out);
                            obj.writeObject(a);
                            obj.close();
                            out.close();
                        }

                        System.out.println("Done ! thanks");
                        submited = true;
                    }
                }
                if(submited == false)
                    System.out.println("You did not buy this product!");
            }
        }
        Menus.buyerMethods();
    }
}
