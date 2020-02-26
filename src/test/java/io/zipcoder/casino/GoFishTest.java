package io.zipcoder.casino;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.GoFishDealer;
import io.zipcoder.casino.game.GoFish;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

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
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Card drawnCard = deck.popCard();
        Integer actual = deck.getStack().size();
        Integer expected = 51;

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

}
