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

public class Betting {

    //requires: for some i players.get(i).id==id
    //Effects: returns true if players.get(i).id==id has the option of calling 
    //         returns false if players.get(i).id==id  doesn't have the option of calling

    public boolean callTrue(ArrayList<Player> players, int id) {
        if (check(players, id) == false && raiseTrue(players, id) == false) {
            return true;
        } else {
            return false;
        }
    }

    public boolean raiseTrue(ArrayList<Player> players, int id) {
    //requires: for some i players.get(i).id==id
        //Effects: returns true if players.get(i).id==id has the option of raising 
        //         returns false if players.get(i).id==id  doesn't have the option of raising
        boolean flag;
        int count = 0, count2 = 0;
        if (check(players, id) == true) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).allIn == true && players.get(i).folded == false) {
                    count++;
                }
                if (players.get(i).folded == false && players.get(i).allIn == false) {
                    count2++;
                }
            }
            if (count2 == 1 && count >= 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public boolean raise(ArrayList<Player> players, double amount, int id) {
    //requires: for some i players.get(i).id==id and amount>=0;
        //Effects: returns true if players.get(i).id==id  can raise by that "amount"
        //         returns false if players.get(i).id==id cant raise by that "amount"
        Player P = null;
        int folded = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).id == id) {
                P = players.get(i);
            }
            if (players.get(i).folded == true) {
                folded++;
            }
        }
        if (P.balance < amount) {
            System.out.println("insufficient balance");
            return false;
        }
        if (P.balance >= 1 && amount < 1) {
            System.out.println("you must raise atleast 1$");
            return false;
        }
        int count = 0;
        for (int i = 0; i < players.size(); i++) {
            if ((players.get(i).id != id) && (players.get(i).folded == false)) {
                if (players.get(i).balance < amount) {
                    count++;
                }
            }
        }
        if (count == (players.size() - (1 + folded))) {
            System.out.println("you cannot bet that much,no one can match that amount");
            return false;
        }
        return true;
    }

    public double call(ArrayList<Player> players, int id) {
    //requires: for some i players.get(i).id==id
        //Effects: returns the amount the players.get(i).id==id must bet to call
        Player P = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).id == id) {
                P = players.get(i);
            }
        }
        double temp = -1;
        for (int j = 0; j < players.size(); j++) {
            if (players.get(j).folded == false) {
                if (players.get(j).balance2 > temp) {
                    temp = players.get(j).balance2;
                }
            }
        }
        return temp - P.balance2;

    }

    public boolean check(ArrayList<Player> players, int id) {

        Player P = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).id == id) {
                P = players.get(i);
            }
        }
        double temp = -1;
        for (int j = 0; j < players.size(); j++) {
            if (players.get(j).folded == false) {
                if (players.get(j).balance2 > temp) {
                    temp = players.get(j).balance2;
                }
            }
        }
        if (temp == P.balance2) {
            return true;
        }
        return false;

    }

    public boolean fold(ArrayList<Player> players, int id) {
        int count = 0;
        Player p;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).folded == true) {
                count++;
            }
            if (players.get(i).id == id) {
                if (players.get(i).allIn == true) {
                    return false;
                }
            }
        }
        if (count == players.size() - 1) {
            return false;
        }
        if (check(players, id) == true) {
            return false;
        }
        return true;

    }

}
