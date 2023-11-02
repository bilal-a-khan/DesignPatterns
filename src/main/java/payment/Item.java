package payment;

public class Item {

    private String upcCode;
    private double price;

    public Item(String upc, double price){
        this.upcCode=upc;
        this.price=price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public double getPrice() {
        return price;
    }

}
