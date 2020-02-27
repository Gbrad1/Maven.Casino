package io.zipcoder.casino.player;

import io.zipcoder.casino.game.SicBo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SicBoPlayerTest {

    SicBoPlayer user = new SicBoPlayer();
    SicBo sicboGame = new SicBo(user);
    ArrayList<Integer> triple = new ArrayList<>();
    ThreadLocalRandom random = ThreadLocalRandom.current();

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
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(6) + 1;
            triple.add(num);
        }
        user.rollDice();
        boolean expected = triple.get(0) == triple.get(1) && triple.get(1) == triple.get(2);
        Assert.assertEquals(expected,user.isTriple());
    }


    @Test
    public void clearTripleTest() {
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(6) + 1;
            triple.add(num);
        }
        triple.clear();
        Assert.assertTrue(triple.isEmpty());
    }
}
