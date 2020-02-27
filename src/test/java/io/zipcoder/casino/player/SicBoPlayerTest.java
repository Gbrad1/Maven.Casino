package io.zipcoder.casino.player;

import org.junit.Assert;
import org.junit.Test;

public class SicBoPlayerTest {


    @Test
    public void getPlayerTest() {
        SicBoPlayer sicBoPlayer = new SicBoPlayer();
        Player expected = new Player();
        Player actual = sicBoPlayer.getPlayer();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDiceTest() {
        SicBoPlayer sicBoPlayer = new SicBoPlayer();
        Assert.assertTrue(sicBoPlayer.rollDice() >= 3 && sicBoPlayer.rollDice() <= 18);
    }

    @Test
    public void isTripleTest() {
        SicBoPlayer sicBoPlayer = new SicBoPlayer();

        //Assert.assertEquals();
    }
}
