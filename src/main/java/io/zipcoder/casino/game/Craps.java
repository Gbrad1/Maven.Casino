package io.zipcoder.casino.game;

import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.HashMap;
import java.util.Map;

public class Craps{
    private CrapsPlayer crapsPlayer;
    private Map<Integer, Integer> comeBets;
    private Map<Integer, Integer> dontComeBets;
    private Integer bet;
    private Integer passLine;
    private Integer dontPassLine;
    private Integer come;
    private Integer dontCome;
    private Integer field;
    private Integer currentPoint;
    private Boolean isPointOn;
    private Boolean isCrapOut;
    private Console console;

    public Craps(CrapsPlayer crapPlayer){
        this.console = new Console(System.in, System.out);
        this.crapsPlayer = crapPlayer;
        this.comeBets = new HashMap<>(6);
        this.dontComeBets = new HashMap<>(6);
        this.isPointOn = false;
        this.isCrapOut = false;
        this.bet = 0;
        this.passLine = 0;
        this.dontPassLine = 0;
        this.come = 0;
        this.dontCome = 0;
        this.field = 0;
        for (int i = 4; i <= 6; i++) {
            comeBets.put(i, 0);
            comeBets.put(i+4, 0);
            dontComeBets.put(i, 0);
            dontComeBets.put(i+4, 0);
        }
    }

    public void play(){
        while (!isCrapOut){
            playeTurn();
        }
    }

    public void playeTurn(){
        if(!isPointOn){
            comeOutRoll();
        }else {
            decisionRoll();
        }
    }

    public void getWager(){
        if(crapsPlayer.getPlayer().getBalance() == 0){
            exit();
        }
        bet = console.getIntegerInput("Enter how much to wager");
        while(bet > crapsPlayer.getPlayer().getBalance() || bet < 1){
            bet = console.getIntegerInput("Enter how much to wager");
        }
        this.bet = bet;
    }

    public void getWager(String prompt){
        if(crapsPlayer.getPlayer().getBalance() == 0){
            exit();
        }
         bet = console.getIntegerInput(prompt);
        while(bet > crapsPlayer.getPlayer().getBalance() || bet < 0){
            bet = console.getIntegerInput(prompt);
        }
        this.bet = bet;
    }

    public void placeBet(){
        crapsPlayer.getPlayer().setBalance(crapsPlayer.getPlayer().getBalance() - bet);
    }

    public void getWinnings(Integer amount){
        crapsPlayer.getPlayer().setBalance(crapsPlayer.getPlayer().getBalance() + amount);
    }

    public void exit(){

    }

    public void comeOutRoll(){
        Integer passLineDecision = getPassLineDecision();
        Integer roll;
        if(passLineDecision == 1){
            getWager();
            placeBet();
            setPassLine(bet);
        }else if(passLineDecision == 2){
            getWager();
            placeBet();
            setDontPassLine(bet);
        }
        makeFieldBet();
        roll = crapsPlayer.rollDice();
        payField(roll);
        checkLineBetComeOut(roll);
        setIsPointOn();
        setCurrentPoint(roll);
        playeTurn();
    }

    public void decisionRoll(){
        Integer decision = getDecision();
        if(decision == 1){
            getWager();
            placeBet();
            setCome(bet);
        }else if(decision == 2){
            getWager();
            placeBet();
            setDontCome(bet);
        }
        makeFieldBet();
        Integer roll = crapsPlayer.rollDice();
        payField(roll);
        checkLineBetPointOn(roll);
        playeTurn();
    }

    public Integer getDecision(){
        Integer decision = console.getIntegerInput("1 - Place Come bet\n" +
                "2 - Place Don't Come bet\n" + "3 - Roll dice");
        while(decision > 4 || decision < 1){
            decision = console.getIntegerInput("1 - Place Come bet\n" +
                    "2 - Place Don't Come bet\n" + "3 - Roll dice");
        }
        return decision;
    }

    public Integer getPassLineDecision(){
        Integer decision = console.getIntegerInput("1 - Pass Line\n" +
                "2 - Don't Pass Line");
        while (decision != 1 && decision != 2){
            decision = console.getIntegerInput("1 - Pass Line\n" +
                    "2 - Don't Pass Line");
        }
        return decision;
    }

