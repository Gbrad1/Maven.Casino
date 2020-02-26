package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Player;
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
            Deck deck1 = new Deck();
            deck1.createDeck();
            deck1.shuffle();
            Card firstCard = deck1.popCard();
            LOGGER.info("" + firstCard);

            Card secondCard = deck1.popCard();
            LOGGER.info("" + secondCard);

            }

         @Test
        public void checkHandSizeTest() {

            Player player = new Player();
            BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
            BlackjackDealer blackjackDealer = new BlackjackDealer();
            Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

            newGame.createDeck();
            newGame.shuffleDeck();
            newGame.setHandPlayer();

            Integer actual = blackjackPlayer.getHand().size();

            Integer expected = 2;
            Assert.assertEquals(expected, actual);






         }



        }





