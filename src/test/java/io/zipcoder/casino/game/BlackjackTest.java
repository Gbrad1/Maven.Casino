package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.game.Blackjack;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class BlackjackTest {

    private static final Logger LOGGER = Logger.getLogger(BlackjackTest.class.getName());

    @Test
    public void getDeckTest() {
    Deck deck = new Deck();
    deck.createDeck();

    Assert.assertTrue(!deck.isEmpty());
    }

    
}