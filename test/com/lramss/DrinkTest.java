package com.lramss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {


    @Test
    void isEmptyDrink() {
        assertTrue(new Command(Drink.TEA,2).getDrink().isEmpty("HOT Coffee !"));
    }

    @Test
    void isNotEmptyDrink() {
        assertFalse(new Command(Drink.ORANGE,2).getDrink().isEmpty("Orange"));
    }

}