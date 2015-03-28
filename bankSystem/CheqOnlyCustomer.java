/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author EB
 */
public class CheqOnlyCustomer extends Account {

    protected int checkBalance;

    public CheqOnlyCustomer(String Name, String Password, int AccountType, int CheqBalance) {
        super(Name, Password, AccountType);
        {
            if (CheqBalance >= 20) {
                this.checkBalance = CheqBalance;
                this.accountType = 1;
            } else {
                System.out.println("Chequing Account Balance must be greater than $20");
            }
        }
    }

    public int getCheckBalance() {
        return CheqOnlyCustomer.this.getCheckBalance();
    }

    public void cheqDeposit(int Amount) {
        CheqOnlyCustomer.this.checkBalance = CheqOnlyCustomer.this.checkBalance + Amount;
        System.out.println("New Account Balance after Deposit is: ");
        System.out.println(CheqOnlyCustomer.this.getCheckBalance());
    }

    public void cheqWithdraw(int Amount) {

        int temp = CheqOnlyCustomer.this.checkBalance - Amount;

        if (Check(temp) == true) {
            CheqOnlyCustomer.this.checkBalance = temp;
        } else {
            System.out.println("Insufficient funds to perform transaction");
        }

        System.out.println("New Account Balance after Withdraw is: ");
        System.out.println(CheqOnlyCustomer.this.getCheckBalance());
    }

    public boolean Check(int money) {
        return money > 0;
    }
}
