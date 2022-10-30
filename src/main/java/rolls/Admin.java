package rolls;

import products.Category;
import products.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admin extends Person implements Serializable {
    private static Admin admin = null;
    private static ArrayList<Product> addProductReq = new ArrayList<Product>();
    private static ArrayList<Product> deleteProductReq = new ArrayList<Product>();
    private static ArrayList<Product> editProductReq = new ArrayList<Product>();
    private static ArrayList<Seller> addSellerReq = new ArrayList<Seller>();
    public static ArrayList<Person> allUsers = new ArrayList<Person>();
    public static ArrayList<Seller> allPendingsellers = new ArrayList<Seller>();
    public static ArrayList<Category> allCategories = new ArrayList<Category>();
    public static ArrayList<Product> allProducts = new ArrayList<Product>();
    //make main categories in admin data!
    public static Category digiProducts = new Category("digiProducts","digital,tech,electrical");
    public static Category homeAppliances = new Category("homeAppliances","electrical,useInHome");
    public static Category food = new Category("food","bite,drink,culinary");
    public static Category clothing = new Category("clothing","wearable,accessory");
    private boolean signIn = false;

    //.......Constructor.......................
    Admin(String accountId, String name, String familyName, String email, String phoneNumber, String password, Person.Roll role, int wealth) {
        super(accountId, name, familyName, email, phoneNumber, password, role, wealth);
    }
    public static Admin getMyAdmin( String name, String familyName, String email, String phoneNumber, int wealth)
    {
        if (admin == null)
        {
            admin = new Admin("admin", "Asal", "Khaef", "asalkhaef@yahoo.com", "09111234567", "admin", Person.Roll.ADMIN, 1000);
            return admin;
        }
        else
            return admin;
    }
    //......Set&Get...........................

    public static Admin getAdmin() {
        return admin;
    }
    public static void setAdmin(Admin admin) {
        Admin.admin = admin;
    }
    public static void setAddProductReq(Product x ) {
        Admin.addProductReq.add(x);
    }
    public static void setDeleteProductReq(Product x ) {
        Admin.deleteProductReq.add(x);
    }
    public static void setEditProductReq(Product x ) {
        Admin.editProductReq.add(x);
    }
    public static ArrayList<Product> getAddProductReq() {
        return addProductReq;
    }
    public static ArrayList<Product> getDeleteProductReq() {
        return deleteProductReq;
    }
    public static ArrayList<Product> getEditProductReq() {
        return editProductReq;
    }
    public boolean isSignIn() {
        return signIn;
    }
    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }
    public static ArrayList<Seller> getAddSellerReq() {
        return addSellerReq;
    }
    public static void setAddSellerReq(Seller x) {
        Admin.addSellerReq.add(x);
    }

    //.......Methods..........................
    void editAccount() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        AccountOperation.editAccount();
    }

}