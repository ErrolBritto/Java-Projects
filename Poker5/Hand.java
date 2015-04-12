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
public class Hand {

    public void sortHand(Card[] five) {
        //Requires: five!=null && and five.lenght==5
        //Modifies: five
        //Effects: Sorts five in ascending order based on five[i].value.
        
        Card temp;
        for (int i = 1; i < 5; i++) {
            temp = five[i];
            int next = temp.value;
            int j = i;
            while (j > 0 && five[j - 1].value > next) {
                five[j] = five[j - 1];
                j--;
            }
            five[j] = temp;
        }
    }

    public int BestHand(Card[] five) {
        //Requires: five!=null and five.lenght==5
        //and five to be sorted in ascending order based on five[i].value
        //Effects: Finds the best poker hand in five,
        //and returns an integer value that corresponds to that poker hand
        int BH, temp;
        BH = highCard(five);
        temp = pair(five);
        if (temp > BH) {
            BH = temp;
        }
        temp = twoPair(five);
        if (temp > BH) {
            BH = temp;
        }
        temp = threeOfKind(five);
        if (temp > BH) {
            BH = temp;
        }
        temp = straight(five);
        if (temp > BH) {
            BH = temp;
        }
        temp = flush(five);
        if (temp > BH) {
            BH = temp;
        }
        temp = FourOfKind(five);
        if (temp > BH) {
            BH = temp;
        }
        temp = StraightFlush(five);
        if (temp > BH) {
            BH = temp;
        }
        return BH;

    }
    
    public int highCard(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //and five to be sorted in ascending order based on five[i].value
    //Effects: Finds the best highest card in the hand,
    //and returns an integer between 2 and 14 that corresponds to the highest card   
        return five[4].value;

    }

    public int pair(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //Effects: Finds the highest pair in the hand,
    //and returns an integer between 15 and 27 that corresponds to that pair,
    // if no pairs are found,0 is returned
        int j, flag = 0;
        for (int i = 0; i < 4; i++) {
            for (j = i + 1; j < 5; j++) {
                if ((five[i].value == five[j].value) && (five[i].value > flag)) {
                    flag = five[i].value;
                }
            }
        }
        if (flag == 0) {
            return 0;
        } else {
            return flag + 13;
        }
    }

    public int twoPair(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //Effects: Finds a two pair in the hand,
    //and returns an integer between 28 and 40 that corresponds to that two pair,
    // if no two pairs are found,0 is returned 
        int j, flag = 0, count = 0;
        for (int i = 0; i < 4; i++) {
            for (j = i + 1; j < 5; j++) {
                if ((five[i].value == five[j].value) && (five[i].value != flag)) {
                    count++;
                    if (five[i].value > flag) {
                        flag = five[i].value;
                    }
                }
            }
        }
        if (count == 2) {
            return flag + 26;
        } else {
            return 0;
        }

    }

    public int threeOfKind(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //Effects: Finds 3 of a kind in the hand,
    //and returns an integer between 41 and 53 that corresponds to that 3 of a kind,
    // if no 3 of a kind  are found,0 is returned   
        int j, count = 0;
        for (int i = 0; i < 4; i++) {
            if (count == 2) {
                return five[i - 1].value + 39;
            }
            count = 0;
            for (j = i + 1; j < 5; j++) {
                if (five[i].value == five[j].value) {
                    count++;
                }
            }
        }
        return 0;
    }

    public int straight(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //and five to be sorted in ascending order based on five[i].value
    //Effects: Finds a straight in the hand,
    //and returns an integer between 54 and 66  that corresponds to that straight,
    //if no straights  are found,0 is returned   
        if (five[0].value == 2 && five[1].value == 3 && five[2].value == 4 && five[3].value == 5 && five[4].value == 14) {
            return 57;
        }
        for (int i = 0; i < 4; i++) {
            if ((five[i].value + 1) != (five[i + 1].value)) {
                return 0;
            }
        }
        return 52 + five[4].value;
    }

    public int flush(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //and five to be sorted in ascending order based on five[i].value
    //Effects: Finds a flush in the hand,
    //and returns an integer between 67 and 79  that corresponds to that flush,
    //if no flushes are found,0 is returned     
        if ((five[0].suit == five[1].suit) && (five[0].suit == five[2].suit) && (five[0].suit == five[3].suit) && (five[0].suit == five[4].suit)) {
            return 65 + five[4].value;
        }
        return 0;
    }

