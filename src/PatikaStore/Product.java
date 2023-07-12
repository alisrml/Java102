package PatikaStore;

public class Product {
    private int id;
    private double unitPrice;
    private double discountRate;
    private int stock;
    private String name;
    private Brand brand;

    public Product(int id, double unitPrice, double discountRate, int stock, String name, Brand brand) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    // Getters and setters for other properties

    public Brand getBrand() {
        return brand;
    }

    public String getInfo() {
        return String.format("ID: %d, Name: %s, Brand: %s", id, name, brand.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
