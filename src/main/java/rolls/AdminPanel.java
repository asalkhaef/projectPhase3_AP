package rolls;

import exceptions.InvalidInput;
import sqlPack.MySql;
import menu.Menus;
import products.*;

import java.io.*;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminPanel implements Serializable {
    private static Scanner input = new Scanner(System.in);
    public static void deleteAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Enter Account id : ");
        String id = input.next();
        for(int i = 0 ; i < Admin.allUsers.size() ; i++)
            if (Admin.allUsers.get(i).equals(id))
            {
                Admin.allUsers.remove(i);
                System.out.println("Account deleted!");
            }
        Menus.adminMethods();
    }
    public static void addProReq() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {

        for(int i = 0 ; i<Admin.getAddProductReq().size() ; i++)
        {
            System.out.println(Admin.getAddProductReq().get(i).toString());
            System.out.println("do you want accept this product?(1 for YES and 2 for NO)");
            int order = 0;
            try{
                order = input.nextInt();
            }
            catch (InputMismatchException x)
            {
                System.out.println("type error!");
                input = new Scanner(System.in);
                AdminPanel.addProReq();
            }
            switch (order)
            {
                case 1:
                {
                    boolean found = false;
                    if(!Admin.allProducts.contains(Admin.getAddProductReq().get(i)))
                    {
                        Admin.allProducts.add(Admin.getAddProductReq().get(i));
                    }
                    while (found == false)
                    {
                        for(Product temp : Admin.allProducts)
                        {
                            if(temp.getProductId().equals(Admin.getAddProductReq().get(i).getProductId()))
                            {
                                for(Seller temp2 : Seller.getSellersList())
                                {
                                    if(temp2.getFamilyName().equals(temp.getSeller()))
                                    {
                                        if(!temp2.getProList().contains(temp))
                                        {
                                            System.out.println(Admin.getAddProductReq());
                                            Admin.getAddProductReq().remove(temp);
                                            System.out.println(Admin.getAddProductReq());
                                            found = true;
                                        }
                                    }
                                }
                            }

                            if(temp.getTag().equals("tv"))
                                Admin.homeAppliances.setCategoryList(temp);
                            if(temp.getTag().equals("refrigerator"))
                                Admin.homeAppliances.setCategoryList(temp);
                            if(temp.getTag().equals("stove"))
                                Admin.homeAppliances.setCategoryList(temp);
                            if(temp.getTag().equals("cloth"))
                                Admin.clothing.setCategoryList(temp);
                            if(temp.getTag().equals("shoe"))
                                Admin.clothing.setCategoryList(temp);
                            if(temp.getTag().equals("mobile"))
                                Admin.digiProducts.setCategoryList(temp);
                            if(temp.getTag().equals("laptop"))
                                Admin.digiProducts.setCategoryList(temp);
                            if(temp.getTag().equals("food"))
                                Admin.food.setCategoryList(temp);
                        }
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("you reject product");
                    Admin.getAddProductReq().remove(i);
                    break;
                }
                default:
                {
                    try {
                        throw new InvalidInput();
                    }
                    catch (InvalidInput x)
                    {
                        System.out.println(x.getMessage());
                        AdminPanel.addProReq();
                    }
                }
            }
        }
        Menus.adminMethods();
    }
    public static void addSellerReq() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        for(int i = 0 ; i<Admin.getAddSellerReq().size() ; i++)
        {
            System.out.println(Admin.getAddSellerReq().get(i).toString());
            System.out.println("do you want accept this rolls.Seller?(1 for YES and 2 for NO)");
            int order = 0;
            try {
                order = input.nextInt();
            }
            catch (InputMismatchException x)
            {
                System.out.println(x.getMessage());
                String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                MySql.getMySql().ExecuteSQL(sqlcmd);
                input = new Scanner(System.in);
                AdminPanel.addSellerReq();
            }
            switch (order)
            {
                case 1 :
                {
                    Seller.getSellersList().add(Admin.getAddSellerReq().get(i));
                    for(Seller temp1 : Admin.allPendingsellers)
                    {
                        if(temp1.getAccountId().equals(Admin.getAddSellerReq().get(i).getAccountId()))
                        {
                            Seller.setSellersList(temp1);

                            String sqlcmd = String.format("INSERT INTO sellerlist (idCode,userId,firstName,lastName,password,wealth) VALUES(%d,'%s','%s','%s','%s',%f)",temp1.getCode(),temp1.getAccountId(),temp1.getName(),temp1.getFamilyName(),temp1.getPassword(),temp1.getWealth());
                            MySql.getMySql().ExecuteSQL(sqlcmd);

                            String sqlcmd2 = String.format("INSERT INTO s_emaillist (idCode,email) VALUES(%d,'%s')",temp1.getCode(),temp1.getEmail());
                            MySql.getMySql().ExecuteSQL(sqlcmd2);

                            String sqlcmd3 = String.format("INSERT INTO s_phonelist (idCode,phoneNumber) VALUES(%d,'%s')",temp1.getCode(),temp1.getPhoneNumber());
                            MySql.getMySql().ExecuteSQL(sqlcmd3);

                        }
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("you reject rolls.Seller");
                    Admin.getAddSellerReq().remove(i);
                    break;
                }
                default:
                {
                    try {
                        throw new InvalidInput();
                    }
                    catch (InvalidInput x){
                        System.out.println(x.getMessage());
                        String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                        MySql.getMySql().ExecuteSQL(sqlcmd);
                        AdminPanel.addSellerReq();
                    }
                }
            }
        }
        Menus.adminMethods();
    }

}
