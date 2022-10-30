package products;

import rolls.Admin;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String name;
    private String special;
    private ArrayList<Product> categoryIn ;
    //......Constructor....................
    public Category(String name, String special) {
        this.name = name;
        this.special = special;
        Admin.allCategories.add(this);
        categoryIn = new ArrayList<Product>();
    }
    //.........Set&Get.....................
    public String getName() {
        return name;
    }
    public String getSpecial() {
        return special;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecial(String special) {
        this.special = special;
    }
    public ArrayList<Product> getCategoryList() {
        return categoryIn;
    }
    public void setCategoryList(Product x) {
        this.categoryIn.add(x);
    }
}
