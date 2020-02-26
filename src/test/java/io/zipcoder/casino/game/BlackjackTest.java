package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Deck;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Logger;

public class BlackjackTest {

    private static final Logger LOGGER = Logger.getLogger(BlackjackTest.class.getName());


        @Test
        public void getDeckTest() {
            Deck deck = new Deck();
            deck.createDeck();

            Assert.assertTrue(!deck.isEmpty());
        }

        @Test
        public void isBlackjackTests()

    }
