package com.lramss;

import java.text.DecimalFormat;
import java.util.List;

public class Command {
    private Drink drink;
    private int nbSugar;
    private int stick;
    private double money;

    Command() {}

    Command(Drink drink, double money) {
        this.drink = drink;
        this.money = money;
    }

    Command(Drink drink, double money, int nbSugar){
        this.drink = drink;
        this.money = money;
        this.nbSugar = Math.max(nbSugar, 0);
        this.stick = (nbSugar > 0) ? 1 : 0;
    }

    Drink getDrink() {
        return this.drink;
    }

    public double getMoney() {
        return this.money;
    }

    public int getNbSugar() {
        return this.nbSugar;
    }

    double checkMoney(){
        return this.money - this.drink.price;
    }

    boolean isValideCommand(){
        return this.drink.price <= this.money;
    }

    String sendCommandToDrinkMaker() {
        DecimalFormat df = new DecimalFormat();
        double enoughMoney = this.checkMoney();
        String msgMoney;
        if (enoughMoney < 0)
            msgMoney = df.format(this.drink.price - this.money) + "€ is missing.";
        else
            msgMoney = enoughMoney + "€ on extra.";
        return this.drink.code + ":" + this.nbSugar + ":" + this.stick + ":" + msgMoney;
    }

    @Override
    public String toString() {
        return "Command { " + this.drink.toString() + " }";
    }

    double getTotalCommandSold(List<Command> list){
        double total = 0.0;
        for (Command cmd : list) {
            if(cmd.isValideCommand())
                total += cmd.drink.price;
        }
        return total;
    }

    void printAllValidCommand(List<Command> list){
        for (Command cmd : list) {
            if(cmd.isValideCommand())
                System.out.println(cmd.toString());
        }
    }

    void printAllCommand(List<Command> list){
        for (Command cmd : list)
            System.out.println(cmd.toString() + ", Valid order => " + cmd.isValideCommand());
    }

}