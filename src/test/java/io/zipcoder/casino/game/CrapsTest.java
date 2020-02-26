package io.zipcoder.casino.game;

import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    Player testUser;
    CrapsPlayer testPlayer;
    Craps testCraps;
    Integer expectedBet;

    @Before
    public void init(){
        testUser = new Player("test", 21);
        testPlayer = new CrapsPlayer(testUser);
        testCraps = new Craps(testPlayer);
        expectedBet = 20;
    }

    @Test
    public void constructorTest(){
        Boolean expectedIsPoint = false;
        Boolean actualIsPoint = testCraps.getIsPointOn();

        assertEquals(expectedIsPoint, actualIsPoint);
    }

    @Test
    public void isPointOnTest(){
        Boolean expectedIsPoint = true;

        testCraps.setIsPointOn();
        Boolean actualIsPoint = testCraps.getIsPointOn();

        assertEquals(expectedIsPoint, actualIsPoint);
    }

    @Test
    public void setGetComeBetsTest(){
        testCraps.setComeBets(4, expectedBet);

        Integer actualBet = testCraps.getComeBets(4);

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetDontComeBetsTest(){
        testCraps.setDontComeBets(6, expectedBet);

        Integer actualBet = testCraps.getDontComeBets(6);

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetPassLineTest(){
        testCraps.setPassLine(expectedBet);

        Integer actualBet = testCraps.getPassLine();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetDontPassLineTest(){
        testCraps.setDontPassLine(expectedBet);

        Integer actualBet = testCraps.getDontPassLine();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetComeTest(){
        testCraps.setCome(expectedBet);

        Integer actualBet = testCraps.getCome();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetDontComeTest(){
        testCraps.setDontCome(expectedBet);

        Integer actualBet = testCraps.getDontCome();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetFieldTest(){
        testCraps.setField(expectedBet);

        Integer actualBet = testCraps.getField();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetCurrentPointTest(){
        Integer expectedCurrentPoint = 6;
        testCraps.setCurrentPoint(expectedCurrentPoint);

        Integer actualCurrent = testCraps.getCurrentPoint();

        assertEquals(expectedCurrentPoint, actualCurrent);
    }

    @Test
    public void payPassLineTest(){
        testCraps.setPassLine(expectedBet);
        testCraps.updatePassLine("pass");

        Integer expectedBalance = 520;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void setGetBet(){
        testCraps.setBet(expectedBet);

        Integer actualBet = testCraps.getBet();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void placeBetTest(){
        testCraps.setBet(expectedBet);
        testCraps.placeBet();

        Integer expectedBalance = 480;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payDontPassLineTest(){
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("dont");

        Integer expectedBalance = 520;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payDontPassLineTest2(){
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("12");

        Integer expectedBalance = 500;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payFieldTest(){
        testCraps.setField(expectedBet);

        Integer expectedField = 0;
        testCraps.payField(8);
        Integer actualField = testCraps.getField();

        assertEquals(expectedField, actualField);
    }

    @Test
    public void payFieldTest2(){
        testCraps.setField(expectedBet);

        Integer expectedBalance = 540;
        testCraps.payField(12);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void clearComeTest(){
        testCraps.setComeBets(4, expectedBet);
        testCraps.setDontComeBets(10, expectedBet);

        Integer expectedComeBets = 0;
        testCraps.clearComeBets();
        Integer actual4Come = testCraps.getComeBets(4);
        Integer actual10DontCome = testCraps.getDontComeBets(10);

        assertEquals(expectedComeBets, actual4Come);
        assertEquals(expectedComeBets, actual10DontCome);
    }

    @Test
    public void updateComeTest(){
        testCraps.setComeBets(4, expectedBet);
        testCraps.setDontComeBets(4, expectedBet);
        testCraps.setDontCome(0);
        testCraps.setCome(40);

        Integer expectedComeBets = 40;
        Integer expectedDonComeBets = 0;
        Integer expectedBalance = 520;
        testCraps.updateComeBets(4);
        Integer actual4Come = testCraps.getComeBets(4);
        Integer actual4DontCome = testCraps.getDontComeBets(4);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedComeBets, actual4Come);
        assertEquals(expectedDonComeBets, actual4DontCome);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void isCrapOutTest(){
        Boolean expectedIsPoint = true;

        testCraps.setIsCrapOut();
        Boolean actualIsCrapOut = testCraps.getIsCrapOut();

        assertEquals(expectedIsPoint, actualIsCrapOut);
    }

    @Test
    public void checkSevenTest(){
        testCraps.setDontComeBets(4, expectedBet);
        testCraps.setDontComeBets(5, expectedBet);
        testCraps.setDontComeBets(10, expectedBet);

        Integer expectedBalance = 560;
        testCraps.checkSeven(true);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }
}