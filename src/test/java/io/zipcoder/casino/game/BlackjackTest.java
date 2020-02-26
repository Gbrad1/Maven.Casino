package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Logger;

public class BlackjackTest {

    private static final Logger LOGGER = Logger.getLogger(BlackjackTest.class.getName());


        @Test
        public void createDeckTest() {
            Deck deck = new Deck();
            deck.createDeck();

            Assert.assertTrue(!deck.isEmpty());
        }

        @Test
        public void createShuffleTest() {
            Deck deck = new Deck();
            deck.shuffle();
            LOGGER.info("\n" + deck.peekStack());
            }



        }







