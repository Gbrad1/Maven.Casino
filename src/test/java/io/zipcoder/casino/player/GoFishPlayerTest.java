package io.zipcoder.casino.player;

import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class GoFishPlayerTest {
    @Test
    public void getPlayerTest() {
        Player player = new Player();
        GoFishPlayer goFishplayer = new GoFishPlayer(player);
        goFishplayer.getPlayer();

    }
}
