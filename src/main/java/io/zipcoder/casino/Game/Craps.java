package io.zipcoder.casino.Game;

import io.zipcoder.casino.dice.Dice;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class Craps{
    private Dice dice;
    private Player user;
    private Map<Integer, Integer> comeBets;
    private Map<Integer, Integer> dontComeBets;
    private Integer passLine;
    private Integer dontPassLine;
    private Integer come;
    private Integer dontCome;
    private Integer field;
    private Integer currentPoint;
    private Boolean isPointOn;
    private Console console;

    public Craps(Player user){
        this.console = new Console(System.in, System.out);
        this.user = user;
        this.dice = new Dice(2);
        this.comeBets = new HashMap<>(6);
        this.dontComeBets = new HashMap<>(6);
        this.isPointOn = false;
        this.come = 0;
        this.dontCome = 0;
        this.field = 0;
        for (int i = 0; i < 6; i++) {
            comeBets.put(i, 0);
            dontComeBets.put(i, 0);
        }
    }

    public void play(){

    }

    public void playeTurn(){
        if(!isPointOn){
            comeOutRoll();
        }else {
            decisionRoll();
        }
    }

    public Integer placeBet(){
        return console.getIntegerInput("Enter how much to wager");
    }

    public Integer placeBet(String prompt){
        return console.getIntegerInput(prompt);
    }

    public void getWinnings(Integer amount){

    }

    public void comeOutRoll(){
        Integer passLineDecision = getPassLineDecision();
        Integer roll;
        if(passLineDecision == 1){
            setPassLine(placeBet());
            makeFieldBet();
            roll = dice.tossAndSum();
            if(isField(roll)){
                getWinnings(getField());
                setField(0);
            }else if(!isField(roll)){
                setField(0);
            }
            if(roll == 7 || roll == 11){
                getWinnings(getPassLine());
                setPassLine(0);
            }else if(roll == 2 || roll == 3 || roll == 12){
                setPassLine(0);
            }else {
                setIsPointOn();
                setCurrentPoint(roll);
            }

        }else if(passLineDecision == 2){
            setDontPassLine(placeBet());
            makeFieldBet();
            roll = dice.tossAndSum();
            if(isField(roll)){
                getWinnings(getField());
                setField(0);
            }else if(!isField(roll)){
                setField(0);
            }
            if(roll == 7 || roll == 11){
                setDontPassLine(0);
                playeTurn();
            }else if(roll == 2 || roll == 3){
                getWinnings(getDontPassLine());
                setDontPassLine(0);
                playeTurn();
            }else if( roll == 12){
                playeTurn();
            }else {
                setIsPointOn();
                setCurrentPoint(roll);
                playeTurn();
            }
        }
    }

    public void decisionRoll(){
        Integer decision = getDecision();
        if(decision == 1){
            setCome(placeBet());
        }else if(decision == 2){
            setDontCome(placeBet());
        }
        makeFieldBet();
        Integer roll = dice.tossAndSum();
        if(isField(roll)){
            getWinnings(getField());
            setField(0);
        }else if(!isField(roll)){
            setField(0);
        }
        if(roll != 7 && roll >= 4 || roll <= 10) {
            dontComeBets.replace(roll, getDontCome());
            getWinnings(comeBets.get(roll));
            comeBets.replace(roll, getCome());
            playeTurn();
        }else if(roll == 7){

        }
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
        while (decision != 2 && decision != 3){
            decision = console.getIntegerInput("1 - Pass Line\n" +
                    "2 - Don't Pass Line");
        }
        return decision;
    }

    public Boolean isField(Integer roll){
        if(roll >= 2 && roll < 5 && roll >= 9){
            return true;
        }
        return false;
    }

    public void makeFieldBet(){
        Integer bet = placeBet("How much plays the field? (Enter bet >= 0");
        while (bet < 0){
            bet = placeBet("How much plays the field? (Enter bet >= 0");
        }
        setField(bet);
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
}
