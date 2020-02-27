package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;


public class BlackjackPlayer {
    private Hand hand = new Hand();
    private Player player;

    public BlackjackPlayer(Player player){
        this.player = player;
    }
    public void hit(Card c){
        hand.add(c);
    }

    public Player getPlayer(){
        return this.player;
    }

    public ArrayList<Card> getHand(){
        return hand.getHand();
    }

    public int getScore(){
        if (getHand().size() == 2 && (getHand().get(0).getRank() == 1 && getHand().get(1).getRank() == 1)){
            return 12;
        }
        else if (getHand().size() == 2 && getHand().get(0).getRank() == 1 && getHand().get(1).getRank() > 10) {
            return 21;
        }
        else if (getHand().size() == 2 && getHand().get(0).getRank() == 1){
            return 11 + getHand().get(1).getRank();
        }
        else if (getHand().size() == 2 && getHand().get(1).getRank() == 1){
            return 11 + getHand().get(0).getRank();
        }
        int score = 0;
        for (int i = 0; i < getHand().size(); i++) {

            if (getHand().get(i).getRank() > 10) {
                score += 10;
            } else {
                score += hand.getHand().get(i).getRank();
            }
        }
            return score;
    }

    public boolean checkBlackjack(){
        if (getScore() == 21 && hand.getHand().size() == 2){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        String s = "Your cards are";
        for (Card c : hand.getHand()) {
            s += c.toString() + "  ";
        }
        s += "and your score is " + getScore();
        return s;
    }

}