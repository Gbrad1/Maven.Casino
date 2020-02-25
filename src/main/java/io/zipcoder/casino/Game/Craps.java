package io.zipcoder.casino.Game;

import io.zipcoder.casino.dice.Dice;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

public class Craps{
    private Dice dice;
    private Player user;
    private Integer passLine;
    private Integer dontPassLine;
    private Integer come;
    private Integer dontCome;
    private Integer field;
    private Integer piont;
    private Boolean isPointOn;
    private Console console;

    public Craps(Player user){
        this.console = new Console(System.in, System.out);
        this.user = user;
        this.dice = new Dice(2);
        this.isPointOn = false;
    }

    public void setPassLine(Integer bet){
        passLine = bet;
    }

    public Integer getPassLine(){
        return passLine;
    }

}
