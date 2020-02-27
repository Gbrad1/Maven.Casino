package io.zipcoder.casino.game;

import io.zipcoder.casino.card.CrapsTable;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.HashMap;
import java.util.Map;

public class Craps{
    private CrapsPlayer crapsPlayer;
    private Map<Integer, Integer> comeBets;
    private Map<Integer, Integer> dontComeBets;
    private CrapsTable table;
    private Integer roll;
    private Integer bet;
    private Integer passLine;
    private Integer dontPassLine;
    private Integer come;
    private Integer dontCome;
    private Integer field;
    private Integer currentPoint;
    private Integer refund;
    private Boolean isStillPlaying;
    private Boolean isOnLine;
    private Boolean isPointOn;
    private Boolean isCrapOut;
    private Console console;

    public Craps(CrapsPlayer crapPlayer, CrapsTable table){
        this.console = new Console(System.in, System.out);
        this.crapsPlayer = crapPlayer;
        this.comeBets = new HashMap<>(6);
        this.dontComeBets = new HashMap<>(6);
        this.table = table;
        this.isStillPlaying = true;
        this.isOnLine = false;
        this.isPointOn = false;
        this.isCrapOut = false;
        this.passLine = 0;
        this.dontPassLine = 0;
        this.bet = 0;
        this.passLine = 0;
        this.dontPassLine = 0;
        this.come = 0;
        this.dontCome = 0;
        this.field = 0;
        this.currentPoint = 0;
        this.refund = 0;
        for (int i = 4; i <= 6; i++) {
            comeBets.put(i, 0);
            comeBets.put(i+4, 0);
            dontComeBets.put(i, 0);
            dontComeBets.put(i+4, 0);
        }
    }

    public void play(){
        playerTurn();
    }

    public void playerTurn(){
        while (true) {
            if (!isStillPlaying || (isBroke() && !isPointOn)) {
                returnBets(isPointOn);
                console.println("Thank You for playig :D");
                break;
            }
            if (!isPointOn) {
                comeOutRoll();
            } else {
                decisionRoll();
            }
        }
    }

    public void getWager(){
        if(isBroke()){
            bet = 0;
            console.println("You're out of funds. Please roll");
        }else {
            bet = console.getIntegerInput("Enter how much to wager");
            while (bet > crapsPlayer.getPlayer().getBalance() || bet < 1) {
                bet = console.getIntegerInput("Enter a valid wager");
            }
        }
    }

    public void getWager(String prompt){
        if(isBroke()){
            bet = 0;
            console.println("You're out of funds. Please roll");
        }else {
            bet = console.getIntegerInput(prompt);
            while (bet > crapsPlayer.getPlayer().getBalance() || bet < 0) {
                bet = console.getIntegerInput(prompt);
            }
        }
    }

    public void placeBet(){
        crapsPlayer.getPlayer().setBalance(crapsPlayer.getPlayer().getBalance() - bet);
    }

    public void getWinnings(Integer amount){
        crapsPlayer.getPlayer().setBalance(crapsPlayer.getPlayer().getBalance() + amount);
    }

    public void exit(){
        isStillPlaying = !isStillPlaying;
    }

    public void comeOutRoll(){
        Integer passLineDecision = 0;
        updateTable();
        if(!isOnLine) {
            passLineDecision = getPassLineDecision();
            setIsOnLine();
        }
        if(passLineDecision == 1){
            getWager();
            placeBet();
            setPassLine(bet);
        }else if(passLineDecision == 2){
            getWager();
            placeBet();
            setDontPassLine(bet);
        }else if(passLineDecision == 3){
            exit();
        }
        if(isStillPlaying) {
            makeFieldBet();
            roll = crapsPlayer.rollDice();
            payField(roll);
            checkLineBetComeOut(roll);
            setIsPointOn();
            setCurrentPoint(roll);
            playerTurn();
        }else {
            console.println("Thank You for playing :D");
        }
    }

    public void decisionRoll(){
        updateTable();
        while (true) {
            Integer decision = getDecision();
            if (decision == 1) {
                getWager();
                placeBet();
                setCome(bet);
                updateTable();
            } else if (decision == 2) {
                getWager();
                placeBet();
                setDontCome(bet);
                updateTable();
            }else if (decision == 3){
                makeFieldBet();
                updateTable();
            }else {
                break;
            }
        }
        roll = crapsPlayer.rollDice();
        payField(roll);
        checkLineBetPointOn(roll);
        playerTurn();
    }

