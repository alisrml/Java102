package SigortaYonetimSistemi.Address;

import SigortaYonetimSistemi.User.User;

public class AddressManager {

    public static void addAddress(User user,Address adress){
        user.getAddressList().add(adress);
    }

    public static void deleteAddress(User user,Address address){
        user.getAddressList().remove(address);
    }
}
