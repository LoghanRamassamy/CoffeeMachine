package com.lramss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class CommandeTest {


    @Test
    public void drinkTypeIsTea() {
        assertEquals(new Commande("T",0.20).getDrinkLibelle(), "Tea");
    }

    @Test
    public void drinkTeaPriceIs40() {
        assertEquals(new Commande("T",0.20).getDrinkPrice(), 0.40);
    }

    @Test
    public void drinkHotCoffeePriceIs60() {
        assertEquals(new Commande("Ch",0.30).getDrinkPrice(), 0.60);
    }

    @Test
    public void drinkHotChocolateEnough50() {
        assertEquals(new Commande("Hh",1.0).checkMoney(), 0.50);
    }

    @Test
    public void commandeSendDrinkMaker() {
        assertEquals(new Commande("Hh",2,1.0).sendCommandeToDrinkMaker(), "Hh:2:1: 0.5€ on extra.");
    }

    @Test
    public void totalSoldDrinkWithOneValidCommande() {
        List<Commande> list = new ArrayList<>();
        list.add(new Commande("C",0.2));
        list.add(new Commande("T",2,0.20));
        list.add(new Commande("Hh",2,1.0));

        assertEquals(new Commande().getTotalCommandeSold(list), 0.5);
    }

    @Test
    public void totalSoldDrinkWithNotValidCommande() {
        List<Commande> list = new ArrayList<>();
        list.add(new Commande("C",0.2));
        list.add(new Commande("T",2,0.20));
        list.add(new Commande("Hh",2,0.01));
        list.add(new Commande("Ch",5,0.39));

        assertEquals(new Commande().getTotalCommandeSold(list), 0.0);
    }

    @Test
    public void totalSoldDrinkWithAllValidCommande() {
        List<Commande> list = new ArrayList<>();
        list.add(new Commande("C",0.6));
        list.add(new Commande("T",2,1.0));
        list.add(new Commande("Hh",2,0.5));
        list.add(new Commande("Ch",5,2.0));

        assertEquals(new Commande().getTotalCommandeSold(list), 2.1);
    }

    @Test
    public void isEmptyDrink() {
        assertTrue(new Commande().isEmpty("The HOT Coffee !"));
    }

    @Test
    public void isNotEmptyDrink() {
        assertFalse(new Commande().isEmpty("Tea"));
    }

}