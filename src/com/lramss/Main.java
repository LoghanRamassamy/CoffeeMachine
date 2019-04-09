package com.lramss;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Commande> list = new ArrayList<>();
        list.add(new Commande("C",0.6));
        list.add(new Commande("T",2,1.0));
        list.add(new Commande("Hh",2,0.5));
        list.add(new Commande("Ch",5,2.0));

        new Commande().printAllCommande(list);

        new Commande().notifyMissingDrink("Dingo");
    }
}
