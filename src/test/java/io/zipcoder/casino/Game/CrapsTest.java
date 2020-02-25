package io.zipcoder.casino.Game;

import io.zipcoder.casino.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    @Test
    public void constructorTest(){
        Player expectedUser = new Player();
        Craps testCraps = new Craps(expectedUser);

        Boolean expectedIsPoint = false;
        Boolean actualIsPoint = testCraps.getIsPointOn();

        assertEquals(expectedIsPoint, actualIsPoint);
    }

}