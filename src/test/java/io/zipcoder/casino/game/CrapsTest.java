package io.zipcoder.casino.game;

import io.zipcoder.casino.card.CrapsTable;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    CrapsTable testTable;
    Player testUser;
    CrapsPlayer testPlayer;
    Craps testCraps;
    Integer expectedBet;

    @Before
    public void init() {
        testTable = new CrapsTable();
        testUser = new Player("test", 21);
        testPlayer = new CrapsPlayer(testUser);
        testCraps = new Craps(testPlayer, testTable);
        expectedBet = 20;
    }

    @Test
    public void constructorTest() {
        Boolean expectedIsPoint = false;
        Boolean actualIsPoint = testCraps.getIsPointOn();

        assertEquals(expectedIsPoint, actualIsPoint);
    }

    @Test
    public void isPointOnTest() {
        Boolean expectedIsPoint = true;

        testCraps.setIsPointOn();
        Boolean actualIsPoint = testCraps.getIsPointOn();

        assertEquals(expectedIsPoint, actualIsPoint);
    }

    @Test
    public void setGetComeBetsTest() {
        testCraps.setComeBets(4, expectedBet);

        Integer actualBet = testCraps.getComeBets(4);

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetDontComeBetsTest() {
        testCraps.setDontComeBets(6, expectedBet);

        Integer actualBet = testCraps.getDontComeBets(6);

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetPassLineTest() {
        testCraps.setPassLine(expectedBet);

        Integer actualBet = testCraps.getPassLine();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetDontPassLineTest() {
        testCraps.setDontPassLine(expectedBet);

        Integer actualBet = testCraps.getDontPassLine();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetComeTest() {
        testCraps.setCome(expectedBet);

        Integer actualBet = testCraps.getCome();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetDontComeTest() {
        testCraps.setDontCome(expectedBet);

        Integer actualBet = testCraps.getDontCome();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetFieldTest() {
        testCraps.setField(expectedBet);

        Integer actualBet = testCraps.getField();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void setGetCurrentPointTest() {
        Integer expectedCurrentPoint = 6;
        testCraps.setCurrentPoint(expectedCurrentPoint);

        Integer actualCurrent = testCraps.getCurrentPoint();

        assertEquals(expectedCurrentPoint, actualCurrent);
    }

    @Test
    public void payPassLineTest() {
        testCraps.setPassLine(expectedBet);
        testCraps.updatePassLine("pass");

        Integer expectedBalance = 540;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void setGetBet() {
        testCraps.setBet(expectedBet);

        Integer actualBet = testCraps.getBet();

        assertEquals(expectedBet, actualBet);
    }

    @Test
    public void placeBetTest() {
        testCraps.setBet(expectedBet);
        testCraps.placeBet();

        Integer expectedBalance = 480;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payDontPassLineTest() {
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("dont");

        Integer expectedBalance = 540;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payDontPassLineTest2() {
        testCraps.setDontPassLine(expectedBet);
        testCraps.updatePassLine("12");

        Integer expectedBalance = 520;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payFieldTest() {
        testCraps.setField(expectedBet);

        Integer expectedField = 0;
        testCraps.payField(8);
        Integer actualField = testCraps.getField();

        assertEquals(expectedField, actualField);
    }

    @Test
    public void payFieldTest2() {
        testCraps.setField(expectedBet);

        Integer expectedBalance = 540;
        testCraps.payField(12);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void clearComeTest() {
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
    public void updateComeTest() {
        testCraps.setComeBets(4, expectedBet);
        testCraps.setDontComeBets(4, expectedBet);
        testCraps.setDontCome(0);
        testCraps.setCome(40);

        Integer expectedComeBets = 40;
        Integer expectedDonComeBets = 0;
        Integer expectedBalance = 540;
        testCraps.updateComeBets(4);
        Integer actual4Come = testCraps.getComeBets(4);
        Integer actual4DontCome = testCraps.getDontComeBets(4);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedComeBets, actual4Come);
        assertEquals(expectedDonComeBets, actual4DontCome);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void isCrapOutTest() {
        Boolean expectedIsPoint = true;

        testCraps.setIsCrapOut();
        Boolean actualIsCrapOut = testCraps.getIsCrapOut();

        assertEquals(expectedIsPoint, actualIsCrapOut);
    }

    @Test
    public void checkSevenTest() {
        testCraps.setDontComeBets(4, expectedBet);
        testCraps.setDontComeBets(5, expectedBet);
        testCraps.setDontComeBets(10, expectedBet);

        Integer expectedBalance = 620;
        testCraps.checkSeven(true);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void returnBetsTest() {
        testCraps.setCome(10);
        testCraps.setDontCome(10);
        testCraps.setPassLine(10);
        testCraps.setDontPassLine(10);
        testCraps.setComeBets(4, 10);
        testCraps.setDontComeBets(5, 10);

        Boolean pointOn = true;
        Integer expectedBalance = 540;
        testCraps.returnBets(pointOn);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void returnBetsTest2() {
        testCraps.setCome(10);
        testCraps.setDontCome(10);
        testCraps.setPassLine(10);
        testCraps.setDontPassLine(10);
        testCraps.setComeBets(4, 10);
        testCraps.setDontComeBets(5, 10);

        Boolean pointOn = false;
        Integer expectedBalance = 530;
        testCraps.returnBets(pointOn);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void checkLineBetPointOn7() {
        testCraps.setField(10);
        testCraps.setCome(10);
        testCraps.setDontCome(10);
        testCraps.setPassLine(10);
        testCraps.setDontPassLine(10);
        testCraps.setComeBets(4, 10);
        testCraps.setDontComeBets(5, 10);

        testCraps.checkLineBetPointOn(7);
        Boolean expectedCrapOut = true;
        Integer expectedBet = 0;
        Integer expectedBalance = 560;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedBet, testCraps.getField());
        assertEquals(expectedBet, testCraps.getDontCome());
        assertEquals(expectedBet, testCraps.getPassLine());
        assertEquals(expectedBet, testCraps.getComeBets(5));
        assertEquals(expectedCrapOut, testCraps.getIsCrapOut());
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void checkLineBetPointOnWin() {
        testCraps.setComeBets(5, 10);
        testCraps.setDontComeBets(5, 20);
        testCraps.setPassLine(30);
        testCraps.setDontPassLine(50);

        testCraps.setCurrentPoint(5);
        testCraps.checkLineBetPointOn(5);
        Integer expectedZero = 0;
        Integer expectedWin = 580;
        Integer actual5DontCome = testCraps.getDontComeBets(5);
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedWin, actualBalance);
        assertEquals(expectedZero, actual5DontCome);
        assertEquals(expectedZero, testCraps.getDontPassLine());

    }

    @Test
    public void checkLineBetPointOn2or3() {
        testCraps.setCome(30);
        testCraps.setDontCome(50);

        testCraps.checkLineBetPointOn(3);
        Integer expectedZero = 0;
        Integer expectedWin = 550;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedWin, actualBalance);
        assertEquals(expectedZero, testCraps.getCome());

    }

    @Test
    public void checkLineBetPointOn12() {
        testCraps.setCome(expectedBet);
        testCraps.setDontCome(50);

        testCraps.checkLineBetPointOn(12);
        Integer expectedZero = 0;
        Integer expectedDontCome = 50;
        Integer expectedWin = 500;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedWin, actualBalance);
        assertEquals(expectedDontCome, testCraps.getDontCome());
        assertEquals(expectedZero, testCraps.getCome());
    }

    @Test
    public void checkLineBetPointOn11() {
        testCraps.setCome(30);
        testCraps.setDontCome(50);

        testCraps.checkLineBetPointOn(11);
        Integer expectedZero = 0;
        Integer expectedWin = 530;
        Integer expecteCome = 30;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedWin, actualBalance);
        assertEquals(expectedZero, testCraps.getDontCome());
        assertEquals(expecteCome, testCraps.getCome());
    }

    @Test
    public void checkLineBetPointOnNum() {
        testCraps.setCome(30);
        testCraps.setDontCome(50);

        testCraps.checkLineBetPointOn(11);
        Integer expectedZero = 0;
        Integer expectedWin = 530;
        Integer expecteCome = 30;
        Integer actualBalance = testPlayer.getPlayer().getBalance();

        assertEquals(expectedWin, actualBalance);
        assertEquals(expectedZero, testCraps.getDontCome());
        assertEquals(expecteCome, testCraps.getCome());
    }

    @Test
    public void isBrokeTest() {
        Boolean expectedBoolean = false;

        Boolean actualBoolean = testCraps.isBroke();

        assertEquals(expectedBoolean, actualBoolean);
    }

    @Test
    public void isBrokeTest2() {
        Boolean expectedBoolean = true;
        testPlayer.getPlayer().setBalance(0);

        Boolean actualBoolean = testCraps.isBroke();

        assertEquals(expectedBoolean, actualBoolean);
    }

    @Test
    public void exitTest() {
        Boolean expected = false;

        testCraps.exit();
        Boolean actual = testCraps.getIsStillPlaying();

        assertEquals(expected, actual);
    }

//    @Test
//    public void checkLineBetComeOut(){
//        testCraps.setPassLine(20);
//
//        testCraps.checkLineBetComeOut(11);
//        Integer expected = 540;
//        Integer actual = testPlayer.getPlayer().getBalance();
//
//        assertEquals(expected, actual);
//    }
}