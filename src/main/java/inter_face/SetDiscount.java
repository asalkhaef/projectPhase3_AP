package inter_face;

import products.Product;

public interface SetDiscount {
    void addDiscountCode(double discountPercentage, int discountNum,String expire);
    void normalDiscount();
}
