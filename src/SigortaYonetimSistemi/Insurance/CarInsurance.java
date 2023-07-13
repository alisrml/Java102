package SigortaYonetimSistemi.Insurance;

import java.util.Date;

public class CarInsurance extends Insurance{

    public CarInsurance(String name, double price, Date startDate, Date endDate) {
        super(name, price, startDate, endDate);
    }

    @Override
    public double calculate() {
        return getPrice() * 1.4;
    }
}
