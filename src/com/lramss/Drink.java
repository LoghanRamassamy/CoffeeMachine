package com.lramss;

import java.util.HashMap;
import java.util.Map;

public class Drink {
    private String drinkType;
    private int nbSugar;
    private int stick;
    private final String UNKNOWN_DRINK = "unknown drink";
    private Map<String, String> drinks = new HashMap<String, String>()
    {
        {
            put("T", "Tea");
            put("C", "Coffee");
            put("H", "Chocolate");
        }
    };

    public Drink(String drinkType){
        this.drinkType = drinkType;
    }

    public Drink(String boisonType, int nbSugar){
        this.drinkType = boisonType;
        this.nbSugar = nbSugar;
        this.stick = (nbSugar > 0) ? 1 : 0;
    }

    private String defineDrink(String code){
        return drinks.getOrDefault(code,"unknown drink");
    }

    public String toStringForCustomer() {
        String msg;
        if (UNKNOWN_DRINK.equals(defineDrink(drinkType)))
            msg = "Drink maker will don't makes your drink. (" + UNKNOWN_DRINK + ")";
        else
            msg = "Drink maker makes 1 " + defineDrink(drinkType) + " with " + nbSugar + " sugar and " + stick + " stick.";
        return msg;
    }

    public String toStringForDrinkMaker() {
        return drinkType + ':' + nbSugar + ':' + stick;
    }
}
