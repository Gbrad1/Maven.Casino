package io.zipcoder.casino.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class SicBoPlayerTest {

    SicBoPlayer user = new SicBoPlayer();
    ArrayList<Integer> triple = new ArrayList<>();


    @Before
    public void setUp() {
        triple.clear();
    }


    @Test
    public void rollDiceTest() {
        SicBoPlayer sicBoPlayer = new SicBoPlayer();
        Assert.assertTrue(sicBoPlayer.rollDice() >= 3 && sicBoPlayer.rollDice() <= 18);
    }

    @Test
    public void isTripleNotEqualTest() {
        triple.add(3);
        triple.add(5);
        triple.add(6);
        Assert.assertFalse(user.isTriple(triple));
    }

    @Test
    public void isTripleEqualTest() {
        triple.add(3);
        triple.add(3);
        triple.add(3);
        Assert.assertTrue(user.isTriple(triple));
    }


    @Test
    public void clearTripleTest() {
        user.addTriple(4);
        user.clearTriple();
        Assert.assertTrue(user.getTriple().isEmpty());
    }
}
