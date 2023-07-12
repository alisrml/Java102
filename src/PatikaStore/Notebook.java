package PatikaStore;

public class Notebook extends Product {
    private int ram;
    private String storage;
    private String screenSize;

    public Notebook(int id, double unitPrice, double discountRate, int stock, String name, Brand brand,
                    int ram, String storage, String screenSize) {
        super(id, unitPrice, discountRate, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    // Getters and setters for other properties

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", RAM: %d, Storage: %s, Screen Size: %s",
                ram, storage, screenSize);
    }
}