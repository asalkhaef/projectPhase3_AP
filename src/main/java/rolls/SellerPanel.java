package rolls;

import inter_face.SetDiscount;
import menu.Menus;
import products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SellerPanel implements Serializable {
    private static Scanner input = new Scanner(System.in);
    public static void addMobile() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.Mobile : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("products.Mobile Name : ");
        String name = input.next();
        System.out.println("products.Mobile Company : ");
        String company = input.next();
        System.out.println("products.Mobile Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addMobile();
        }
        System.out.println("products.Mobile rolls.Seller : ");
        String seller = input.next();
        System.out.println("products.Mobile Detail : ");
        String detail = input.next();
        System.out.println("products.Mobile Memory : ");
        int memory = 0 ;
        try{
            memory = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addMobile();
        }
        System.out.println("products.Mobile Ram : ");
        int ram = 0 ;
        try{
            ram = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addMobile();
        }
        System.out.println("products.Mobile Operating System : ");
        String OPS = input.next();
        System.out.println("products.Mobile Weight : ");
        double weight = 0 ;
        try{
            weight = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addMobile();
        }
        System.out.println("products.Mobile Dimension : ");
        String dimension = input.next();
        System.out.println("products.Mobile SimNumber : ");
        int simNumber = 0 ;
        try{
            simNumber = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addMobile();
        }
        System.out.println("products.Mobile CamResolution : ");
        int camRes = 0 ;
        try{
           camRes = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addMobile();
        }
        Mobile x = new Mobile(id,name,company,price,seller,detail,memory,ram,OPS,weight,dimension,simNumber,camRes);
        Admin.setAddProductReq(x);
        Admin.digiProducts.setCategoryList(x);
    }
    public static void addLaptop() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.Laptop : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("products.Laptop Name : ");
        String name = input.next();
        System.out.println("products.Laptop Company : ");
        String company = input.next();
        System.out.println("products.Laptop Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addLaptop();
        }
        System.out.println("products.Laptop rolls.Seller : ");
        String seller = input.next();
        System.out.println("products.Laptop Detail : ");
        String detail = input.next();
        System.out.println("products.Laptop Memory : ");
        int memory = 0 ;
        try{
            memory = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addLaptop();
        }
        System.out.println("products.Laptop Ram : ");
        int ram = 0 ;
        try{
            ram = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addLaptop();
        }
        System.out.println("products.Laptop Operating System : ");
        String OPS = input.next();
        System.out.println("products.Laptop Weight : ");
        double weight = 0 ;
        try{
            weight = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addLaptop();
        }
        System.out.println("LaptopDimension : ");
        String dimension = input.next();
        System.out.println("products.Laptop CPU-model : ");
        String Cpu = input.next();
        System.out.println("products.Laptop is gamming ( 1 for YES and 2 for NO) : ");
        int gamming = input.nextInt();
        boolean isgamming = false;
        if(gamming == 1)
            isgamming = true;
        Laptop x = new Laptop(id,name,company,price,seller,detail,memory,ram,OPS,weight,dimension,Cpu,isgamming);
        Admin.setAddProductReq(x);
        Admin.digiProducts.setCategoryList(x);
    }
    public static void addClothes() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.Clothes : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("Cloth Name : ");
        String name = input.next();
        System.out.println("Cloth Company : ");
        String company = input.next();
        System.out.println("Cloth Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addClothes();
        }
        System.out.println("Cloth rolls.Seller : ");
        String seller = input.next();
        System.out.println("Cloth Detail : ");
        String detail = input.next();
        System.out.println("Cloth ProducerCountry : ");
        String county = input.next();
        System.out.println("Cloth Material : ");
        String material = input.next().toUpperCase();
        System.out.println("Cloth size : ");
        String size = input.next().toUpperCase();
        System.out.println("Cloth kind : ");
        String kind = input.next().toUpperCase();
        Clothes x = new Clothes(id,name,company,price,seller,detail,county, Clothing.Material.valueOf(material), Clothes.Size.valueOf(size), Clothes.Kind.valueOf(kind));
        Admin.setAddProductReq(x);
        Admin.clothing.setCategoryList(x);
    }
    public static void addShoes() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.Shoes : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("products.Shoes Name : ");
        String name = input.next();
        System.out.println("products.Shoes Company : ");
        String company = input.next();
        System.out.println("products.Shoes Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addShoes();
        }
        System.out.println("products.Shoes rolls.Seller : ");
        String seller = input.next();
        System.out.println("products.Shoes Detail : ");
        String detail = input.next();
        System.out.println("products.Shoes ProducerCountry : ");
        String county = input.next();
        System.out.println("products.Shoes Material : ");
        String material = input.next().toUpperCase();
        System.out.println("products.Shoes size : ");
        int size = 0 ;
        try{
            size = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addShoes();
        }
        System.out.println("products.Shoes kind : ");
        String kind = input.next().toUpperCase();

        Shoes x = new Shoes(id,name,company,price,seller,detail,county, Clothing.Material.valueOf(material),size, Shoes.ShoeType.valueOf(kind));
        Admin.setAddProductReq(x);
        Admin.clothing.setCategoryList(x);
    }
    public static void addTv() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.TV : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("Tv Name : ");
        String name = input.next();
        System.out.println("Tv Company : ");
        String company = input.next();
        System.out.println("Tv Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addTv();
        }
        System.out.println("Tv rolls.Seller : ");
        String seller = input.next();
        System.out.println("Tv Detail : ");
        String detail = input.next();
        System.out.println("Tv degreeOfConsumption : ");
        String degree = input.next().toUpperCase();
        System.out.println("Tv is warranty:(1 for YES and 2 for NO ");
        int warranty = input.nextInt();
        boolean iswarranty = false;
        if(warranty == 1)
            iswarranty = true;
        System.out.println("Tv resolution : ");
        int resolution = 0 ;
        try{
            resolution = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addTv();
        }
        System.out.println("Tv screenSize : ");
        int size = 0 ;
        try{
            size = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addTv();
        }
        TV x = new TV(id,name,company,price,seller,detail, HomeAppliances.Degree.valueOf(degree),iswarranty,resolution,size);
        Admin.setAddProductReq(x);
        Admin.homeAppliances.setCategoryList(x);
    }
    public static void addRefrigerators() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding Refrigerator : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("Refrigerator Name : ");
        String name = input.next();
        System.out.println("Refrigerator Company : ");
        String company = input.next();
        System.out.println("Refrigerator Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addRefrigerators();
        }
        System.out.println("Refrigerator rolls.Seller : ");
        String seller = input.next();
        System.out.println("Refrigerator Detail : ");
        String detail = input.next();
        System.out.println("Refrigerator degreeOfConsumption : ");
        String degree = input.next().toUpperCase();
        System.out.println("Refrigerator is warranty:(1 for YES and 2 for NO ");
        int warranty = input.nextInt();
        boolean iswarranty = false;
        if(warranty == 1)
            iswarranty = true;
        System.out.println("Refrigerator Capacity : ");
        int capacity = 0 ;
        try{
            capacity = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addRefrigerators();
        }
        System.out.println("Refrigerator Type : ");
        String type = input.next().toUpperCase();
        System.out.println("Refrigerator has freezer:(1 for YES and 2 for NO ");
        int freezer = input.nextInt();
        boolean hasFreezer = false;
        if(freezer == 1)
            hasFreezer = true;

        Refrigerators x = new Refrigerators(id,name,company,price,seller,detail, HomeAppliances.Degree.valueOf(degree),iswarranty,capacity, Refrigerators.RefType.valueOf(type),hasFreezer);
        Admin.setAddProductReq(x);
        Admin.homeAppliances.setCategoryList(x);
    }
    public static void addStove() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.Stove : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("products.Stove Name : ");
        String name = input.next();
        System.out.println("products.Stove Company : ");
        String company = input.next();
        System.out.println("products.Stove Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addStove();
        }
        System.out.println("products.Stove rolls.Seller : ");
        String seller = input.next();
        System.out.println("products.Stove Detail : ");
        String detail = input.next();
        System.out.println("products.Stove degreeOfConsumption : ");
        String degree = input.next().toUpperCase();
        System.out.println("products.Stove is warranty:(1 for YES and 2 for NO ");
        int warranty = input.nextInt();
        boolean iswarranty = false;
        if(warranty == 1)
            iswarranty = true;
        System.out.println("products.Stove burnerNumber : ");
        int burnerNumber = 0 ;
        try{
            burnerNumber = input.nextInt();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addStove();
        }
        System.out.println("products.Stove Type : ");
        String type = input.next().toUpperCase();
        System.out.println("products.Stove has oven :(1 for YES and 2 for NO ");
        int oven = input.nextInt();
        boolean hasOven = false;
        if(oven == 1)
            hasOven = true;

        //System.out.println("Enter you regestered Name: ");
        //String sellername = input.next();

        Stove x = new Stove(id,name,company,price,seller,detail, HomeAppliances.Degree.valueOf(degree),iswarranty,burnerNumber, Stove.StoveType.valueOf(type),hasOven);
        Admin.setAddProductReq(x);
        Admin.homeAppliances.setCategoryList(x);
    }
    public static void addFood() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("=> Adding products.Food : ");
        System.out.println("products.Product id : ");
        String id = input.next();
        System.out.println("products.Food Name : ");
        String name = input.next();
        System.out.println("products.Food Company : ");
        String company = input.next();
        System.out.println("products.Food Price : ");
        double price = 0 ;
        try{
            price = input.nextDouble();
        }
        catch (InputMismatchException x){
            System.out.println("type error!");
            input = new Scanner(System.in);
            SellerPanel.addFood();
        }
        System.out.println("products.Food rolls.Seller : ");
        String seller = input.next();
        System.out.println("products.Food Detail : ");
        String detail = input.next();
        System.out.println("products.Food productionDate : ");
        String productionDate = input.next();
        System.out.println("products.Food expirationDate : ");
        String expirationDate = input.next();

        Food x = new Food(id,name,company,price,seller,detail,productionDate,expirationDate);
        File y = new File("D:/programming/INTJ/Project1/ProjectOne/saveData/category/food/foodList","food"+x.getProductId());
        if(!y.exists())
            y.mkdirs();
        File z = new File(y,"food"+x.getProductId()+".txt");
        z.createNewFile();
        Formatter u = new Formatter(z);
        u.format("%s %s %s %f %s %s %s %s",id,name,company,price,seller,detail,productionDate,expirationDate);
        u.flush();
        u.close();
        Admin.setAddProductReq(x);
        Admin.food.setCategoryList(x);
    }
    public static void deleteProduct() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Enter product id : ");
        String id = input.next();
        for(int i = 0; i<Seller.getListForSell().size() ; i++) //search in main product list in seller class
            if(Seller.getListForSell().get(i).getProductId().equals(id))
            {
                Seller.getListForSell().remove(i);
                System.out.println("products.Product deleted");
            }
            else
                System.out.println("this id is not in you store!");
        for(int j = 0 ; j <Admin.allProducts.size() ; j++)  //search in main product list in main class
            if(Admin.allProducts.get(j).getProductId().equals(id))
            {
                Admin.allProducts.remove(j);
                System.out.println("products.Product deleted");
            }
            else
                System.out.println("products.Product does not exist!");
        Menus.sellerMethods();
    }
    public static void editMobile() throws IOException, FileNotFoundException,ClassNotFoundException
    {
        System.out.println("Enter id of mobile : ");
        String id = input.next();
        System.out.println("you can change this items :");
        System.out.println("1: products.Product name ");
        System.out.println("2: products.Product company ");
        System.out.println("3: products.Product price ");
        System.out.println("4: products.Product detail ");
        System.out.println("5: products.Product memory ");
        System.out.println("6: products.Product ram ");
        System.out.println("7: products.Product OP ");
        System.out.println("8: products.Product weight ");
        System.out.println("9: products.Product dimensions ");
        System.out.println("10: products.Product simNumber ");
        System.out.println("11: products.Product cameraResulution ");
        int order = input.nextInt();
        for(Product temp : Admin.allProducts)
            if(temp.getProductId().equals(id))
            {
                switch (order)
                {
                    case 1:
                    {
                        System.out.println("new name : ");
                        String newName = input.next();
                        temp.setName(newName);
                    }
                    case 2:
                    {
                        System.out.println("new company :");
                        String newCompany = input.next();
                        temp.setCompany(newCompany);
                    }
                    case 3:
                    {
                        System.out.println("new price : ");
                        double newPrice = input.nextDouble();
                        temp.setPrice(newPrice);
                    }
                    case 4:
                    {
                        System.out.println("new detail: ");
                        String newDetail = input.next();
                        temp.setDetail(newDetail);
                    }
                    case 5:
                    {
                        System.out.println("new memory: ");
                        int newMemory = input.nextInt();

                    }




                }
            }

    }
    public static void showProducts() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        System.out.println("Enter your id : => ");
        String id = input.next();
        for(Seller temp : Seller.getSellersList())
            if(temp.getAccountId().equals(id))
            {
                SellerPanel.sort(temp.getProList()); //sorting....
                for(Product temp1 : temp.getProList())
                    System.out.println(temp1.toString());
                Menus.sellerMethods();
            }
            else
            {
                System.out.println("you are not rolls.Seller! ");
                Menus.sellerMethods();
            }
    }
    static void sort(ArrayList<Product> list) throws IOException, FileNotFoundException,ClassNotFoundException
    {
        for(int i = 0 ; i < list.size() ; i++)
            for(int j = i+1 ; j < list.size() ; j++)
                if(list.get(i).compareTo(list.get(j)) < 0)
                {                           //swapping
                    Product temp;
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
    }

}
