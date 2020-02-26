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
        Player player = new Player();
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();

        Assert.assertFalse(newGame.getDeck().isEmpty());
    }

    @Test
    public void createShuffleTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();


        Card firstCard = newGame.getDeck().popCard();
        LOGGER.info("" + firstCard);

        Card secondCard = newGame.getDeck().popCard();
        LOGGER.info("" + secondCard);
    }

    @Test
    public void checkPlayerHandSizeTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setHandPlayer();

        Integer expected = 2;
        Integer actual = blackjackPlayer.getHand().size();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkDealerHandSizeTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setDealerPlayer();

        Integer expected = 2;
        Integer actual = blackjackDealer.getHand().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void drawCardPlayerTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setHandPlayer();
        newGame.drawCardPlayer();

        Integer expected = 3;
        Integer actual = blackjackPlayer.getHand().size();

        Assert.assertEquals(expected, actual);


    }
    @Test
    public void drawCardDealerTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setDealerPlayer();
        newGame.drawCardDealer();

        Integer expected = 3;
        Integer actual = blackjackDealer.getHand().size();

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void getScorePlayerTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        BlackjackDealer blackjackDealer = new BlackjackDealer();
        Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setHandPlayer();
        newGame.getHandPlayer();

        String results = "";
        for (Card c : blackjackPlayer.getHand()) {
            results += c.toString()+ " " ;
        }
        Integer actual = blackjackPlayer.getScore();
        LOGGER.info("" + actual);
        LOGGER.info(results);


    }
    }










