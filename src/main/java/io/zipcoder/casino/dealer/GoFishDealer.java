package io.zipcoder.casino.dealer;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;

public class GoFishDealer {

    private Integer score = 0;
    private Hand hand = new Hand();

    public GoFishDealer() {

    }

    public void drawCard(Card c) {
        hand.add(c);
    }

    public ArrayList<Card> getDealerHand() {
        return hand.getHand();
    }

}
