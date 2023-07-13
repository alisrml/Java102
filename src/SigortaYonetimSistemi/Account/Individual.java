package SigortaYonetimSistemi.Account;

import SigortaYonetimSistemi.Insurance.Insurance;
import SigortaYonetimSistemi.User.User;

public class Individual extends Account{
    public Individual(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        this.getInsurances().add(insurance);
    }
}
