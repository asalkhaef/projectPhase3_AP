package inter_face;

import products.Product;

public interface Guarantee {
    double calculateGuaranteeValue(Product x);
    int calculateGuaranteeTime(Product y);
}
