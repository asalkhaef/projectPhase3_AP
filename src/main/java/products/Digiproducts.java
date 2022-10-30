package products;

import inter_face.Guarantee;

import java.io.Serializable;

abstract public class Digiproducts extends Product implements Guarantee, Serializable {
    private int memory;
    private int ram;
    private String operatingSystem;
    private double weight;
    private String dimensions;
    //......Constructor..........................
    public Digiproducts(String productId, String name1,
                        String company, double price, String seller, boolean status, String detail,
                        int memory, int ram, String operatingSystem, double weight, String dimensions) {
        super(productId, name1, company, price, seller, status, detail);
        this.memory = memory;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
        this.weight = weight;
        this.dimensions = dimensions;
    }
    //.........Set&Get.............................
    public int getMemory() {
        return memory;
    }
    public int getRam() {
        return ram;
    }
    public String getOperatingSystem() {
        return operatingSystem;
    }
    public double getWeight() {
        return weight;
    }
    public String getDimensions() {
        return dimensions;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    //...........Methods.......................
    @Override
    public String toString() {
        return super.toString()+"products.Digiproducts{" +
                "memory=" + memory +
                ", ram=" + ram +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }

    @Override
    public double calculateGuaranteeValue(Product x) {
        double value = 0;
        if( x instanceof Digiproducts)
        {
            value = (double)((x.getPrice() * 10)/100);
        }
        return value;
    }

    @Override
    public int calculateGuaranteeTime(Product y) {
        int time = 0;
        if(y instanceof Digiproducts)
        {
            time = (int)(((Digiproducts) y).ram + ((Digiproducts) y).weight/10);
        }
        return time;
    }

}
