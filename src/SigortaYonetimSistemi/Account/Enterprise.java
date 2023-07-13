package SigortaYonetimSistemi.Account;

import SigortaYonetimSistemi.Insurance.Insurance;
import SigortaYonetimSistemi.User.User;

public class Enterprise extends Account{
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        this.getInsurances().add(insurance);
    }
}
