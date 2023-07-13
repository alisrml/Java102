package SigortaYonetimSistemi;

import SigortaYonetimSistemi.Address.*;
import SigortaYonetimSistemi.Insurance.*;
import SigortaYonetimSistemi.User.User;
import SigortaYonetimSistemi.Account.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Mauro", "Icardi", "mauro.icardi@example.com", "123456", "Futbolcu", 30);
        User user2 = new User("Okan", "Buruk", "okan.buruk@example.com", "aliyigit", "Teknik Direktör", 35);


        Address homeAddress1 = new HomeAddress("Monaco");
        Address businessAddress1 = new BusinessAddress("Florya");
        Address homeAddress2 = new HomeAddress("Antakya");


        AddressManager.addAddress(user1, homeAddress1);
        AddressManager.addAddress(user1, businessAddress1);
        AddressManager.addAddress(user2, homeAddress2);


        Insurance healthInsurance = new HealthInsurance("Health Insurance", 100.0, new Date(), new Date());
        Insurance residenceInsurance = new ResidenceInsurance("Residence Insurance", 200.0, new Date(), new Date());


        Account individualAccount = new Individual(user1);
        Account enterpriseAccount = new Enterprise(user2);


        individualAccount.addInsurance(healthInsurance);
        enterpriseAccount.addInsurance(residenceInsurance);


        individualAccount.showUserInfo();
        System.out.println();
        enterpriseAccount.showUserInfo();
    }
}
