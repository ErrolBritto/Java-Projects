/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

/**
 *
 * @author EB
 * @author Marc
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Dealer {

    Deck deck1;
    Hand hand1;
    Pot pot1;
    Rankings rank1;
    ArrayList<Player> players;
   

    public Dealer() {
        deck1 = new Deck();
        hand1 = new Hand();
        pot1 = new Pot();
        rank1 = new Rankings();
        players = new ArrayList();

    }

    public static void main(String[] args) {
        int turn = 0, size;
        double[] balance3=null;
        Dealer dealer1 = new Dealer();
        dealer1.createPlayers();
        dealer1.players.get(0).token = true;
        while (dealer1.players.size() != 1) {
            System.out.println();
            System.out.println("New Round\n");
            balance3=dealer1.BalanceBefore();
            dealer1.dealCards();
            dealer1.sortHand();
            dealer1.writeToFiles();
            System.out.println("Cards Have been dealt\n");
            dealer1.Ante();
            System.out.println("First round of Betting\n");
            dealer1.phase1(turn);
            dealer1.phase2(turn);
            if(dealer1.skip()==false){
            dealer1.swap();
            dealer1.sortHand();
            dealer1.writeToFiles();
            System.out.println("Second round of Betting");
            dealer1.phase3(turn);
            dealer1.phase2(turn);
            }
            dealer1.BestHand();
            dealer1.Ranking();
            dealer1.pot();
            dealer1.reArrange();
            dealer1.reset();
            dealer1.Earnings(balance3);
            dealer1.remove();
            turn=dealer1.turn();
            
        }

    }
    public double[]BalanceBefore(){
        
        double[] balance3=new double[players.size()+1];
        for(int i=0;i<players.size();i++){
            balance3[i]=players.get(i).balance;
        }
        return balance3;
    }
    public void Earnings(double[] balance3){
        System.out.println("Winners and Losers:");
        for(int i=0;i<players.size();i++){
            players.get(i).Earnings(balance3[i]);
        }
        
    }
    public boolean skip(){
        int count =0;
        for(int i=0;i<players.size();i++){
            if(players.get(i).folded==true){
                count++;
        }
    }
        if(count>=players.size()-1){
            return true;
        }
        else{
            return false;
        }
    }
    public void displayInfo(){
        for(int i=0;i<players.size();i++){
            players.get(i).dislayInfo();
        }
        System.out.println("\n");
    }
    public void pot(){
        pot1.PotWinner(players);
    }    
    public int turn() {
        boolean flag=false;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).token == true) {
                players.get(i).token = false;
                if (i + 1 == players.size()) {
                    players.get(0).token = true;
                    return 0;
                } else {
                    players.get(i + 1).token = true;
                    return i+1;
                }
            }
        }
       
        return 0;

    }

    public void phase1(int first) {
        for (int i = 0; i < players.size(); i++) {
            if(players.get(first).allIn==false){
                displayInfo();
                players.get(first).turn(players, pot1);
            }
            if (first + 1 == players.size()) {
                first = 0;
            } else {
                first++;
            }

        }
    }

    public void writeToFiles() {
        String s;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).folded == false) {
                s = players.get(i).toString();
                players.get(i).F.createFile(players.get(i).name);
                players.get(i).F.addFile(s);
                players.get(i).F.doneFile();
            }

        }

    }

    public void reset() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).reset();
        }
    }

    public void Ranking() {
        rank1.Rank(players);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).folded == true) {
                players.get(i).rank = -1;
            }
        }
    }

    public void sortHand() {
        for (int i = 0; i < players.size(); i++) {
            hand1.sortHand(players.get(i).hand);

        }
    }

    public void BestHand() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).BH = hand1.BestHand(players.get(i).hand);
            players.get(i).HC = hand1.secondaryHighCards(players.get(i).BH, players.get(i).hand);

        }
    }

    public void swap() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).folded == false) {
                players.get(i).swap();
                deck1.swapCards(players.get(i).hand, players.get(i).swap);
            }

        }

    }

    public boolean endBetting(ArrayList<Player> players) {
        double temp = -1;
        int count = 0, count2 = 0,count3=0;
        for(int j=0;j<players.size();j++){
            if(players.get(j).folded==true){
                count2++;
            }
        }
        if(count2>=players.size()-1){
            return true;
        }
        for(int k=0;k<players.size();k++){
          if(players.get(k).folded==false){
            if(players.get(k).balance2>temp){
                temp=players.get(k).balance2;
            }
          }
        }
        
        
        
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).folded == false&& players.get(i).allIn == false ) {
              if(temp>players.get(i).balance2){
              return false;
              }
            }
        
        }
        return true;
        }

    public void phase2(int first) {
        boolean flag = false;
        Player p;
        p = players.get(first);
        flag = endBetting(players);
        
        while (flag == false) {
            for (int i = 0; i < players.size(); i++) {
                if (p.folded == true||p.allIn == true) {
                    if (players.size() == first + 1) {
                        first = 0;
                        p = players.get(first);
                    } else {
                        first++;
                        p = players.get(first);
                    }
                } else {
                    break;
                }
            }
            displayInfo();
            p.turn(players, pot1);
            if (players.size() == first + 1) {
                first = 0;
                p = players.get(first);
            } else {
                first++;
                p = players.get(first);
            }
            flag = endBetting(players);
        }
        System.out.println("\n");
        displayInfo();
        

    }

    public void phase3(int first) {
        int count2=0,count3=0;
        for(int j=0;j<players.size();j++){
            if(players.get(j).folded==false &&players.get(j).allIn==false){
                count2++;
            }
            
        }
        if(count2>1){
        for (int i = 0; i < players.size(); i++) {
           if(players.get(first).folded==false &&players.get(first).allIn==false){
               count3++;
               displayInfo();
               players.get(first).turn(players, pot1);
               if(count3==count2){
                   break;
               }
               
           }
            if (first + 1 == players.size()) {
                first = 0;
            } else {
                first++;
            }

        }
        }
    }

  


  

    public void remove() {
        boolean temp;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).balance < 0.001) {
                temp=players.get(i).token;
                players.remove(i);
                if(temp==true&&players.size()>1){
                    passToken(i);
                }
                i=-1;
            }
        }

    }
    public void passToken(int temp){
        if(temp+1==players.size()){
            players.get(0).token=true;
        }
        else{
            players.get(temp+1).token=true;
        }
        
    }
    public void reArrange() {
        Collections.sort(players);
    }

    public void dealCards() {
        deck1.generateDeck();
        for (int i = 0; i < players.size(); i++) {
            players.get(i).hand = deck1.drawHand();
        }
    }

    public void Ante() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).Ante(pot1);
        }
    }

    public void createPlayers() {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int amount;
        String name = null;
        System.out.println("Enter the amount of players? A maximum of 5 players allowed");
        amount = scan1.nextInt();
        int j;
        for (int i = 0; i < amount; i++) {
            j = i + 1;
            System.out.println("Enter player " + j + " name");
            name = scan2.nextLine();
            players.add(new Player(name));
        }
       

    }

}
