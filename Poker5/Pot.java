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

public class Pot {

    double balance;
    public Pot(){
        balance=0;
    }
    public void addPot(double amount) {
        balance = balance + amount;
    }

    public void PotWinner(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList();
        int size = players.size();
        int count=1;
        int[] remove= new int[5];
        for(int j=0;j<5;j++){
            remove[j]=0;
        }
        while(balance>=0.001) {
            for(int i=0;i<players.size();i++){
               if(remove[i]!=1){
                if (players.get(i).rank ==count) {
                    winners.add(players.get(i));
                    remove[i]=1;
                }
               }
            }
            
            giveAwayPot(remove,winners,players);
            winners.clear();
            count++;
        }

    }

    public void giveAwayPot(int[] remove, ArrayList<Player> winners, ArrayList<Player> players) {
        double temp=0,pot=0,sum=0,prize=0;
        for(int i=0;i<winners.size();i++){
            sum=sum+winners.get(i).balance2;
            if(winners.get(i).balance2>temp){
                temp=winners.get(i).balance2;
            }   
        }
        for(int j=0;j<players.size();j++){
            if(remove[j]!=1){
            if(temp<players.get(j).balance2){
               pot=pot+temp;
               balance=balance-temp;
               players.get(j).balance2=players.get(j).balance2-temp;
            }
            else{
                pot=pot+players.get(j).balance2;
                balance=balance-players.get(j).balance2;
                players.get(j).balance2=0;
            }
            }
        }
                 
        for(int k=0;k<winners.size();k++){
            prize=((winners.get(k).balance2)/sum)*pot;
            winners.get(k).balance=winners.get(k).balance+prize+winners.get(k).balance2;
            balance=balance-winners.get(k).balance2;
            winners.get(k).balance2=0;
        }
        
        }
}
