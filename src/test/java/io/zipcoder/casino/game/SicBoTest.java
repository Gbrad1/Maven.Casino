package io.zipcoder.casino.game;

import io.zipcoder.casino.player.SicBoPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

public class SicBoTest {

    SicBoPlayer user = new SicBoPlayer();
    SicBo sicBoGame = new SicBo(user);


    @Test
    public void placeBet() {
        Console console = new Console(System.in, System.out);
        Assert.assertTrue(sicBoGame.placeBet() > 0 && sicBoGame.placeBet() <= user.getPlayer().getBalance());
    }

    @Test
    public void play() {
    }

    @Test
    public void newRoll() {
    }

    @Test
    public void betSmall() {
    }

    @Test
    public void betBig() {
    }

    @Test
    public void betEven() {
    }

    @Test
    public void betOdd() {
    }

    @Test
    public void betTriple() {
    }
}