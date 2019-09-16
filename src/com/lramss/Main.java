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
        commandList.add(new Command(Drink.ORANGE, 0.4));

        System.out.println("=== VALID ===");
        new Command().printCommand(commandList, Status.VALID);

        System.out.println("=== NO VALID ===");
        new Command().printCommand(commandList, Status.NO_VALID);

        System.out.println("=== ALL ===");
        new Command().printCommand(commandList);

        Command command = new Command(Drink.HOT_COFFEE, 2.0, 5);
        command.getDrink().notifyMissingDrink("Dingo");

        System.out.println( new Command(Drink.HOT_CHOCOLATE,1.0,2).sendCommandToDrinkMaker());
    }
}
