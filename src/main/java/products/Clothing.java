package products;

import java.io.Serializable;

abstract public class Clothing extends Product implements Serializable {
    public enum Material
    {
        COTTON,SILK,NYLON,LINEN,LEATHER;
    }
    private String producerCountry;
    private Material clothMaterial;
    //........Constructor.....................
    public Clothing(String productId, String name1, String company,
                    double price, String seller, boolean status, String detail,
                    String producerCountry, Material clothMaterial) {
        super(productId, name1, company, price, seller, status, detail);
        this.producerCountry = producerCountry;
        this.clothMaterial = clothMaterial;
    }
    //.........Set&Get.........................
    public String getProducerCountry() {
        return producerCountry;
    }
    public Material getClothMaterial() {
        return clothMaterial;
    }
    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
    }
    public void setClothMaterial(Material clothMaterial) {
        this.clothMaterial = clothMaterial;
    }
    //........Methods..........................
    @Override
    public String toString() {
        return super.toString()+"products.Clothing{" +
                "producerCountry='" + producerCountry + '\'' +
                ", clothMaterial=" + clothMaterial +
                '}';
    }
}