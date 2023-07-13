package SigortaYonetimSistemi.Account;

import SigortaYonetimSistemi.AuthenticationStatus.AuthenticationStatus;
import SigortaYonetimSistemi.AuthenticationStatus.InvalidAuthenticationException;
import SigortaYonetimSistemi.User.User;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accountSet;

    public AccountManager() {
        accountSet = new TreeSet<>();
    }

    public void addAccount(Account account) {
        accountSet.add(account);
    }

    public void removeAccount(Account account) {
        accountSet.remove(account);
    }

    public Account login(String email, String password) {
        for (Account account : accountSet) {
            try {
                account.login(email, password);
                if (account.getAuthenticationStatus() == AuthenticationStatus.SUCCESS) {
                    return account;
                }
            } catch (InvalidAuthenticationException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
