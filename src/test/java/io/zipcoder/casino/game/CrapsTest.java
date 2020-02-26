package io.zipcoder.casino.game;

import io.zipcoder.casino.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    Player expectedUser;
    Craps testCraps;
    Integer expectedBet;

    @Before
    public void init(){
        expectedUser = new Player();
        testCraps = new Craps(expectedUser);
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
    public void setGetCurrentPoint(){
        Integer expectedCurrentPoint = 6;
        testCraps.setCurrentPoint(expectedCurrentPoint);

        Integer actualCurrent = testCraps.getCurrentPoint();

        assertEquals(expectedCurrentPoint, actualCurrent);
    }

    @Test
    public void payDontPassLineTest(){
        testCraps.setPassLine(expectedBet);
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("dont");

        Integer expectedPass = 0;
        Integer actualPass = testCraps.getPassLine();
        Integer actualDont = testCraps.getDontPassLine();

        assertEquals(expectedBet, actualDont);
        assertEquals(expectedPass, actualPass);
    }

    @Test
    public void payDontPassLineTest2(){
        testCraps.setPassLine(expectedBet);
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("pass");

        Integer expectedDont = 0;
        Integer actualPass = testCraps.getPassLine();
        Integer actualDont = testCraps.getDontPassLine();

        assertEquals(expectedDont, actualDont);
        assertEquals(expectedBet, actualPass);
    }

    @Test
    public void payDontPassLineTest3(){
        testCraps.setPassLine(expectedBet);
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("12");

        Integer expectedPass = 0;
        Integer actualPass = testCraps.getPassLine();
        Integer actualDont = testCraps.getDontPassLine();

        assertEquals(expectedBet, actualDont);
        assertEquals(expectedPass, actualPass);
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

        Integer expectedField = expectedBet;
        testCraps.payField(12);
        Integer actualField = testCraps.getField();

        assertEquals(expectedField, actualField);
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
        testCraps.updateComeBets(4);
        Integer actual4Come = testCraps.getComeBets(4);
        Integer actual4DontCome = testCraps.getDontComeBets(4);

        assertEquals(expectedComeBets, actual4Come);
        assertEquals(expectedDonComeBets, actual4DontCome);
    }

    @Test
    public void isCrapOutTest(){
        Boolean expectedIsPoint = true;

        testCraps.setIsCrapOut();
        Boolean actualIsCrapOut = testCraps.getIsCrapOut();

        assertEquals(expectedIsPoint, actualIsCrapOut);
    }
}