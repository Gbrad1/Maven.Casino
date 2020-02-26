package io.zipcoder.casino.dealer;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;

public class BlackjackDealer {

    private Hand hand = new Hand();

    public void hit(Card c) {
        hand.add(c);
    }


    public ArrayList<Card> getHand(){
        return hand.getHand();
    }

    public int getScore(){
        if (getHand().size() == 2 && (getHand().get(0).getRank() == 1 && getHand().get(1).getRank() == 1)){
            return 12;
        }
        else if (getHand().size() == 2 && getHand().get(0).getRank() == 1){
            return 11 + getHand().get(1).getRank();
        }
        else if (getHand().size() == 2 && getHand().get(1).getRank() == 1){
            return 11 + getHand().get(0).getRank();
        }
        int score = 0;
        for (int i = 0; i < getHand().size(); i++) {
            if(getHand().get(i).getRank() > 10) {
                score += 10;
            } else {
            score += hand.getHand().get(i).getRank();
            }
        }
            return score;
    }

    public boolean checkBlackjack() {
        if (getScore() == 21 && hand.getHand().size() == 2){
            return true;
        }
            return false;
    }
}
