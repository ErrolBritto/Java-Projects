/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;

/**
 *
 * @author EB
 */
public class Account {

    protected String name;
    protected String password;
    protected int accountType;
    ArrayList<Account> bank = new ArrayList<Account>();
    public static final String Type0 = "Manager";
    public static final String Type1 = "Chequing Customer";
    public static final String Type2 = "Chequing and Saving Customer";
    public Account currentAccount;

    public Account(String Name, String Password, int AccountType) {
        this.name = Name;
        this.password = Password;
        this.accountType = AccountType;
        bank.add(this);
    }

    public String getAccountType(String Name) {
        int i;
        i = searchAccount(Name);
        if (i != 404) {
            return TypeAccount(bank.get(i).accountType);
        } else {
            System.out.println("Account Type Error");
            return "NULL getAccountType";
        }
    }

    public int searchAccount(String Name) {
        int i = 0;
        String temp;
        for (i = 0; i < (bank.size()); i++) {
            temp = bank.get(i).name;
            if (Name.equalsIgnoreCase(temp)) {
                return i;
            }
        }
        System.out.println("Cannot Find Account with Name" + Name);
        return 404;
    }

    public String TypeAccount(int i) {
        if (bank.get(i).accountType == 0) {
            return Type0;
        }
        if (bank.get(i).accountType == 1) {
            return Type1;
        }
        if (bank.get(i).accountType == 2) {
            return Type2;
        }
        return "NULL TypeAccount";
    }

    public void changePassword(String Password) {
        currentAccount.password = Password;
    }

    public boolean login(String Name, String Password) {
        int i = searchAccount(Name);
        String temp = bank.get(i).password;
        if (Password == temp) {
            System.out.println("Log in Success");
            currentAccount = bank.get(i);
            return true;
        } else {
            System.err.println("Log in Fail");
            return false;
        }
    }

    public void logout() {
        currentAccount = null;
        System.out.append("Logout Success");
    }
}
