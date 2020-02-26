package io.zipcoder.casino.player;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void playerConstructorTest() {
        String expectedName = "Steve";
        int expectedAge = 22;
        int expectedBalance = 500;

        Player steve = new Player(expectedName, expectedAge);

        Assert.assertEquals(expectedBalance, steve.getBalance());
        Assert.assertEquals(expectedName, steve.getName());
        Assert.assertEquals(expectedAge, steve.getAge());
    }
}