    public int FullHouse(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //Effects: Finds a FullHouse in the hand,
    //and returns an integer between 80 and 92  that corresponds to that flush,
    //if no FullHouses are found,0 is returned 
        int j, count = 0, temp = 0;
        for (int i = 0; i < 4; i++) {
            if (count == 2) {
                temp = five[i - 1].value;
            }
            count = 0;
            for (j = i + 1; j < 5; j++) {
                if (five[i].value == five[j].value) {
                    count++;
                }
            }
        }
        if (temp != 0) {
            for (int i = 0; i < 4; i++) {
                for (j = i + 1; j < 5; j++) {
                    if ((five[i].value == five[j].value) && (five[i].value != temp)) {
                        return 78 + temp;
                    }
                }
            }

        }
        return 0;

    }

    public int FourOfKind(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //Effects: Finds Four of a Kind in the hand,
    //and returns an integer between 93 and 105 that corresponds to that Four of a Kind,
    //if no Four of a Kind are found,0 is returned
        int j, count = 0;
        for (int i = 0; i < 4; i++) {
            if (count == 3) {
                return five[i - 1].value + 91;
            }
            count = 0;
            for (j = i + 1; j < 5; j++) {
                if (five[i].value == five[j].value) {
                    count++;
                }
            }
        }
        return 0;

    }

    public int StraightFlush(Card[] five) {
    //Requires: five!=null and five.lenght==5
    //Effects: Finds a straight flush in the hand,
    //and returns an integer between 109 and 118 that corresponds to that Straight Flush,
    //if no Straight flushes are found,0 is returned
        boolean flag = false;
        if ((five[0].suit == five[1].suit) && (five[0].suit == five[2].suit) && (five[0].suit == five[3].suit) && (five[0].suit == five[4].suit)) {
            flag = true;
        }
        if (flag == true) {
            if (five[0].value == 2 && five[1].value == 3 && five[2].value == 4 && five[3].value == 5 && five[4].value == 14) {
                return 109;
            }
            for (int i = 0; i < 4; i++) {
                if ((five[i].value + 1) != (five[i + 1].value)) {
                    return 0;
                }
            }
            return 104 + five[4].value;

        }
        return 0;

    }

    public int[] secondaryHighCards(int id, Card[] five) {
    //Requires: five!=null and five.lenght==5
    //and five to be sorted in ascending order based on five[i].value
    //Effects: if ((id >= 2 && id <= 14) || (id >= 67 && id <= 79))
                    // returns an int[] of size 4, where 
                    //a[0] = five[3].value;
                    //a[1] = five[2].value;
                    //a[2] = five[1].value;
                    //a[3] = five[0].value;
               //if (id >= 15 && id <= 27)
                    // returns an int[] of size 3, where 
                    //a[0] = the largest five[i].value that does not have a pair
                    //a[1] = the second largest five[i].value that does not have a pair
                    //a[2] = the third largest five[i].value that does not have a pair
               //if (id >= 28 && id <= 40)
                    //returns an int[] of size 2, 
                    //a[0] = the five[i].value of the second largest pair
                    //a[1] = the five[i].value that does not hava pair
              //else
                //returns a=null
                    
        
        int[] a = null;
        if ((id >= 2 && id <= 14) || (id >= 67 && id <= 79)) {
            a = new int[4];
            a[0] = five[3].value;
            a[1] = five[2].value;
            a[2] = five[1].value;
            a[3] = five[0].value;
            
        } else if (id >= 15 && id <= 27) {
            int temp = id - 13, count = 0;
            a = new int[3];
            for (int i = 4; i>=0; i--) {
                if (five[i].value != temp) {
                    a[count] = five[i].value;
                    count++;

                }
            }
        } else if (id >= 28 && id <= 40) {
            a = new int[2];
            int temp = id - 26;
            int count = 0, flag = 0, j;
            for (int i = 0; i < 4; i++) {
                for (j = i + 1; j < 5; j++) {
                    if ((five[i].value == five[j].value) && (five[i].value != temp)) {
                        flag = five[i].value;
                        a[0] = flag;
                    }
                }
            }
            for (int k = 0; k < 5; k++) {
                if (five[k].value != temp && five[k].value != flag) {
                    a[1] = five[k].value;

                }

            }
        }
        return a;

    }
}
