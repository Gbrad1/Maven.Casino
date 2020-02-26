package io.zipcoder.casino;

import io.zipcoder.casino.card.Deck;
import io.zipcoder.casino.dealer.BlackjackDealer;
import io.zipcoder.casino.game.Blackjack;
import io.zipcoder.casino.player.BlackjackPlayer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {
    @Test
    public void testHit() {
        //Given
BlackjackPlayer playerOne = new BlackjackPlayer();
BlackjackDealer dealerOne = new BlackjackDealer();
Blackjack newGame =  new Blackjack(playerOne, dealerOne);
    //When
    Integer expected = 1;
    Integer actual =
        //Then

        Assert.assertEquals(expected, actual);
    }

}