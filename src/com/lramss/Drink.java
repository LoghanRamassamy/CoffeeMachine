package com.lramss;
public class Drink {
    private String drinkType;
    private int nbSugar;
    private int stick;

    Drink(String boisonType){
        this.drinkType = boisonType;
    }

    Drink(String boisonType, int nbSugar){
        this.drinkType = boisonType;
        this.nbSugar = nbSugar;
        this.stick = (nbSugar > 0) ? 1 : 0;
    }

    @Override
    public String toString() {
        return drinkType + ':' + nbSugar + ':' + stick;
    }
}
