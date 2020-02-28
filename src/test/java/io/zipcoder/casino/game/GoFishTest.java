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

    Deck deck = new Deck();
    Player player = new Player();
    GoFishDealer goFishDealer = new GoFishDealer();
    GoFishPlayer goFishPlayer = new GoFishPlayer(player);
    GoFish currentGame = new GoFish(goFishPlayer, goFishDealer);

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
        currentGame.createDeck();
        currentGame.shuffleDeck();

        currentGame.setupPlayerHand();
        currentGame.setupDealerHand();

        Integer goFishPlayerHandSize = goFishPlayer.getPlayerHand().size();
        Integer goFishDealerHandSize = goFishDealer.getDealerHand().size();

        Assert.assertEquals(goFishPlayerHandSize, goFishDealerHandSize);
        LOGGER.info("\n" + goFishPlayerHandSize);
        LOGGER.info("\n" + goFishDealerHandSize);
    }

    @Test
    public void printPlayerHandTest() {
        currentGame.createDeck();
        currentGame.shuffleDeck();

        currentGame.setupPlayerHand();
        currentGame.setupDealerHand();

        currentGame.printPlayerHand();
    }

    @Test
    public void drawCardPlayerTest() {
        currentGame.createDeck();
        currentGame.shuffleDeck();
        currentGame.setupPlayerHand();

        Card card = currentGame.drawCardPlayer();
        goFishPlayer.drawCard(card);

        currentGame.printPlayerHand();

        Integer actual = goFishPlayer.getPlayerHand().size();
        Integer expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawCardDealerTest() {
        currentGame.createDeck();
        currentGame.shuffleDeck();
        currentGame.setupDealerHand();

        Card card = currentGame.drawCardDealer();
        goFishDealer.drawCard(card);

        currentGame.printDealerHand();

        Integer actual = goFishDealer.getDealerHand().size();
        Integer expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drawMoreThanOneCardForPlayerTest() {
        currentGame.createDeck();
        currentGame.shuffleDeck();
        currentGame.setupPlayerHand();

        Card c = currentGame.drawCardPlayer();
        Card c2 = currentGame.drawCardPlayer();
        goFishPlayer.drawCard(c);
        goFishPlayer.drawCard(c2);

        currentGame.printPlayerHand();

        Integer actual = goFishPlayer.getPlayerHand().size();
        Integer expected = 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setupHandForDealerTest() {
        currentGame.createDeck();
        currentGame.shuffleDeck();
        currentGame.setupDealerHand();

        currentGame.printDealerHand();

        Integer actual = goFishDealer.getDealerHand().size();
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareHandsTest() {
        currentGame.createDeck();
        currentGame.shuffleDeck();
        currentGame.setupPlayerHand();
        currentGame.setupDealerHand();

        Integer playerHandSize = goFishPlayer.getPlayerHand().size();
        Integer dealerHandSize = goFishDealer.getDealerHand().size();

        currentGame.printPlayerHand();
        currentGame.printDealerHand();

        Assert.assertEquals(playerHandSize, dealerHandSize);
        Assert.assertFalse(goFishPlayer.getPlayerHand().contains(goFishDealer.getDealerHand()));
    }

    @Test
    public void testTakingACardFromDealer() {
        deck.createDeck();
        for (int i = 0; i < 12; i++) {
            goFishPlayer.drawCard(deck.popCard());
        }
        for (int i = 13; i < 26; i++) {
            goFishDealer.drawCard(deck.popCard());
        }
        Integer expected = 9;
        currentGame.takeDealerCards(expected);
        LOGGER.info("\n");
        currentGame.printDealerHand();
        currentGame.printPlayerHand();

        Integer hand1 = goFishDealer.getDealerHand().size();
        Integer hand2 = goFishDealer.getDealerHand().size();

        Assert.assertEquals(hand1, hand2);
    }

    @Test
    public void testTakingACardFromPlayer() {
        deck.createDeck();
        for (int i = 0; i < 12; i++) {
            goFishPlayer.drawCard(deck.popCard());
        }
        for (int i = 13; i < 26; i++) {
            goFishDealer.drawCard(deck.popCard());
        }
        Integer expected = 9;
        currentGame.takePlayerCards(expected);
        currentGame.printDealerHand();
        currentGame.printPlayerHand();

        Integer hand1 = goFishDealer.getDealerHand().size();
        Integer hand2 = goFishDealer.getDealerHand().size();

        Assert.assertEquals(hand1, hand2);
    }

    @Test
    public void checkPlayerHandTest() {
        currentGame.createDeck();
        currentGame.setupPlayerHand();
        currentGame.createDeck();
        currentGame.setupDealerHand();
        Integer toTest = currentGame.dealerChoiceToRequestFromPlayer();
        Assert.assertTrue(currentGame.checkPlayerHand(toTest));
    }

    @Test
    public void checkDealerHandTest() {
        currentGame.createDeck();
        currentGame.setupPlayerHand();
        currentGame.createDeck();
        currentGame.setupDealerHand();
        Assert.assertTrue(currentGame.checkDealerHand(12));
    }

    @Test
    public void checkWinConditionTest() {
        goFishDealer.getDealerScore();
        goFishPlayer.getPlayerScore();
        for (int i = 0; i < 5; i++) {
            goFishDealer.addBookToDealer();
        }
        for (int i = 0; i < 8; i++) {
            goFishPlayer.addBookToPlayer();
        }
        Assert.assertTrue(currentGame.checkWinCondition());
    }

    /*@Test
    public void dealerChoiceToRequestFromPlayerTest() {
        currentGame.createDeck();
        currentGame.setupDealerHand();
        currentGame.sortDealerHand();
        goFishDealer.getDealerHand();
        Integer a = currentGame.dealerChoiceToRequestFromPlayer();
        goFishDealer.getDealerHand().get(a);
        Assert.assertTrue();
        LOGGER.info("\n" + a);
    }*/

}
