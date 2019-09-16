package com.lramss;

import java.util.List;

public class Command {
    private Drink drink;
    private int nbSugar;
    private int stick;
    private double money;
    private Status status;

    Command() {}

    Command(Drink drink, double money) {
        this.drink = drink;
        this.money = money;
        this.status = isValidCommand() ? Status.VALID : Status.NO_VALID;
    }

    Command(Drink drink, double money, int nbSugar){
        this.drink = drink;
        this.money = money;
        this.nbSugar = Math.max(nbSugar, 0);
        this.stick = (nbSugar > 0) ? 1 : 0;
        this.status = isValidCommand() ? Status.VALID : Status.NO_VALID;
    }

    Drink getDrink() {
        return this.drink;
    }

    double checkMoney(){
        return this.money - this.drink.price;
    }

    boolean isValidCommand(){
        return checkMoney() >= 0;
    }

    String sendCommandToDrinkMaker() {
        double enoughMoney = this.checkMoney();
        String msgMoney;
        if (isValidCommand())
            msgMoney = enoughMoney + "€ on extra.";
        else
            msgMoney = Math.abs(enoughMoney) + "€ is missing.";
        return this.drink.code + ":" + this.nbSugar + ":" + this.stick + ":" + msgMoney;
    }

    @Override
    public String toString() {
        return "Command { " + this.drink.toString() + " }";
    }

    double getTotalCommandSold(List<Command> list){
        double total = 0.0;
        for (Command cmd : list) {
            if(cmd.isValidCommand())
                total += cmd.drink.price;
        }
        return total;
    }

    void printCommand(Command cmd) {
        System.out.println(cmd.toString());
    }

    void printCommand(Command cmd, Status status) {
        if(status.equals(cmd.status)) {
            printCommand(cmd);
        }
    }

    void printCommand(List<Command> list){
        for (Command cmd : list) {
            printCommand(cmd);
        }
    }

    void printCommand(List<Command> list, Status status){
        for (Command cmd : list) {
            printCommand(cmd, status);
        }
    }


}