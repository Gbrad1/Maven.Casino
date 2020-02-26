package io.zipcoder.casino.game;
import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.player.BlackjackPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Logger;

public class BlackjackTest {

    private static final Logger LOGGER = Logger.getLogger(BlackjackTest.class.getName());
    Player player = new Player();
    BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
    BlackjackDealer blackjackDealer = new BlackjackDealer();
    Blackjack newGame = new Blackjack(blackjackPlayer, blackjackDealer);

    @Test
    public void createDeckTest() {
        newGame.createDeck();

        Assert.assertFalse(newGame.getDeck().isEmpty());
    }

    @Test
    public void createShuffleTest() {
        newGame.createDeck();
        newGame.shuffleDeck();

        Card firstCard = newGame.getDeck().popCard();
        LOGGER.info("" + firstCard);

        Card secondCard = newGame.getDeck().popCard();
        LOGGER.info("" + secondCard);
    }

     @Test
    public void checkPlayerHandSizeTest() {
        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setHandPlayer();

        Integer expected = 2;
        Integer actual = blackjackPlayer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

     @Test
    public void checkDealerHandSizeTest() {
        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setDealerPlayer();

        Integer expected = 2;
        Integer actual = blackjackDealer.getHand().size();

        Assert.assertEquals(expected, actual);
    }

     @Test
    public void drawCardPlayerTest() {
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
         newGame.createDeck();
         newGame.shuffleDeck();
         newGame.setHandPlayer();

         String result = "";
         for (Card c: blackjackPlayer.getHand()) {
             result += c.toString() + " ";
         }

         Integer actual = blackjackPlayer.getScore();
         LOGGER.info("" + actual);
         LOGGER.info(result);
    }

     @Test
    public void getScoreDealerTest() {
         newGame.createDeck();
         newGame.shuffleDeck();
         newGame.setDealerPlayer();

         String result = "";
         for (Card c: blackjackDealer.getHand()) {
             result += c.toString() + " ";
         }

         Integer actual = blackjackDealer.getScore();
         LOGGER.info("" + actual);
         LOGGER.info(result);
    }

     @Test
    public void bustPlayerTest() {
         newGame.createDeck();
         newGame.shuffleDeck();
         newGame.setHandPlayer();
         newGame.drawCardPlayer();
         newGame.drawCardPlayer();

         String result = "";
         for (Card c: blackjackPlayer.getHand()) {
             result += c.toString() + " ";
         }

         Integer total = blackjackPlayer.getScore();
         LOGGER.info(result);
         LOGGER.info("" + total);

         Assert.assertTrue(newGame.bustPlayer());
    }

     @Test
    public void bustDealerTest() {
         newGame.createDeck();
         newGame.shuffleDeck();
         newGame.setDealerPlayer();
         newGame.drawCardDealer();
         newGame.drawCardDealer();

         String result = "";
         for (Card c: blackjackDealer.getHand()) {
             result += c.toString() + " ";
         }

         Integer total = blackjackDealer.getScore();
         LOGGER.info(result);
         LOGGER.info("" + total);

         Assert.assertTrue(newGame.bustDealer());
    }

     @Test
    public void seeDealerCardTest() {
        newGame.createDeck();
        newGame.shuffleDeck();
        newGame.setDealerPlayer();

         String result = "";
         for (Card c: blackjackDealer.getHand()) {
             result += c.toString() + " ";
         }

         String str = newGame.seeDealerCard();

         LOGGER.info(result);
         LOGGER.info(str);
    }
}