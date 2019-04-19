package com.lramss;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.List;

public class Commande implements EmailNotifier, BeverageQuantityChecker{
    private Drink drink;
    private int nbSugar;
    private int stick;
    private double money;

    public Commande(){}

    public Commande(Drink drink, double money){
        this.money = money;
        this.drink = drink;
    }

    public Commande(Drink drink, int nbSugar, double money){
        this.nbSugar = (nbSugar > 0) ? nbSugar : 0;
        this.stick = (nbSugar > 0) ? 1 : 0;
        this.money = money;
        this.drink = drink;
    }

    public String getDrinkType() {
        return drink.getCode();
    }

    public int getNbSugar() {
        return nbSugar;
    }

    public double getMoney() {
        return money;
    }

    double checkMoney(){
        return this.money - drink.getPrice();
    }

    String getDrinkLibelle() { return drink.getLibelle(); }

    Double getDrinkPrice() { return drink.getPrice(); }

    public boolean isValideCommande(){
        return drink.getPrice() <= money;
    }

    String sendCommandeToDrinkMaker() {
        DecimalFormat df = new DecimalFormat();
        double enoughMoney = checkMoney();
        String msgMoney;
        if (enoughMoney < 0)
            msgMoney = df.format(drink.getPrice() - money) + "€ is missing.";
        else
            msgMoney = enoughMoney + "€ on extra.";
        return drink.getCode() + ":" + nbSugar + ":" + stick + ": " + msgMoney;
    }

    @Override
    public String toString() {
        return "Commande {" +
                "Drink = '" + drink.getLibelle() + '\'' +
                ", Amount of sugar = " + nbSugar +
                ", Price of drink = " + drink.getPrice() +
                "€}";
    }

    public double getTotalCommandeSold(@NotNull List<Commande> list){
        double total = 0.0;
        for (Commande cmd : list) {
            if(cmd.isValideCommande())
                total += cmd.drink.getPrice();
        }
        return total;
    }

    public void printAllValideCommande(@NotNull List<Commande> list){
        for (Commande cmd : list) {
            if(cmd.isValideCommande())
                System.out.println(cmd.toString());
        }
    }

    public void printAllCommande(@NotNull List<Commande> list){
        for (Commande cmd : list)
            System.out.println(cmd.toString() + ", Valid order => " + cmd.isValideCommande());
    }

    @Override
    public boolean isEmpty(String drinkWanted) {
        return !drink.getCode().equals(drinkWanted) && !drink.getLibelle().equals(drinkWanted);
    }

    @Override
    public void notifyMissingDrink(String drink) {
        System.out.println("Your " + drink + " is not found ! :)");
    }
}