    public Integer getDecision(){
        Integer decision = console.getIntegerInput("1 - Place Come bet\n" +
                "2 - Place Don't Come bet\n" + "3 - Wager field bet\n" +
                "4 - Roll dice");
        while(decision > 4 || decision < 1){
            decision = console.getIntegerInput("1 - Place Come bet\n" +
                    "2 - Place Don't Come bet\n" + "3 - Wager field bet\n" +
                    "4 - Roll dice");
        }
        return decision;
    }

    public Integer getPassLineDecision(){
        Integer decision = console.getIntegerInput("1 - Pass Line\n" +
                "2 - Don't Pass Line\n" + "3 - Exit");
        while (decision < 1 || decision > 3){
            decision = console.getIntegerInput("1 - Pass Line\n" +
                    "2 - Don't Pass Line\n" + "3 - Exit");
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
        getWager("How much plays the field? (Enter bet >= 0)");
        placeBet();
        setField(bet + field);
    }

    public void checkSeven(Boolean crapOut){
        clearComeBets();
        if(crapOut){
            setField(0);
            setDontCome(0);
            getWinnings(come*2);
            setCome(0);
            setIsPointOn();
            setCurrentPoint(0);
        }else {
            playerTurn();
        }
    }

    public void checkLineBetComeOut(Integer roll){
        if(roll == 7 || roll == 11){
            updatePassLine("pass");
            if(roll == 7){
                checkSeven(isCrapOut);
            }
            playerTurn();
        }else if(roll == 2 || roll == 3) {
            updatePassLine("dont");
            playerTurn();
        }else if(roll == 12){
            updatePassLine("12");
            playerTurn();
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
        }else if(roll == 2 || roll == 3){
            getWinnings(getDontCome());
            setCome(0);
        }else if(roll == 12){
            setCome(0);
        }else if(roll == 11){
            getWinnings(getCome());
            setDontCome(0);
        }
    }

    public void updateComeBets(Integer roll){
        dontComeBets.replace(roll, getDontCome());
        setDontCome(0);
        getWinnings(comeBets.get(roll));
        comeBets.replace(roll, getCome());
        come = 0;
    }

    public void clearComeBets(){
        for (int i = 4; i <= 6; i++) {
            getWinnings(getDontComeBets(i)*2);
            getWinnings(getDontComeBets(i+4)*2);
            comeBets.replace(i, 0);
            comeBets.replace(i+4, 0);
            dontComeBets.replace(i, 0);
            dontComeBets.replace(i+4, 0);
        }
    }

    public void updatePassLine(String decision){
        if(decision.equalsIgnoreCase("pass")){
            getWinnings(getPassLine()*2);
            setPassLine(0);
            setDontPassLine(0);
            setIsOnLine();
        }else if(decision.equalsIgnoreCase("dont")){
            getWinnings(getDontPassLine()*2);
            setPassLine(0);
            setDontPassLine(0);
            setIsOnLine();
        }else if(decision.equalsIgnoreCase("12")){
            setPassLine(0);
            getWinnings(getDontPassLine());
            setIsOnLine();
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

    public void setIsOnLine(){
        isOnLine = !isOnLine;
    }

    public boolean getIsStillPlaying(){
        return isStillPlaying;
    }

    public Boolean isBroke(){
        if(crapsPlayer.getPlayer().getBalance() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void returnBets(Boolean isPointOn){
        if(isPointOn){
            getWinnings(come);
            getWinnings(dontCome);
            refund += getCome() + getDontCome();
            setCome(0);
            setDontCome(0);
        }else {
            getWinnings(passLine);
            refund += passLine;
            setPassLine(0);
        }
        getWinnings(field);
        getWinnings(dontPassLine);
        refund += field + dontPassLine;
        setField(0);
        setDontPassLine(0);
        for (int i = 4; i <= 6; i++) {
            getWinnings(getDontComeBets(i));
            getWinnings(getDontComeBets(i+4));
            comeBets.replace(i, 0);
            comeBets.replace(i+4, 0);
            dontComeBets.replace(i, 0);
            dontComeBets.replace(i+4, 0);
            refund += getDontComeBets(i);
            refund += getDontComeBets(i+4);
        }
    }

    public void updateTable(){
        console.print(table.printTable(crapsPlayer.getPlayer().getBalance(), passLine,
                dontPassLine, field, come, dontCome, comeBets, dontComeBets, roll, currentPoint));
    }
}
