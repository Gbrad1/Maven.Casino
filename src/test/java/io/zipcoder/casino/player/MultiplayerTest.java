package io.zipcoder.casino.player;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class MultiplayerTest {

    private static final Logger LOGGER = Logger.getLogger(MultiplayerTest.class.getName());

    @Test
    public void generateIdTest(){
        Multiplayer multiplayer = new Multiplayer();

        long left = 1000;
        long right = 9999;

        LOGGER.info("\n"+multiplayer.generateId());
        LOGGER.info("\n"+multiplayer.generateId());
        LOGGER.info("\n"+multiplayer.generateId());
        LOGGER.info("\n"+multiplayer.generateId());
        LOGGER.info("\n"+multiplayer.generateId());
        LOGGER.info("\n"+multiplayer.generateId());
        LOGGER.info("\n"+multiplayer.generateId());
    }

    @Test
    public void containsIDTest(){
        Multiplayer multiplayer = new Multiplayer();
        long expectedId = 9739;

        Assert.assertTrue(multiplayer.containsID(expectedId));
    }

    @Test
    public void addAndLoginPlayerTest(){
        Multiplayer multiplayer = new Multiplayer();
        long newId = multiplayer.generateId();
        Player Zeth = new Player("Zeth", 26);

        multiplayer.add(newId, Zeth);

        Assert.assertEquals(Zeth, multiplayer.loginPlayer(newId));
    }
}
