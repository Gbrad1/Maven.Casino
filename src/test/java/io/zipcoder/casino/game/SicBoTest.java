package io.zipcoder.casino.game;

import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

public class SicBoTest {

    SicBoPlayer user = new SicBoPlayer();
    SicBo sicBoGame = new SicBo(user);


    @Test
    public void placeBetTest() {
        Console console = new Console(System.in, System.out);
        Assert.assertTrue(sicBoGame.placeBet() > 0 && sicBoGame.placeBet() <= user.getPlayer().getBalance());
    }

    @Test
    public void playTest() {
    }

    @Test
    public void getRollTest() {

    }

    @Test
    public void betSmallTest() {
    }

    @Test
    public void betBigTest() {
    }

    @Test
    public void betEvenTest() {
    }

    @Test
    public void betOddTest() {
    }

    @Test
    public void betTripleTest() {
    }


}