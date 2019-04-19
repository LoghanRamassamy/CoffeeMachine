package com.lramss;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Commande> list = new ArrayList<>();
        list.add(new Commande(Drink.CHOCOLATE,0.6));
        list.add(new Commande(Drink.TEA,2,1.0));
        list.add(new Commande(Drink.HOT_CHOCOLATE,2,0.5));
        list.add(new Commande(Drink.HOT_COFFEE,5,2.0));

        new Commande().printAllCommande(list);

        new Commande().notifyMissingDrink("Dingo");
    }
}
