/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author EB
 */
public class Manager extends Account {

    public Manager(String Name, String Password, int AccountType) {
        super(Name, Password, AccountType);
        this.name = "admin";
        this.password = "admin";
        this.accountType = 0;
    }

    public void createCustomer(String Name1, String Password1, int CheckBalance1) {
        bank.add(new CheqOnlyCustomer(Name1, Password1, 1, CheckBalance1));
    }

    public void createCustomer(String Name2, String Password2, int CheckBalance2, int SavBalance2) {
        bank.add(new CheqSavCustomer(Name2, Password2, 2, CheckBalance2, SavBalance2));
    }

    public void deleteCustomer(String Name) {
        int i = searchAccount(Name);
        bank.remove(i);
    }

    public void checkCustomer(String Name) {
        int i = searchAccount(Name);
        System.out.println(bank.get(i));
    }

}
