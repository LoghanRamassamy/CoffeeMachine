package com.lramss;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CommandeTest {


    @Test
    public void drinkTypeIsTea() {
        Commande cmd = new Commande("T",0.20);
        assertEquals(cmd.getDrinkLibelle(), "Tea");
    }

    @Test
    public void drinkTeaPriceIs40() {
        Commande cmd = new Commande("T",0.20);
        assertEquals(cmd.getDrinkPrice(), 0.40);
    }

    @Test
    public void drinkHotCoffeePriceIs60() {
        Commande cmd = new Commande("Ch",0.30);
        assertEquals(cmd.getDrinkPrice(), 0.60);
    }

    @Test
    public void drinkHotChocolatEnough50() {
        Commande cmd = new Commande("Hh",1.0);
        assertEquals(cmd.checkMoney(), 0.50);
    }

}