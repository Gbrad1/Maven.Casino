package io.zipcoder.casino.dealer;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

import java.util.ArrayList;

public class GoFishDealer {
<<<<<<< HEAD
    private Integer score = 0;
=======

    private Integer dealerScore = 0;
>>>>>>> f072f4d8cc80f22d84fc2ec335cd370da05cc3b6
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
