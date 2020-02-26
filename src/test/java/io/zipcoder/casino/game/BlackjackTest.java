package io.zipcoder.casino.game;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.game.Blackjack;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class BlackjackTest {

    private static final Logger LOGGER = Logger.getLogger(BlackjackTest.class.getName());

    @Test
    public void createDeckTest() {
    Deck deck = new Deck();
    deck.createDeck();

    Assert.assertTrue(!deck.isEmpty());
    }

    @Test
    public void shuffleDeckTest() {
        Deck deck1 = new Deck();
        deck1.createDeck();
        deck1.shuffle();
        Card firstCard = deck1.popCard();
        LOGGER.info("" + firstCard);

        Deck deck2 = new Deck();
        deck2.createDeck();
        deck2.shuffle();
        Card secondCard = deck2.popCard();
        LOGGER.info("" + secondCard);

        Assert.assertNotEquals(firstCard, secondCard);
    }

    @Test
    public void shuffleDeckTest2() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Card firstCard = deck.popCard();
        LOGGER.info("" + firstCard);

        Card secondCard = deck.popCard();
        LOGGER.info("" + secondCard);

        Assert.assertNotEquals(firstCard, secondCard);
    }

    @Test
    public void checkHandSizeTest() {
        Player player = new Player();
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setHandPlayer();

        Integer expected = 2;
        Integer actual = blackjackPlayer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

}