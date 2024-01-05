package kiosk.domain;

public class Product extends Menu{

    private double price;
    private double sizeupPrice;
    private String category;

    public Product(String name, String description, double price, String category){
        super(name, description);
        this.price = price;
        this.category = category;
        this.sizeupPrice = 0;
    }

    public Product(String name, String description, double price, double sizeupPrice, String category){
        super(name, description);
        this.price = price;
        this.category = category;
        this.sizeupPrice = sizeupPrice;
    }

    public double getPrice(){
        return price;
    }

    public double getSizeupPrice(){
        return sizeupPrice;
    }

    public String getCategory(){
        return category;
    }

    public void show(){
        System.out.printf("%-20s | W %s |%s\n", getName(), price,getDescription());
    }
}
