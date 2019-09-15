package com.lramss;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Command> commandList = new ArrayList<>();

        commandList.add(new Command(Drink.CHOCOLATE, 0.6));
        commandList.add(new Command(Drink.TEA, 2, 1));
        commandList.add(new Command(Drink.HOT_CHOCOLATE, 0.5, 2));
        commandList.add(new Command(Drink.HOT_COFFEE, 2.0, 5));

        new Command().printAllCommand(commandList);

        Command command = new Command(Drink.HOT_COFFEE, 2.0, 5);
        command.getDrink().notifyMissingDrink("Dingo");

        System.out.println( new Command(Drink.HOT_CHOCOLATE,1.0,2).sendCommandToDrinkMaker());
    }
}