    public void payField(Integer roll){
        if((roll >= 3 && roll < 5) || (roll >= 9 && roll < 12)){
            getWinnings(getField());
        }else if(roll == 2 || roll == 12){
            getWinnings(getField()*2);
        }
        else {
            setField(0);
        }
    }

    public void makeFieldBet(){
        getWager("How much plays the field? (Enter bet >= 0");
        placeBet();
        setField(bet + getField());
    }

    public void checkSeven(Boolean crapOut){
        clearComeBets();
        if(crapOut){
            setIsPointOn();
            setCurrentPoint(0);
            setIsCrapOut();
            exit();
        }else {
            playeTurn();
        }
    }

    public void checkLineBetComeOut(Integer roll){
        if(roll == 7 || roll == 11){
            updatePassLine("pass");
            if(roll == 7){
                checkSeven(isCrapOut);
            }
            playeTurn();
        }else if(roll == 2 || roll == 3) {
            updatePassLine("dont");
            playeTurn();
        }else if(roll == 12){
            updatePassLine("12");
            playeTurn();
        }
    }

    public void checkLineBetPointOn(Integer roll){
        if(roll == 7){
            updatePassLine("dont");
            setIsCrapOut();
            checkSeven(isCrapOut);
        }else if (roll == currentPoint){
            updatePassLine("pass");
            updateComeBets(roll);
            setIsPointOn();
            setCurrentPoint(0);
        }else if((roll != currentPoint) && (roll >= 4 && roll <= 10)){
            updateComeBets(roll);
        }
    }

    public void updateComeBets(Integer roll){
        dontComeBets.replace(roll, getDontCome());
        getWinnings(comeBets.get(roll));
        comeBets.replace(roll, getCome());
    }

    public void clearComeBets(){
        for (int i = 4; i <= 6; i++) {
            getWinnings(getDontComeBets(i));
            getWinnings(getDontComeBets(i+4));
            comeBets.replace(i, 0);
            comeBets.replace(i+4, 0);
            dontComeBets.replace(i, 0);
            dontComeBets.replace(i+4, 0);
        }
    }

    public void updatePassLine(String decision){
        if(decision.equalsIgnoreCase("pass")){
            getWinnings(getPassLine());
            setDontPassLine(0);
        }else if(decision.equalsIgnoreCase("dont")){
            getWinnings(getDontPassLine());
            setPassLine(0);
        }else if(decision.equalsIgnoreCase("12")){
            setPassLine(0);
        }
    }

    public void setPassLine(Integer bet){
        passLine = bet;
    }

    public Integer getPassLine(){
        return passLine;
    }

    public void setDontPassLine(Integer bet){
        dontPassLine = bet;
    }

    public Integer getDontPassLine(){
        return dontPassLine;
    }

    public void setCome(Integer bet){
        come = bet;
    }

    public Integer getCome(){
        return come;
    }

    public void setDontCome(Integer bet){
        dontCome = bet;
    }

    public Integer getDontCome(){
        return dontCome;
    }

    public void setField(Integer bet){
        field = bet;
    }

    public Integer getField(){
        return field;
    }

    public void setCurrentPoint(Integer newPoint){
        currentPoint = newPoint;
    }

    public Integer getCurrentPoint(){
        return currentPoint;
    }

    public void setIsPointOn(){
        isPointOn = !isPointOn;
    }

    public Boolean getIsPointOn(){
        return isPointOn;
    }

    public void setComeBets(Integer number, Integer bet){
        comeBets.put(number, bet);
    }

    public Integer getComeBets(Integer number){
        return comeBets.get(number);
    }

    public void setDontComeBets(Integer number, Integer bet){
        dontComeBets.put(number, bet);
    }

    public Integer getDontComeBets(Integer number){
        return dontComeBets.get(number);
    }

    public void setIsCrapOut(){
        isCrapOut = !isCrapOut;
    }

    public Boolean getIsCrapOut(){
        return isCrapOut;
    }

    public void setBet(Integer bet){
        this.bet = bet;
    }

    public Integer getBet(){
        return this.bet;
    }
}
