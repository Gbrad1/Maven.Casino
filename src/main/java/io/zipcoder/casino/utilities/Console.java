package io.zipcoder.casino.utilities;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * You are advised against modifying this class.
 */
public final class Console {
    private final Scanner input;
    private final PrintStream output;

    public Console(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public void print(String val, Object... args) {
        output.format(val, args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }

    public void welcome() {
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ███████╗██╗██████╗      ██████╗ ██████╗ ██████╗ ███████╗\n" +
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══███╔╝██║██╔══██╗    ██╔════╝██╔═══██╗██╔══██╗██╔════╝\n" +
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║      ███╔╝ ██║██████╔╝    ██║     ██║   ██║██║  ██║█████╗  \n" +
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║     ███╔╝  ██║██╔═══╝     ██║     ██║   ██║██║  ██║██╔══╝  \n" +
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ███████╗██║██║         ╚██████╗╚██████╔╝██████╔╝███████╗\n" +
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝     ╚══════╝╚═╝╚═╝          ╚═════╝ ╚═════╝ ╚═════╝ ╚══════╝\n" +
                "                                                                                                                                                \n" +
                " ██████╗ █████╗ ███████╗██╗███╗   ██╗ ██████╗ ██╗     ██╗██████╗  ██╗     █████╗ ███╗   ██╗██████╗      ██████╗ ██╗   ██╗███████╗██████╗ ██╗    \n" +
                "██╔════╝██╔══██╗██╔════╝██║████╗  ██║██╔═══██╗██║    ██╔╝╚════██╗███║    ██╔══██╗████╗  ██║██╔══██╗    ██╔═══██╗██║   ██║██╔════╝██╔══██╗╚██╗   \n" +
                "██║     ███████║███████╗██║██╔██╗ ██║██║   ██║██║    ██║  █████╔╝╚██║    ███████║██╔██╗ ██║██║  ██║    ██║   ██║██║   ██║█████╗  ██████╔╝ ██║   \n" +
                "██║     ██╔══██║╚════██║██║██║╚██╗██║██║   ██║╚═╝    ██║ ██╔═══╝  ██║    ██╔══██║██║╚██╗██║██║  ██║    ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗ ██║   \n" +
                "╚██████╗██║  ██║███████║██║██║ ╚████║╚██████╔╝██╗    ╚██╗███████╗ ██║    ██║  ██║██║ ╚████║██████╔╝    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╔╝   \n" +
                " ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝ ╚═╝    ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝      ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝    \n" +
                "                                                                                                                                                ");
    }

    public void welcomeGoFish() {
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗      ██████╗  ██████╗ ███████╗██╗███████╗██╗  ██╗\n" +
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ██╔════╝ ██╔═══██╗██╔════╝██║██╔════╝██║  ██║\n" +
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║    ██║  ███╗██║   ██║█████╗  ██║███████╗███████║\n" +
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║    ██║   ██║██║   ██║██╔══╝  ██║╚════██║██╔══██║\n" +
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝    ╚██████╔╝╚██████╔╝██║     ██║███████║██║  ██║\n" +
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝      ╚═════╝  ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                                                                                                     ");
    }

    public void printYourOutOfMoney(){
        println("You're out of funds. Please roll");
    }

    public void printRefund(Integer refund, Integer balance){
        println("You were refunded : " + refund + ".\n" +
                "Your balance is : " + balance + ".\n" +
                "Thank You for playing :D");
    }

    public void printComeBetsWinning(Integer num, Integer winnings){
        println("You won your come bet on " + num + ": " + winnings);
    }

    public void printPayFied(boolean isDouble, Integer bet, String winLoss){
        if(isDouble && winLoss.equalsIgnoreCase("win")){
            println("You won DOUBLE your field bet: " + bet * 2);
        }else if(winLoss.equalsIgnoreCase("win")){
            println("You won your field bet: " + bet);
        }else {
            println("You lost your field bet: " + bet);
        }
    }
}