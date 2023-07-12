package PatikaStore;

public class CellPhone extends Product {
    private String memory;
    private String screenSize;
    private int batteryPower;
    private int ram;
    private String color;

    public CellPhone(int id, double unitPrice, double discountRate, int stock, String name, Brand brand,
                     String memory, String screenSize, int batteryPower, int ram, String color) {
        super(id, unitPrice, discountRate, stock, name, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    // Getters and setters for other properties

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Memory: %s, Screen Size: %s, Battery Power: %d, RAM: %d, Color: %s",
                memory, screenSize, batteryPower, ram, color);
    }
}
