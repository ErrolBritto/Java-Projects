/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author EB
 */
public class CheqSavCustomer extends Account {

    protected int savBalance;
    protected int checkBalance;

    public CheqSavCustomer(String Name, String Password, int AccountType, int CheqBalance, int SavBalance) {
        super(Name, Password, AccountType);

        if (CheqBalance >= 20 && SavBalance >= 20) {
            this.checkBalance = CheqBalance;
            this.savBalance = SavBalance;
            this.accountType = 2;
        } else {
            System.out.println("Both Chequing and Saving Accounts must have at least $20");
        }

    }

    public int getSavBalance() {
        return CheqSavCustomer.this.savBalance;
    }

    public int getCheckBalance() {
        return CheqSavCustomer.this.checkBalance;
    }

    public void savDeposit(int Amount) {

        CheqSavCustomer.this.savBalance = CheqSavCustomer.this.savBalance + Amount;
        System.out.println("New Saving Account Balance after Deposit is: ");
        System.out.println(CheqSavCustomer.this.getSavBalance());
    }

    public void cheqDeposit(int Amount) {

        CheqSavCustomer.this.checkBalance = CheqSavCustomer.this.checkBalance + Amount;
        System.out.println("New Chequing Account Balance after Deposit is:");
        System.out.println(CheqSavCustomer.this.getCheckBalance());
    }

    public void savWithDraw(int Amount) {

        int temp = CheqSavCustomer.this.savBalance - Amount;

        if (Check(temp) == true) {
            CheqSavCustomer.this.savBalance = temp;
        } else {
            System.err.println("Insufficient funds to perform transaction");
        }

        System.out.println("New Saving Account Blanace after Withdraw is: ");
        System.out.println(CheqSavCustomer.this.getSavBalance());
    }

    public void cheqWithDraw(int Amount) {

        int temp = CheqSavCustomer.this.checkBalance - Amount;

        if (Check(temp) == true) {
            CheqSavCustomer.this.checkBalance = temp;
        } else {
            System.out.println("Insufficient funds to perform transaction");
        }

        System.out.println("New Account Balance after Withdraw is: ");
        System.out.println(CheqSavCustomer.this.getCheckBalance());
    }

    public void Cheq2Sav(int Amount) {

        int temp = CheqSavCustomer.this.checkBalance - Amount;

        if (Check(temp)) {
            CheqSavCustomer.this.checkBalance = temp;
            CheqSavCustomer.this.savBalance = CheqSavCustomer.this.savBalance + Amount;
        } else {
            System.err.println("Insufficient funds to perform transaction");
        }

        System.out.println("New Cheqing Account Balance after Transfer is:");
        System.out.println(CheqSavCustomer.this.getCheckBalance());
        System.out.println("New Saving Account Blanace after Transfer is:");
        System.out.println(CheqSavCustomer.this.getSavBalance());
    }

    public void Sav2Chqu(int Amount) {

        int temp = CheqSavCustomer.this.checkBalance - Amount;
        if (Check(temp) == true) {
            CheqSavCustomer.this.savBalance = temp;
            CheqSavCustomer.this.checkBalance = CheqSavCustomer.this.checkBalance + Amount;
        } else {
            System.err.println("Insufficient funds to perform transaction");
        }

        System.out.println("New Chequing Account Balance after Transfer is:");
        System.out.println(CheqSavCustomer.this.getCheckBalance());
        System.out.println("New Saving Account Balance after Transfer is:");
        System.out.println(CheqSavCustomer.this.getSavBalance());
    }

    public boolean Check(int money) {
        return money > 0;
    }
}
