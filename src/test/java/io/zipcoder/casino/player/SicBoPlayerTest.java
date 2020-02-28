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
    public void isTripleNotEqualTest1() {
        triple.add(3);
        triple.add(5);
        triple.add(6);
        Assert.assertFalse(user.isTriple(triple));
    }

    @Test
    public void isTripleNotEqualTest2() {
        triple.add(1);
        triple.add(3);
        triple.add(5);
        Assert.assertFalse(user.isTriple(triple));
    }

    @Test
    public void isTripleNotEqualTest3() {
        triple.add(2);
        triple.add(4);
        triple.add(5);
        Assert.assertFalse(user.isTriple(triple));
    }

    @Test
    public void isTripleEqualTest1() {
        triple.add(3);
        triple.add(3);
        triple.add(3);
        Assert.assertTrue(user.isTriple(triple));
    }

    @Test
    public void isTripleEqualTest2() {
        triple.add(2);
        triple.add(2);
        triple.add(2);
        Assert.assertTrue(user.isTriple(triple));
    }

    @Test
    public void isTripleEqualTest3() {
        triple.add(4);
        triple.add(4);
        triple.add(4);
        Assert.assertTrue(user.isTriple(triple));
    }

    @Test
    public void clearTripleTest() {
        user.addTriple(4);
        user.clearTriple();
        Assert.assertTrue(user.getTriple().isEmpty());
    }

    @Test
    public void clearTripleTest2() {
        user.addTriple(5);
        user.addTriple(3);
        user.addTriple(2);
        user.clearTriple();
        Assert.assertTrue(user.getTriple().isEmpty());
    }
}
