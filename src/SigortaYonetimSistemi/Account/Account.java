package SigortaYonetimSistemi.Account;

import SigortaYonetimSistemi.Address.Address;
import SigortaYonetimSistemi.AuthenticationStatus.AuthenticationStatus;
import SigortaYonetimSistemi.Insurance.Insurance;
import SigortaYonetimSistemi.User.User;
import SigortaYonetimSistemi.AuthenticationStatus.InvalidAuthenticationException;

import java.util.ArrayList;

public abstract class Account implements Comparable<Account> {
    private User user;
    AuthenticationStatus authenticationStatus;
    private ArrayList<Insurance> insuranceList;

    public Account(User user) {
        this.user = user;
        this.insuranceList = new ArrayList<>();
    }

    public final void showUserInfo() {
        System.out.println("Müşteri Adı: " + user.getName());
        System.out.println("Müşteri Soyadı: " + user.getSurname());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Meslek: " + user.getJob());
        System.out.println("Yaş: " + user.getAge());
        System.out.println("Adresler: ");
        for (Address address : user.getAddressList()) {
            System.out.println(address.getAddressInfo());
        }
        System.out.println("Son Giriş Tarihi: " + user.getLastLogin());
    }

    @Override
    public int compareTo(Account other) {
        return user.getName().compareTo(other.getUser().getName());
    }

    public void login(String email,String password) throws InvalidAuthenticationException{
        if(email.equals(user.getEmail())&&password.equals(user.getPassword())){
            authenticationStatus = AuthenticationStatus.SUCCESS;
            System.out.println("Giriş başarılı...");
        }else {
            authenticationStatus = AuthenticationStatus.FAIL;
            throw new InvalidAuthenticationException("Kullanıcı adı yada şifre hatalı...");
        }
    }

    public abstract void addInsurance(Insurance insurance);

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insuranceList;
    }
}
