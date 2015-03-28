
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author EB
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Lab5 {

    private static String commands;
    private static int commandInt;
    private static Account currentUser;
    private static ArrayList<Account> ABC = new ArrayList<Account>();

    private static int[] array = new int[10000];

    private static void displayOperation() {
        System.out.println(" ");
        System.out.println("What would you like to do?");
        if (currentUser.accountType == 0) {
            System.out.println("Type c to Create new Chequing only customer");
            System.out.println("Type cs to Create new Chequing and Saving customer");
            System.out.println("Type d to Delete a Customer");
        }

        if (currentUser.accountType == 1) {
            System.out.println("Type deposit to Deposit into Chequing account");
            System.out.println("Type withdraw to Withdraw from Cheqing account");
            System.out.println("Type check to Check your Chequing account balance");
        }

        if (currentUser.accountType == 2) {
            System.out.println("Type depchq to Deposit into Cheqing account");
            System.out.println("Type depsav to Deposit into Saving account");
            System.out.println("Type c2s to Transfer from Chequing to Saving");
            System.out.println("Type s2c to Transfer from Saving to Chequing");
            System.out.println("Type witchq to Withdraw from Chequing");
            System.out.println("Type witsav to Withdraw from Saving");
            System.out.println("Type accountcheck to Check account Balances");
        }
        System.out.println(" ");
        System.out.print("Enter Command: ");

    }

    private static String userInput() {
        Scanner user_input = new Scanner(System.in);
        commands = user_input.next();
        return commands;
    }

    private static int userInputInt() {
        Scanner user_input = new Scanner(System.in);
        commandInt = user_input.nextInt();
        return commandInt;
    }

    private static void logout() {
        System.out.println("Bye " + currentUser.name);
        currentUser = null;
    }

    private static boolean LoginAuth(String temp1, String temp2) {
        int i = searchAccount(temp1);
        if (i != -1) {
            if (temp2.equalsIgnoreCase(ABC.get(i).password)) {
                return true;
            }
        }
        return false;
    }

    private static int searchAccount(String Name) {
        int i = 0;
        String temp;
        for (i = 0; i < (ABC.size()); i++) {
            temp = ABC.get(i).name;
            if (Name.equalsIgnoreCase(temp)) {
                return i;
            }
        }
        System.err.println("Cannot Find Account with Name: " + Name);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to ABC Bank!");
        String temp1, temp2;
        int temp3, temp4;
        ABC.add(new Manager("admin", "admin", 0));

        while (true) {
            System.out.println("Enter Username :");
            temp1 = userInput();
            System.out.println("Enter Password :");
            temp2 = userInput();
            if (LoginAuth(temp1, temp2)) {
                currentUser = ABC.get(searchAccount(temp1));
                if (currentUser.accountType == 0) {
                    managerOperation();
                }

                if (currentUser.accountType == 1) {
                    cheqonlyOperation();
                }

                if (currentUser.accountType == 2) {
                    cheqsavOperation();
                }
            }
        }
    }

    private static void managerOperation() {
        String name, pass;
        int chqbal, savbal;
        System.out.println("Hi " + currentUser.name);
        while (true) {
            displayOperation();
            commands = userInput();
            if (commands.equalsIgnoreCase("logout")) {
                break;
            }
            if (commands.equalsIgnoreCase("c")) {
                name = null;
                pass = null;
                chqbal = -1;
                System.out.println("Enter New Customer Name: ");
                name = userInput();
                System.out.println("Enter New Password: ");
                pass = userInput();
                System.out.println("Enter Chequing balance: ");
                chqbal = userInputInt();
                if ((name != null) && (pass != null) && (chqbal > 19)) {
                    ABC.add(new CheqOnlyCustomer(name, pass, 1, chqbal));
                    array[searchAccount(name)] = chqbal;
                    System.out.println("Account creation successful!");
                } else {
                    System.out.println("Account creation unsuccessful! Please try again!");
                }

            }

            if (commands.equalsIgnoreCase("cs")) {
                name = null;
                pass = null;
                chqbal = -1;
                System.out.println("Enter New Customer Name: ");
                name = userInput();
                System.out.println("Enter New Password: ");
                pass = userInput();
                System.out.println("Enter Chequing balance: ");
                chqbal = userInputInt();
                System.out.println("Enter Saving balance: ");
                savbal = userInputInt();

                if ((name != null) && (pass != null)
                        && (chqbal > 19) && (savbal > 19)) {
                    ABC.add(new CheqSavCustomer(name, pass, 2, chqbal, savbal));
                    array[searchAccount(name)] = chqbal;
                    array[searchAccount(name) * 10] = savbal;
                    System.out.println("Account creation successful!");
                } else {
                    System.err.println("Account creation unsuccessful! Please try again!");
                }
            }

            if (commands.equalsIgnoreCase("d")) {
                name = null;
                chqbal = -1;
                System.out.println("Enter New Customer Name: ");
                name = userInput();
                chqbal = searchAccount(name);
                if (chqbal != -1) {
                    if (ABC.get(chqbal).accountType == 2) {
                        array[chqbal * 10] = 0;
                    }
                    ABC.remove(chqbal);
                    array[chqbal] = 0;

                    System.out.println("Account removal success! ");
                } else {
                    System.err.println("Account removal fail! ");
                }
            }
        }
    }

    private static void cheqonlyOperation() {
        String name, pass;
        int chqbal, savbal;
        System.out.println("Hi " + currentUser.name);
        while (true) {
            displayOperation();
            commands = userInput();
            if (commands.equalsIgnoreCase("logout")) {
                break;
            }
            if (commands.equalsIgnoreCase("deposit")) {
                chqbal = 0;
                System.out.println("Enter Amount: ");
                chqbal = userInputInt();
                if (chqbal > 0) {
                    array[searchAccount(currentUser.name)] += chqbal;
                } else {
                    System.out.println("Invalid amount entered!");
                }

            }

            if (commands.equalsIgnoreCase("withdraw")) {
                chqbal = 0;
                System.out.println("Enter Amount");
                chqbal = userInputInt();
                if (chqbal > 0) {
                    array[searchAccount(currentUser.name)] -= chqbal;
                } else {
                    System.err.println("Invaid amount entered!");
                }
            }

            if (commands.equalsIgnoreCase("check")) {

                System.out.println(" ");
                System.out.println("Current Balance: " + array[searchAccount(currentUser.name)]);
            }

        }
    }

    private static void cheqsavOperation() {
        String name, pass;
        int chqbal, savbal;
        System.out.println("Hi " + currentUser.name);
        while (true) {
            displayOperation();
            commands = userInput();
            if (commands.equalsIgnoreCase("logout")) {
                break;
            }
            if (commands.equalsIgnoreCase("depchq")) {
                chqbal = 0;
                System.out.println("Enter Amount: ");
                chqbal = userInputInt();
                if (chqbal > 0) {

                    array[searchAccount(currentUser.name)] += chqbal;
                } else {
                    System.err.println("Invalid amount entered!");
                }
            }

            if (commands.equalsIgnoreCase("witchq")) {
                chqbal = 0;
                System.out.println("Enter Amount: ");
                chqbal = userInputInt();
                if (chqbal > 0) {
                    array[searchAccount(currentUser.name)] -= chqbal;
                } else {
                    System.err.println("Invalid amount entered!");
                }
            }

            if (commands.equalsIgnoreCase("accountcheck")) {

                System.out.println(" ");
                System.out.println("Current CheqBalance: " + array[searchAccount(currentUser.name)]);
                System.out.println("Current SavBalance: " + array[searchAccount(currentUser.name) * 10]);
            }

            if (commands.equalsIgnoreCase("depsav")) {
                chqbal = 0;
                System.out.println("Enter Amount");
                chqbal = userInputInt();
                if (chqbal > 0) {

                    array[searchAccount(currentUser.name) * 10] += chqbal;
                } else {
                    System.err.println("Invalid amount entered!");
                }
            }

            if (commands.equalsIgnoreCase("witsav")) {
                chqbal = 0;
                System.out.println("Enter Amount");
                chqbal = userInputInt();
                if (chqbal > 0) {
                    array[searchAccount(currentUser.name) * 10] -= chqbal;
                } else {
                    System.err.println("Invalid amount entered!");
                }
            }

            if (commands.equalsIgnoreCase("c2s")) {
                chqbal = 0;
                System.out.println("Enter Amount");
                chqbal = userInputInt();
                if (chqbal > 0) {

                    array[searchAccount(currentUser.name)] -= chqbal;
                    array[searchAccount(currentUser.name) * 10] += chqbal;
                } else {
                    System.err.println("Invalid amount entered!");
                }
            }

            if (commands.equalsIgnoreCase("s2c")) {
                chqbal = 0;
                System.out.println("Enter Amount");
                chqbal = userInputInt();
                if (chqbal > 0) {
                    array[searchAccount(currentUser.name)] += chqbal;
                    array[searchAccount(currentUser.name) * 10] -= chqbal;
                } else {
                    System.err.println("Invalid amount entered!");
                }
            }

        }
    }

}
