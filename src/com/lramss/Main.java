package com.lramss;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Command> list = new ArrayList<>();
        list.add(new Command(Drink.CHOCOLATE, 0.6,0));
        list.add(new Command(Drink.TEA, 2, 1));
        list.add(new Command(Drink.HOT_CHOCOLATE, 0.5, 2));
        list.add(new Command(Drink.HOT_COFFEE, 2.0, 5));
        list.add(new Command(Drink.ORANGE, 0.4,0));

        CommandListEngine commandList = new CommandListEngine(list);

        System.out.println("=== VALID ===");
        commandList.printCommand(Status.VALID);

        System.out.println("=== NO VALID ===");
        commandList.printCommand(Status.NO_VALID);

        System.out.println("=== ALL ===");
        commandList.printCommand();

        Command command = new Command(Drink.HOT_COFFEE, 2.0, 5);
        command.getDrink().notifyMissingDrink("Dingo");

        System.out.println( new Command(Drink.HOT_CHOCOLATE,1.0,2).sendCommandToDrinkMaker());
    }
}
