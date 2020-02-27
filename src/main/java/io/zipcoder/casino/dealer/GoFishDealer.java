package io.zipcoder.casino.dealer;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;

public class GoFishDealer {


    private Integer dealerScore = 0;
    private Hand hand = new Hand();
    private ArrayList<Card> removeHolder = new ArrayList<>();

    public GoFishDealer() {

    }

    public void drawCard(Card c) {
        hand.add(c);
    }

    public ArrayList<Card> getDealerHand() {
        return hand.getHand();
    }

    public Integer addBookToDealer() {
        return dealerScore++;
    }

    public Integer getDealerScore() {
        return dealerScore;
    }

    public void removeBook(){
        hand.getHand().removeAll(removeHolder);
    }

    public void addBook() {
        Integer tempCount = 0;
        Integer tempRank = hand.getHand().get(0).getRank();
        for (int i = 1; i < hand.getSize(); i++) {
            if (!tempRank.equals(hand.getHand().get(i).getRank())){
                tempRank = hand.getHand().get(i).getRank();
                tempCount = 0;
            }
            else if (tempRank.equals(hand.getHand().get(i).getRank())){
                tempCount += 1;
                if (tempCount == 3){
                    removeHolder.add(hand.getHand().get(i));
                    removeHolder.add(hand.getHand().get(i - 1));
                    removeHolder.add(hand.getHand().get(i - 2));
                    removeHolder.add(hand.getHand().get(i - 3));
                    tempCount = 0;
                    addBookToDealer();
                }
            }
        }
        removeBook();
    }

}
