package io.zipcoder.casino.player;

public class Player {
    private String name;
    private int balance;
    private int age;

    public Player(String name, int balance, int age){
        this.name = name;
        this.balance = balance;
        this.age = age;
    }

    public Player(){
    }

    public void setBalance(int newBalance){
        this.balance = newBalance;
    }

    public int getBalance(){
        return this.balance;
    }


}
