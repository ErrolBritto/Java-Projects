/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author EB
 * @author Marc
 * 
 */
public class Player implements Comparable {
    static Betting bet1;
    TextFile  F;
    static int count;
    Card[] hand;
    int BH;
    int id, rank;
    int[] swap, HC;
    double balance, balance2;
    String name;
    boolean folded,token,allIn;

    public Player(String name) {
        F=new TextFile();
        swap=new int[5];
        token=false;
        balance=20;
        balance2=0;
        count++;
        id = count;
        folded = false;
        allIn=false;
        rank=0;
        this.name = name;
        if(count==1){
            bet1=new Betting();
        }
    }
    public void Earnings(double balance3){
        double e;
        if(balance<0.001){
            System.out.println(name +" is eliminated from the game, balance is equal to zero");
        }
        else{
            e=balance-balance3;
            if(e<0){
                e=e*(-1);
                System.out.println(name + " lost $" + e);
            }
            else{
               System.out.println(name + " earned $" + e); 
            }
        }
        
    }
    public void reset(){
        balance2=0;
        folded=false;
        HC=null;
        rank=0;
        hand=null;
        allIn=false;
        for(int i=0;i<5;i++){
            swap[i]=0;
        }
    }
    public void dislayInfo(){
        String s=name;
        if(folded==true){
            s=s+", Folded";
        }
        else{
            s=s+", balance: $"+balance+" Money in the Pot: " +balance2;
        }
        System.out.println(s);
    }
    public void fold() {
        System.out.println("You have folded\n");
        folded = true;
    }
    public void check(){
        System.out.println("You have checked\n");
            
    }
    public void swap(){
        System.out.println();
        System.out.println(name+" turn to swap cards");
        
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter 1 if you would like to swap that card, if not enter 0");
        int j=0,input;
        for(int i=0;i<5;i++){
            j=i+1;
            System.out.println("Would you like to swap card " +j+" from your hand");
            input=scan1.nextInt();
            swap[i]=input;
        }
    }
    public void raise(ArrayList<Player> players, Pot p){
        Scanner scan1 = new Scanner(System.in);
        double amount;
        boolean flag=true;
        System.out.println("Enter the amount by which you want to raise, you must raise by atleast $1");
        if(balance<1){
          System.out.println("Your balance is less than $1, you may raise by less than $1");  
        }
        amount=scan1.nextDouble();
        flag=bet1.raise(players, amount, id);
        if(flag==false){
            raise(players,p);
        }
        else{
            balance2=balance2+amount;
            balance=balance-amount;
            if(balance<=0.001){
                System.out.println("You are all in\n");
                allIn=true;
            }
            p.addPot(amount);
            
        }
        
        
    }
   
    public void Ante(Pot p){
       if(balance<=1){
           balance2=balance2+balance;
           p.addPot(balance);
           balance=0;
           allIn=true;
           System.out.println("You are all in\n");
       }
       else{
           balance2=balance2+1;
           p.addPot(1);
           balance--;
       }
    }
    public void call(ArrayList<Player> players, Pot p) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        double amount;
        String input;
        amount = bet1.call(players, id);
        if (amount > balance) {
            System.out.println("You do not have enough to call, you must go all in");
            System.out.println("If you would like to fold instead, enter 0, to go all in enter 1");
            input = scan1.nextLine();
            switch (input) {
                case "0":
                    fold();
                    break;

                case "1":
                    allIn=true;
                    balance2 = balance2 + balance;
                    p.addPot(balance);
                    balance = 0;
                    System.out.println("You are all in\n");
                    break;
                default:
                    System.out.println("You have entered an invalid command");
                    call(players,p);
                    break;

            }
        }
            else{
                System.out.println("$"+amount+" to call\n");
                System.out.println("If you would like to proceed enter 1, if you would like to fold instead enter 0");
                System.out.println("If you would like to proceed and then raise enter 2");
                input=scan2.nextLine();
                 switch (input){
                        case "0":
                            fold();
                            break;
        
                        case "1":
                            balance2=balance2+amount;
                            balance=balance-amount;
                            if(balance<0.001){
                                allIn = true;
                                System.out.println("You are all in\n");
                            }
                            p.addPot(amount);
                            break;
                        case "2":
                            balance2=balance2+amount;
                            balance=balance-amount;
                            p.addPot(amount);
                            if(balance<0.001){
                                allIn = true;
                                System.out.println("You cannot raise with a balance of $0");
                            }
                            else if(bet1.raiseTrue(players, id)==false){
                                System.out.println("You cannot raise");
                                
                            }
                            else{
                                raise(players,p);
                                }
                                
                            break;
                         
                        default:
                            System.out.println("You have entered an invalid command");
                            call(players,p);
                            break;
             
             
        }
                
                }

        }

    


    public void input(String input, ArrayList<Player> players,Pot p) {
        switch (input) {
            case "0":
                fold();
                break;
            case "1":
                check();
                break;
            case "2":
                raise(players,p);
                break;
            case "3":
                call(players,p);
                break;
            default:
                System.out.println("You have entered an invalid command");
                turn(players,p);
                break;
                

        }
    }

    @Override
    public int compareTo(Object P) {
        if(rank==0){
        int compare = ((Player) P).BH;
        return compare - this.BH;
        }
        else{
            int compare2=((Player) P).id;
            return this.id-compare2;
        }
    }

    public void turn(ArrayList<Player> players,Pot P) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input,input2;
        double call;
        System.out.println(name +  "'s turn\n");
        System.out.println("Balance: $" + balance);
        if(bet1.fold(players,id)==true){
            System.out.println("Enter 0 to fold");
        }
        if (bet1.check(players, id) == true) {
            System.out.println("Enter 1 to check");
        }
        if(bet1.raiseTrue(players,id)==true){
            System.out.println("Enter 2 to raise");
        }
        if(bet1.callTrue(players, id)==true) {
            System.out.println("Enter 3 to call");
            System.out.println("If you call you will then have the option to raise");

        }
         input = scan1.nextLine();
         input(input,players,P);

    }
    @Override
    public String toString(){
        String s="";
        for(int i=0;i<5;i++){
         s=s+convert(hand[i])+", ";
    }
      return s; 
    }
    public String convert(Card a){
        String s=null;
        if(a.value==11){
            s="Jack of";
        }
        else if(a.value==12){
            s="Queen of";
        }
        else if(a.value==13){
            s="King of";
        }
        else if(a.value==14){
            s="Ace of";
        }
        else if(a.value==2){
            s="2 of";
        }
        else if(a.value==3){
            s="3 of";
        }
        else if(a.value==4){
            s="4 of";
        }
        else if(a.value==5){
            s="5 of";
        }
        else if(a.value==6){
            s="6 of";
        }
        else if(a.value==7){
            s="7 of";
        }
        else if(a.value==8){
            s="8 of";
        }
        else if(a.value==9){
            s="9 of";
        }
        else if(a.value==10){
            s="10 of";
        }
        if(a.suit==1){
           s=s +" Hearts";
        }
        else if(a.suit==2){
           s=s +" Diamonds";
        }
        else if(a.suit==3){
           s=s +" Clubs";
        }
        else if(a.suit==4){
           s=s +" Spades";
        }
        return s;
      
      
        
    }

}
