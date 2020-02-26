package io.zipcoder.casino.dice;

import io.zipcoder.casino.dice.Dice;
import org.junit.Assert;
import org.junit.Test;


public class DiceTest {

    @Test
    public void tossAndSum() {
        Dice dice = new Dice(2);
        Assert.assertTrue(dice.tossAndSum() >= 2 && dice.tossAndSum() <= 12);
    }
}