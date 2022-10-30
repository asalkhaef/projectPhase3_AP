package products;

import inter_face.Guarantee;

import java.io.Serializable;

abstract public class HomeAppliances extends Product implements Guarantee, Serializable {
    public enum Degree
    {
        A,B,C,D,E,F;
    }
    private Degree degreeOfConsumption;
    private boolean warranty;
    //......Constructor...................
    public HomeAppliances(String productId, String name1, String company,
                          double price, String seller, boolean status, String detail,
                          Degree degreeOfConsumption, boolean warranty) {
        super(productId, name1, company, price, seller, status, detail);
        this.degreeOfConsumption = degreeOfConsumption;
        this.warranty = warranty;
    }
    //......Set&Get..........................
    public Degree getDegreeOfConsumption() {
        return degreeOfConsumption;
    }
    public boolean isWarranty() {
        return warranty;
    }
    public void setDegreeOfConsumption(Degree degreeOfConsumption) {
        this.degreeOfConsumption = degreeOfConsumption;
    }
    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
    //.....Methods.............................

    @Override
    public String toString() {
        return super.toString()+"products.HomeAppliances{" +
                "degreeOfConsumption=" + degreeOfConsumption +
                ", warranty=" + warranty +
                '}';
    }

    @Override
    public double calculateGuaranteeValue(Product x) {
        double value = 0;
        if(x instanceof HomeAppliances)
        {
            if(!((HomeAppliances) x).isWarranty())
                return 0;
            else
                value = (double)(((x.getPrice() * 20)/100)-(((HomeAppliances) x).degreeOfConsumption.ordinal()*10));
        }
        return value;
    }

    @Override
    public int calculateGuaranteeTime(Product y) {
        int time = 0;
        if(y instanceof HomeAppliances)
        {
            if(!((HomeAppliances) y).isWarranty())
                return 0;
            else
            {
                if(y instanceof TV)
                {
                    time =(int)((((TV) y).getResolution()/10)+(((TV) y).getScreenSize()/2));
                }
                else if(y instanceof Refrigerators)
                {
                    time = (int)(((Refrigerators) y).getCapacity()/5);
                }
                else if(y instanceof Stove)
                {
                    time = (int)(((Stove) y).getBurnerNumber()*2);
                }
            }
        }
        return time;
    }
}