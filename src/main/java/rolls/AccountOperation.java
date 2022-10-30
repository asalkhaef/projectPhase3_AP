package rolls;

import exceptions.InvalidEmail;
import exceptions.InvalidInput;
import exceptions.InvalidPhoneNum;
import sqlPack.MySql;
import menu.FirstPage;
import menu.Menus;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountOperation implements Serializable {
    private static Scanner input = new Scanner(System.in);
    public static void signUp() throws IOException, FileNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("accountId : ");
        String accountId = input.next();
        System.out.println("roll (buyer of seller) : ");
        Person.Roll roll = null;
        try {
            roll = Person.Roll.valueOf(input.next().toUpperCase());
        }
        catch (IllegalArgumentException x)
        {
            System.out.println("illegal roll try again!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","illegal roll try again!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            AccountOperation.signUp();
        }
        if(roll == Person.Roll.BUYER)   //avoid creating same accounts
        {
            for(Buyer temp : Buyer.getBuyersList())
                if(temp.getAccountId().equals(accountId))
                {
                    System.out.println("there is already an account with this id");
                    FirstPage.firstMenu();
                }
                else
                    continue;   //just for better look
        }
        if(roll == Person.Roll.SELLER)
        {
            for(Seller temp : Seller.getSellersList())
                if(temp.getAccountId().equals(accountId))
                {
                    System.out.println("there is already an account with this id");
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","there is already an account with this id");
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    FirstPage.firstMenu();
                }
                else
                    continue;
        }
        System.out.println("name : ");
        String name = input.next();
        System.out.println("familyName : ");
        String familyName = input.next();
        System.out.println("email : ");
        String email = input.next();
        try{
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; //first
            Pattern pattern = Pattern.compile(emailRegex); //second
            Matcher matcher1 = pattern.matcher(email);
            if(!matcher1.matches())
                throw new InvalidEmail();
        }
        catch (InvalidEmail x)
        {
            System.out.println(x.getMessage());
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
            MySql.getMySql().ExecuteSQL(sqlcmd);
            AccountOperation.signUp();
        }
        System.out.println("phoneNumber : ");
        String phoneNumber = input.next();
        try{
            String phoneRegex = "^[0][9]\\d{9}$";
            Pattern patternPhone = Pattern.compile(phoneRegex);
            Matcher phoneMatcher = patternPhone.matcher(phoneNumber);
            if(!phoneMatcher.matches())
                throw new InvalidPhoneNum();
        }
        catch (InvalidPhoneNum x)
        {
            System.out.println(x.getMessage());
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
            MySql.getMySql().ExecuteSQL(sqlcmd);
            AccountOperation.signUp();
        }
        System.out.println("password : ");
        String password = input.next();
        System.out.println("wealth : ");
        int wealth = 0;
        try{
            wealth = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            AccountOperation.signUp();
        }

        if (roll == Person.Roll.BUYER)
        {
            Buyer x = new Buyer(accountId,name,familyName,email,phoneNumber,password,wealth);
            String sqlcmd = String.format("INSERT INTO buyerlist (idCode,userId,firstName,lastName,password,wealth) VALUES(%d,'%s','%s','%s','%s',%d)",x.getCode(),accountId,name,familyName,password,wealth);
            MySql.getMySql().ExecuteSQL(sqlcmd);

            String sqlcmd2 = String.format("INSERT INTO b_emaillist (idCode,email) VALUES(%d,'%s')",x.getCode(),email);
            MySql.getMySql().ExecuteSQL(sqlcmd2);

            String sqlcmd3 = String.format("INSERT INTO b_phonelist (idCode,phoneNumber) VALUES(%d,'%s')",x.getCode(),phoneNumber);
            MySql.getMySql().ExecuteSQL(sqlcmd3);

            if(!Buyer.getBuyersList().contains(x)){
                Buyer.setBuyersList(x);
            }
            if(!Admin.allUsers.contains(x))
            {
                Admin.allUsers.add(x);
            }
            Menus.buyerMethods();
        }

        if (roll == Person.Roll.SELLER)
        {
            Seller x = new Seller(accountId,name,familyName,email,phoneNumber,password,wealth);
            Admin.allUsers.add(x);
            Admin.allPendingsellers.add(x);
            Admin.setAddSellerReq(x);
            Menus.sellerMethods();
        }

    }
    public static void signIn() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {

        System.out.println("accountId : ");
        String accountId = input.next();
        System.out.println("roll (buyer of seller) : ");
        Person.Roll roll = null;
        try{
            roll = Person.Roll.valueOf(input.next().toUpperCase());
        }
        catch (IllegalArgumentException x)
        {
            System.out.println("illegal roll try again!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","illegal roll try again!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            AccountOperation.signIn();
        }
        System.out.println(roll);

        System.out.println("password : ");
        String password = input.next();
        if(roll == Person.Roll.SELLER)
        {
            String sqlcmd = "SELECT * FROM sellerlist INNER JOIN s_phonelist ON sellerlist.idCode = s_phonelist.idCode INNER JOIN s_emaillist ON s_emaillist.idCode = s_phonelist.idCode ";
            ResultSet resultSet = MySql.getMySql().ExecuteQuery(sqlcmd);
            while (resultSet.next()){
                if((resultSet.getString("userId").equals(accountId)) && (resultSet.getString("password")).equals(password))
                {
                    Seller x = new Seller(resultSet.getString("userId"),resultSet.getString("firstName"),resultSet.getString("lastName"),resultSet.getString("email"),resultSet.getString("phoneNumber"),resultSet.getString("password"),resultSet.getDouble("wealth"));
                    x.setCode(resultSet.getInt("idCode"));
                    Seller.setIndex(Seller.getIndex() - 1);
                    Menus.sellerMethods();
                }

            }
        }

        if(roll == Person.Roll.BUYER)
        {
            {
                String sqlcmd = "SELECT * FROM buyerlist INNER JOIN b_phonelist ON buyerlist.idCode = b_phonelist.idCode INNER JOIN b_emaillist ON b_emaillist.idCode = b_phonelist.idCode ";

                ResultSet resultSet = MySql.getMySql().ExecuteQuery(sqlcmd);
                while (resultSet.next()){
                    if((resultSet.getString("userId").equals(accountId)) && (resultSet.getString("password")).equals(password))
                    {
                        Seller x = new Seller(resultSet.getString("userId"),resultSet.getString("firstName"),resultSet.getString("lastName"),resultSet.getString("email"),resultSet.getString("phoneNumber"),resultSet.getString("password"),resultSet.getDouble("wealth"));
                        x.setCode(resultSet.getInt("idCode"));
                        Buyer.setIndex(Buyer.getIndex() - 1);
                        Menus.buyerMethods();
                    }

                }
            }
        }

        if(roll == Person.Roll.ADMIN)
        {
            if(accountId.equals("admin") && password.equals("admin"))
            {
                System.out.println("HELLO ADMIN!");
                Admin.getAdmin().setSignIn(true);
                Menus.adminMethods();
            }
            else
                System.out.println(" Sorry you are not Admin.Admin");
                FirstPage.firstMenu();
        }

    }

    public static void signOut() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Enter your id: ");
        String id = input.next();
        for (Buyer temp : Buyer.getBuyersList())
        {
            if (temp.getAccountId().equals(id))
                if (temp.isSignIn() == true)
                {
                    temp.setSignIn(false);
                    System.out.println("Now you are signOut!");
                    FirstPage.firstMenu();
                }
                else if (temp.isSignIn() == false)
                {
                    System.out.println(" Error! you are not already signIn!");
                    FirstPage.firstMenu();
                }
                else
                {
                    for (Seller temp1 : Seller.getSellersList())
                    {
                        if (temp1.getAccountId().equals(id))
                            if (temp1.isSignIn() == true)
                            {
                                temp1.setSignIn(false);
                                System.out.println("Now you are signOut!");
                                FirstPage.firstMenu();
                            }
                            else if (temp1.isSignIn() == false)
                            {
                                System.out.println(" Error! you are not already signIn!");
                                FirstPage.firstMenu();
                            }
                            else
                            {
                                if(id.equals("admin"))
                                    if(Admin.getAdmin().isSignIn() == true)
                                    {
                                        Admin.getAdmin().setSignIn(false);
                                        System.out.println("Now you are signOut!");
                                        FirstPage.firstMenu();
                                    }
                                    else if (Admin.getAdmin().isSignIn() == true)
                                    {
                                        System.out.println(" Error! you are not already signIn!");
                                        FirstPage.firstMenu();
                                    }

                            }
                    }
                }
        }
    }
    public static void deleteAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        System.out.println("***** deleting account progress *****");
        System.out.println("enter your username: ");
        String user = input.next();
        System.out.println("enter your password : ");
        String pass = input.next();
        System.out.println("enter you codeID : ");
        int codeID = input.nextInt();
        System.out.println("enter your roll please ( BUYER / SELLER )");
        String roll = input.next();

        if(roll.toUpperCase().equals("BUYER")){

            String cmd2 = String.format("DELETE FROM b_emaillist WHERE idCode = %d",codeID);
            MySql.getMySql().deleteSQl(cmd2);

            String cmd3 = String.format("DELETE FROM b_phonelist WHERE idCode = %d",codeID);
            MySql.getMySql().deleteSQl(cmd3);

            String cmd = String.format("DELETE FROM buyerlist WHERE userId = '%s'",user);
            MySql.getMySql().deleteSQl(cmd);

        }
        else if(roll.toUpperCase().equals("SELLER")){

            String sqlCmd = "DELETE FROM sellerlist WHERE userId = '" + user + "'";
            MySql.getMySql().ExecuteSQL(sqlCmd);

            String sqlCmd2 = "DELETE FROM s_emaillist WHERE idCode ="+codeID;
            MySql.getMySql().ExecuteSQL(sqlCmd2);

            String sqlCmd3 = "DELETE FROM s_phonelist WHERE idCode ="+codeID;
            MySql.getMySql().ExecuteSQL(sqlCmd3);
        }

        System.out.println("ACCOUNT DELETED!");
        FirstPage.firstMenu();

    }
    public static void editAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        boolean isBuyer = false;
        boolean isSeller = false;
        boolean isAdmin = false;
        Buyer X = null;
        Seller Y = null;
        System.out.println("Enter your accountID: ");
        String id = input.next();
        System.out.println("Enter your password: ");
        String password = input.next();
        for(Buyer temp : Buyer.getBuyersList())
            if(temp.getAccountId().equals(id))
            {
                if(temp.getPassword().equals(password))
                {
                    isBuyer = true;
                    X = temp;
                }
                else
                {
                    for(Seller temp1 : Seller.getSellersList())
                        if(temp1.getAccountId().equals(id))
                            if(temp1.getPassword().equals(password))
                            {
                                isSeller = true;
                                Y = temp1;
                            }
                }
            }

        if(id.equals("admin")&&password.equals("admin"))
        {
            isAdmin = true;
            AccountOperation.editAccountMenu();
        }

        if(isBuyer==false && isSeller==false)
            System.out.println("user not found");
        else
            AccountOperation.editAccountMenu();
        System.out.println("Enter your order : =>");
        int order = 0;
        try{
            order = input.nextInt();
        }
        catch (InputMismatchException x) {
            System.out.println("type error!");
            String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')","type error!");
            MySql.getMySql().ExecuteSQL(sqlcmd);
            input = new Scanner(System.in);
            AccountOperation.editAccount();
        }
        switch (order){
            case 1 :
            {
                System.out.println("Enter your new Name: ");
                String newName = input.next();
                if (isBuyer)
                {
                    X.setName(newName);
                    String sqlcmd = String.format("UPDATE buyerlist SET firstName='%s', WHERE idCode=%d",newName,X.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }

                if (isSeller)
                {
                    Y.setName(newName);
                    String sqlcmd = String.format("UPDATE sellerlist SET firstName='%s' WHERE idCode=%d",newName,Y.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }

                if (isAdmin)
                {
                    Admin.getAdmin().setName(newName);
                }
                System.out.println("Name changed successfully!");
                FirstPage.firstMenu();
            }
            case 2 :
            {
                System.out.println("Enter your new familyName: ");
                String newFamilyName = input.next();
                if (isBuyer)
                {
                    X.setFamilyName(newFamilyName);
                    String sqlcmd = String.format("UPDATE buyerlist SET lastName='%s' WHERE idCode=%d",newFamilyName,X.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }
                if (isSeller)
                {
                    Y.setFamilyName(newFamilyName);
                    String sqlcmd = String.format("UPDATE sellerlist SET lastName='%s' WHERE idCode=%d",newFamilyName,Y.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }
                if (isAdmin)
                {
                    Admin.getAdmin().setFamilyName(newFamilyName);
                }
                System.out.println("familyName changed successfully!");
                FirstPage.firstMenu();
            }
            case 3 :
            {
                System.out.println("Enter your new email: ");
                String newemail = input.next();
                try{
                    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; //first
                    Pattern pattern = Pattern.compile(emailRegex); //second
                    Matcher matcher1 = pattern.matcher(newemail);
                    if(!matcher1.matches())
                        throw new InvalidEmail();
                }
                catch (InvalidEmail x)
                {
                    System.out.println(x.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    AccountOperation.editAccount();
                }
                if (isBuyer)
                {
                    X.setEmail(newemail);
                    String sqlcmd = String.format("UPDATE b_emaillist SET email='%s' WHERE idCode=%d",newemail,X.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }
                if (isSeller)
                {
                    Y.setEmail(newemail);
                    String sqlcmd = String.format("UPDATE s_emaillist SET email='%s' WHERE idCode=%d",newemail,Y.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);

                }
                if (isAdmin)
                    Admin.getAdmin().setEmail(newemail);
                System.out.println("email changed successfully!");
                FirstPage.firstMenu();
            }
            case 4 :
            {
                System.out.println("Enter your new phoneNumber: ");
                String newPhoneNumber = input.next();
                try{
                    String phoneRegex = "^[0][9]\\d{9}$";
                    Pattern patternPhone = Pattern.compile(phoneRegex);
                    Matcher phoneMatcher = patternPhone.matcher(newPhoneNumber);
                    if(!phoneMatcher.matches())
                        throw new InvalidPhoneNum();
                }
                catch (InvalidPhoneNum x)
                {
                    System.out.println(x.getMessage());
                    String sqlcmd = String.format("INSERT INTO errorlogs (errorMassage) VALUES('%s')",x.getMessage());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                    AccountOperation.editAccount();
                }
                if (isBuyer)
                {
                    X.setPhoneNumber(newPhoneNumber);
                    String sqlcmd = String.format("UPDATE b_phonelist SET phoneNumber='%s' WHERE idCode=%d",newPhoneNumber,X.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }
                if (isSeller)
                {
                    Y.setPhoneNumber(newPhoneNumber);
                    String sqlcmd = String.format("UPDATE s_phonelist SET phoneNumber='%s' WHERE idCode=%d",newPhoneNumber,Y.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);
                }
                if (isAdmin)
                    Admin.getAdmin().setPhoneNumber(newPhoneNumber);
                System.out.println("PhoneNumber changed successfully!");
                FirstPage.firstMenu();
            }
            case 5 :
            {
                System.out.println("Enter your new password: ");
                String newPassword = input.next();
                if (isBuyer)
                {
                    X.setPassword(newPassword);
                    String sqlcmd = String.format("UPDATE buyerlist SET password='%s' WHERE idCode=%d",newPassword,X.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);

                }
                if (isSeller)
                {
                    Y.setPassword(newPassword);
                    String sqlcmd = String.format("UPDATE sellerlist SET password='%s' WHERE idCode=%d",newPassword,Y.getCode());
                    MySql.getMySql().ExecuteSQL(sqlcmd);

                }
                if (isAdmin)
                    Admin.getAdmin().setName(newPassword);
                System.out.println("password changed successfully!");
                FirstPage.firstMenu();
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
                    AccountOperation.editAccount();
                }
            }
        }

    }
    public static void editAccountMenu()throws IOException, FileNotFoundException
    {
        System.out.println("*** editMenu ***");
        System.out.println("1 : edit Name");
        System.out.println("2 : edit familyName");
        System.out.println("3 : edit email");
        System.out.println("4 : edit phoneNumber");
        System.out.println("5 : edit password");
    }
}
