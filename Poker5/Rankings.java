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
import java.util.*;

public class Rankings {

    public void Rank(ArrayList<Player> players) {
        int rank = 1;
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).rank = rank;
            rank++;
        }
        boolean flag;
        int k, changes = 0;
        do {
            changes = 0;
            for (int j = 0; j < players.size() - 1; j++) {
                k = j + 1;
                if (players.get(j).BH == players.get(k).BH) {
                    if (players.get(j).HC != null) {
                        flag = compareTwo(j, k, players);
                        if (flag == true) {
                            changes++;
                        }
                    } 
                    else {
                        players.get(k).rank = players.get(j).rank;
                    }
                }
            }
            
        } while (changes != 0);

    }

    public boolean compareTwo(int one, int two, ArrayList<Player> players) {
        int size = players.get(one).HC.length;
        int temp;
        for (int i = 0; i < size; i++) {
            if (players.get(one).HC[i] != players.get(two).HC[i]) {
                if (players.get(one).HC[i] < players.get(two).HC[i]) {
                    temp = players.get(one).rank;
                    players.get(one).rank = players.get(two).rank;
                    players.get(two).rank = temp;
                    Collections.swap(players, one, two);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        players.get(two).rank = players.get(one).rank;
        return false;

    }

}
