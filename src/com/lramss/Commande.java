package com.lramss;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Commande {
    private String drinkType;
    private int nbSugar;
    private int stick;
    private final String UNKNOWN_DRINK = "unknown drink";
    private double money;
    private Map<String, String> drinks = new HashMap<>()
    {
        {
            put("T", "Tea");
            put("Th", "Hot Tea");

            put("C", "Coffee");
            put("Ch", "Hot Coffee");

            put("H", "Chocolate");
            put("Hh", "Hot Chocolate");

            put("O", "Orange");
        }
    };
    private Map<String, Double> drinksPrice = new HashMap<>()
    {
        {
            put("T", 0.4);
            put("Th", 0.4);

            put("C", 0.6);
            put("Ch", 0.6);

            put("H", 0.5);
            put("Hh", 0.5);

            put("O", 0.6);
        }
    };

    public Commande(String drinkType, double money){

        this.drinkType = drinkType;
        this.money = money;
    }

    public Commande(String drinkType, int nbSugar, double money){
        this.drinkType = drinkType;
        this.nbSugar = nbSugar;
        this.stick = (nbSugar > 0) ? 1 : 0;
        this.money = money;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public int getNbSugar() {
        return nbSugar;
    }

    public double getMoney() {
        return money;
    }

    String getDrinkLibelle(){
        return drinks.getOrDefault(drinkType, UNKNOWN_DRINK);
    }

    Double getDrinkPrice(){
        return drinksPrice.getOrDefault(drinkType, 0.0);
    }

    public String toStringForCustomer() {
        String msg;
        if (UNKNOWN_DRINK.equals(getDrinkLibelle()))
            msg = "Drink maker will don't makes your drink. (" + UNKNOWN_DRINK + ")";
        else
            msg = "Drink maker makes 1 " + getDrinkLibelle() + " with " + nbSugar + " sugar and " + stick + " stick.";
        return msg;
    }

    double checkMoney(){
        return this.money - getDrinkPrice();
    }

    String sendCommandeToDrinkMaker() {
        DecimalFormat df = new DecimalFormat();
        double enoughMoney = checkMoney();
        String msgMoney;
        if (enoughMoney < 0)
            msgMoney = df.format(getDrinkPrice() - this.money) + "€ is missing.";
        else
            msgMoney = enoughMoney + "€ on extra.";
        return drinkType + ":" + nbSugar + ":" + stick + ": " + msgMoney;
    }
}