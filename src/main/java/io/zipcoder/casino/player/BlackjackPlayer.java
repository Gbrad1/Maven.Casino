package io.zipcoder.casino.player;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Hand;

public class BlackjackPlayer{
    private Hand hand = new Hand();

    public void hit(Card c){
        hand.add(c);
    }

}
