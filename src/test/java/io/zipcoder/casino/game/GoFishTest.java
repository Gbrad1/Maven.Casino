package io.zipcoder.casino.game;

import org.junit.Test;
import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import java.util.logging.Logger;

public class GoFishTest {

    private static final Logger LOGGER = Logger.getLogger(GoFishTest.class.getName());

    @Test
    public void getDeckTest() {
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();

        Assert.assertTrue(!deck.isEmpty());
    }

    @Test
    public void drawCardTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish currentGame = new GoFish(goFishPlayer, goFishDealer);
        currentGame.createDeck();
        currentGame.shuffleDeck();
        Card drawnCard = currentGame.drawCardPlayer();
        goFishPlayer.getPlayerHand().add(drawnCard);
        Integer actual = goFishPlayer.getPlayerHand().size();
        Integer expected = 1;

        Assert.assertEquals(expected, actual);
        LOGGER.info("\n" + drawnCard);
    }

    @Test
    public void setupPlayerHand() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);
        newGame.createDeck();
        newGame.shuffleDeck();

        newGame.setupPlayerHand();
        newGame.setupDealerHand();

        Integer goFishPlayerHandSize = goFishPlayer.getPlayerHand().size();
        Integer goFishDealerHandSize = goFishDealer.getDealerHand().size();

        Assert.assertEquals(goFishPlayerHandSize, goFishDealerHandSize);
        LOGGER.info("\n" + goFishPlayerHandSize);
        LOGGER.info("\n" + goFishDealerHandSize);
    }

    @Test
    public void printPlayerHandTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        newGame.createDeck();
        newGame.shuffleDeck();

        newGame.setupPlayerHand();
        newGame.setupDealerHand();

        newGame.printPlayerHand();
    }

    @Test
    public void drawCardPlayerTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setupPlayerHand();

        Card card = newGame.drawCardPlayer();
        goFishPlayer.drawCard(card);

        newGame.printPlayerHand();

        Integer actual = goFishPlayer.getPlayerHand().size();
        Integer expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawCardDealerTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setupDealerHand();

        Card card = newGame.drawCardDealer();
        goFishDealer.drawCard(card);

        newGame.printDealerHand();

        Integer actual = goFishDealer.getDealerHand().size();
        Integer expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawMoreThanOneCardForPlayerTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setupPlayerHand();

        Card c = newGame.drawCardPlayer();
        Card c2 = newGame.drawCardPlayer();
        goFishPlayer.drawCard(c);
        goFishPlayer.drawCard(c2);

        newGame.printPlayerHand();

        Integer actual = goFishPlayer.getPlayerHand().size();
        Integer expected = 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setupHandForDealerTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setupDealerHand();

        newGame.printDealerHand();

        Integer actual = goFishDealer.getDealerHand().size();
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareHandsTest() {
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setupPlayerHand();
        newGame.setupDealerHand();

        Integer playerHandSize = goFishPlayer.getPlayerHand().size();
        Integer dealerHandSize = goFishDealer.getDealerHand().size();

        newGame.printPlayerHand();
        newGame.printDealerHand();

        Assert.assertEquals(playerHandSize, dealerHandSize);
        Assert.assertFalse(goFishPlayer.getPlayerHand().contains(goFishDealer.getDealerHand()));
    }

//    @Test
//    public void checkStartingScoreTest() {
//        Player player = new Player();
//        GoFishDealer goFishDealer = new GoFishDealer();
//        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
//        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);
//
//        newGame.createDeck();
//        newGame.shuffleDeck();
//        newGame.setupPlayerHand();
//        newGame.setupDealerHand();
//
//        Integer goFishPlayerScore = newGame.getPlayerScore();
//        Integer goFishDealerScore = newGame.getDealerScore();
//
//        Assert.assertEquals(goFishPlayerScore, goFishDealerScore);
//
//        LOGGER.info("\n" + goFishPlayerScore + "\n" + goFishDealerScore);
//    }

    @Test
    public void testTakingACardFromDealer() {
        Deck deck = new Deck();
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        deck.createDeck();
        for (int i = 0; i < 12; i++) {
            goFishPlayer.drawCard(deck.popCard());
        }
        for (int i = 13; i < 26; i++) {
            goFishDealer.drawCard(deck.popCard());
        }
        Integer expected = 9;
        newGame.takeDealerCards(expected);
        LOGGER.info("\n");
        newGame.printDealerHand();
        newGame.printPlayerHand();

        Integer hand1 = goFishDealer.getDealerHand().size();
        Integer hand2 = goFishDealer.getDealerHand().size();

        Assert.assertEquals(hand1, hand2);
    }

    @Test
    public void testTakingACardFromPlayer() {
        Deck deck = new Deck();
        Player player = new Player();
        GoFishDealer goFishDealer = new GoFishDealer();
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        GoFish newGame = new GoFish(goFishPlayer, goFishDealer);

        deck.createDeck();
        for (int i = 0; i < 12; i++) {
            goFishPlayer.drawCard(deck.popCard());
        }
        for (int i = 13; i < 26; i++) {
            goFishDealer.drawCard(deck.popCard());
        }
        Integer expected = 9;
        newGame.takePlayerCards(expected);
        newGame.printDealerHand();
        newGame.printPlayerHand();

        Integer hand1 = goFishDealer.getDealerHand().size();
        Integer hand2 = goFishDealer.getDealerHand().size();

        Assert.assertEquals(hand1, hand2);
    }

}
