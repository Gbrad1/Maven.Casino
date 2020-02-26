package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

public class BlackjackPlayer extends CardPlayer{
    private Hand hand;

    public Hand getHand() {
        return hand;
    }

    @Override
    public void drawCard(Card card) {
        hand.add(card);
    }


    @Override
    public void playerTurn() {
    }
}
