package com.lramss;

import java.text.DecimalFormat;
import java.util.List;

public class Command<T> implements EmailNotifier{
    private T obj;
    private int nbSugar;
    private boolean stick;
    private double money;

    Command() {}

    Command(T obj, double money) {
        this.obj = obj;
        this.money = money;
    }

    Command(T obj, double money, int nbSugar){
        this.obj = obj;
        this.money = money;
        this.nbSugar = Math.max(nbSugar, 0);
        this.stick = nbSugar > 0;
    }

    public T getObj() {
        return this.obj;
    }

    public double getMoney() {
        return this.money;
    }

    public int getNbSugar() {
        return this.nbSugar;
    }

    double checkMoney(){
        return this.money - this.obj.getPrice();
    }

    boolean isValideCommand(){
        return this.obj.getPrice() <= money;
    }

    String sendCommandToMaker() {
        DecimalFormat df = new DecimalFormat();
        double enoughMoney = this.checkMoney();
        String msgMoney;
        if (enoughMoney < 0)
            msgMoney = df.format(obj.getPrice() - money) + "€ is missing.";
        else
            msgMoney = enoughMoney + "€ on extra.";
        return obj.getCode() + ":" + nbSugar + ":" + stick + ": " + msgMoney;
    }

    public String toString() {
        return "Command { " + obj.toString() + " }";
    }

    double getTotalCommandSold(List<Command> list){
        double total = 0.0;
        for (Command cmd : list) {
            if(cmd.isValideCommand())
                total += cmd.obj.getPrice();
        }
        return total;
    }

    public void printAllValideCommand(List<Command> list){
        for (Command cmd : list) {
            if(cmd.isValideCommand())
                System.out.println(cmd.toString());
        }
    }

    void printAllCommand(List<Command> list){
        for (Command cmd : list)
            System.out.println(cmd.toString() + ", Valid order => " + cmd.isValideCommand());
    }

    @Override
    public void notifyMissingProduct(String product) {
        System.out.println("Your " + product + " is not found ! :(");
    }

}