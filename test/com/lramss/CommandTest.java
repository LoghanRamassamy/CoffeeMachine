package com.lramss;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {


    @Test
    void drinkTypeIsTea() {
        assertEquals(new Command(Drink.TEA,0.20).getDrinkname(), "Tea");
    }

    @Test
    void drinkTeaPriceIs40() {
        assertEquals(new Command(Drink.TEA,0.20)..getDrinkPrice(), 0.40);
    }

    @Test
    void drinkHotCoffeePriceIs60() {
        Command command = new Command(Drink.HOT_COFFEE,0.30);
        Drink drink = (Drink) command.getObj();
        assertEquals(drink.getPrice(), 0.60);
    }

    @Test
    void drinkHotChocolateEnough50() {
        assertEquals(new Command(Drink.HOT_CHOCOLATE,1.0).checkMoney(), 0.50);
    }

    @Test
    void CommandSendDrinkMaker() {
        assertEquals(new Command(Drink.HOT_CHOCOLATE,2,1.0).sendCommandToDrinkMaker(), "Hh:2:1: 0.5€ on extra.");
    }

    @Test
    void totalSoldDrinkWithOneValidCommand() {
        List<Command> list = new ArrayList<>();
        list.add(new Command(Drink.COFFEE,0.2));
        list.add(new Command(Drink.TEA,2,0.20));
        list.add(new Command(Drink.HOT_CHOCOLATE,2,1.0));

        assertEquals(new Command().getTotalCommandSold(list), 0.5);
    }

    @Test
    void totalSoldDrinkWithNotValidCommand() {
        List<Command> list = new ArrayList<>();
        list.add(new Command(Drink.COFFEE,0.2));
        list.add(new Command(Drink.TEA,2,0.20));
        list.add(new Command(Drink.HOT_CHOCOLATE,2,0.01));
        list.add(new Command(Drink.HOT_COFFEE,5,0.39));

        assertEquals(new Command().getTotalCommandSold(list), 0.0);
    }

    @Test
    void totalSoldDrinkWithAllValidCommand() {
        List<Command> list = new ArrayList<>();
        list.add(new Command(Drink.COFFEE,0.6));
        list.add(new Command(Drink.TEA,2,1.0));
        list.add(new Command(Drink.HOT_CHOCOLATE,2,0.5));
        list.add(new Command(Drink.HOT_COFFEE,5,2.0));

        assertEquals(new Command().getTotalCommandSold(list), 2.1);
    }

    @Test
    void isEmptyDrink() {
        assertTrue(new Command(Drink.TEA,2).isEmpty("HOT Coffee !"));
    }

    @Test
    void isNotEmptyDrink() {
        assertFalse(new Command(Drink.ORANGE,2).isEmpty("Orange"));
    }
}