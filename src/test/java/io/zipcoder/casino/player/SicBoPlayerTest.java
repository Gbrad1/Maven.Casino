package io.zipcoder.casino.player;

import io.zipcoder.casino.game.SicBo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SicBoPlayerTest {

    SicBoPlayer user = new SicBoPlayer();
    SicBo sicboGame = new SicBo(user);


    @Test
    public void getPlayerTest() {
        Player expected = new Player();
        Player actual = user.getPlayer();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDiceTest() {
        SicBoPlayer sicBoPlayer = new SicBoPlayer();
        Assert.assertTrue(sicBoPlayer.rollDice() >= 3 && sicBoPlayer.rollDice() <= 18);
    }

    @Test
    public void isTripleEqualTest() {
        user.rollDice();
        Assert.assertFalse(user.isTriple());
    }

    @Test
    public void isTripleNotEqualTest() {
        user.rollDice();
        Assert.assertTrue(user.isTriple());
    }

    @Test
    public void clearTripleTest() {
        user.rollDice();
        user.isTriple();
        user.clearTriple();

    }
}
