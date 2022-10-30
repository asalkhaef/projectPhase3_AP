package rolls;

import menu.FirstPage;
import products.Product;
import rolls.Admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuyerManage implements Serializable {
    public static void showProducts()throws IOException, FileNotFoundException,ClassNotFoundException{
        BuyerManage.sort(Admin.allProducts);
        for(Product temp : Admin.allProducts)
        {
            System.out.println("* "+temp.toString());
            System.out.println();
        }
    }
    public static void filterProduct() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        FirstPage.fourthMenu();
    }
    public static void showCart() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        BuyerPanel.showcart();
    }
    static void sort(ArrayList<Product> list)throws IOException, FileNotFoundException,ClassNotFoundException
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
