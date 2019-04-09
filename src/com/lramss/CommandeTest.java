package com.lramss;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

class CommandeTest {


    @Test
    public void drinkTypeIsTea() {
        Commande cmd = new Commande("T",0.20);
        assertEquals(cmd.getDrinkLibelle(), "tea");
    }

    @Test
    public void drinkTeaPriceIs20() {
        Commande cmd = new Commande("T",0.20);
        assertEquals(cmd.getDrinkPrice(), 0.20);
    }

}