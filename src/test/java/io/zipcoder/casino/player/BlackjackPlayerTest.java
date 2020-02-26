package io.zipcoder.casino.player;

import org.junit.Test;

public class BlackjackPlayerTest {
    @Test
    public void getPlayerTest() {
        Player player = new Player();
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(player);
        blackjackPlayer.getPlayer();
    }
}


