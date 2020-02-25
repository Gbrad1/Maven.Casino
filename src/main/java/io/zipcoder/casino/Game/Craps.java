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

    public void getWinnings(Integer amount){

    }

    public void comeOutRoll(){
        Integer passLineDecision = getPassLineDecision();
        Integer roll;
        if(passLineDecision == 1){
            setPassLine(placeBet());
            roll = dice.tossAndSum();
            if(roll == 7 || roll == 11){
                getWinnings(getPassLine());
                setPassLine(0);
                playeTurn();
            }else if(roll == 2 || roll == 3 || roll == 12){
                setPassLine(0);
                playeTurn();
            }else {
                setIsPointOn();
                setCurrentPoint(roll);
                playeTurn();
            }
        }else if(passLineDecision == 2){
            setDontPassLine(placeBet());
            roll = dice.tossAndSum();
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
        }else if(decision == 3){
            Integer roll = dice.tossAndSum();
            if(roll != 7 && roll >= 4 || roll <= 10){
                dontComeBets.replace(roll, 0);
                getWinnings(comeBets.get(roll));
                comeBets.replace(roll, getCome());
                playeTurn();
            }
        }
    }

    public Integer getDecision(){
        Integer decision = console.getIntegerInput("1 - Place Come bet\n" +
                "2 - Place Don't Come bet\n" + "3 - Roll dice");
        if(decision >= 1 || decision <= 3){
            return decision;
        }else {
            return getDecision();
        }
    }

    public Integer getPassLineDecision(){
        Integer decision = console.getIntegerInput("1 - Pass Line\n" +
                "2 - Don't Pass Line");
        if(decision == 1 || decision == 2){
            return decision;
        }
        else {
            return getPassLineDecision();
        }
    }

    public Boolean isField(Integer roll){
        if(roll <= )
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
