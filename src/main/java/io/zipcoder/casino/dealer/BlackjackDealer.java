package io.zipcoder.casino.dealer;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

public class BlackjackDealer {
    private Hand hand;

    public Hand getHand() {
        return hand;
    }

    public void setHand(Card card) {
        hand.add(card);
    }
}
