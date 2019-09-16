package com.lramss;

class Command {
    private Drink drink;
    private int nbSugar;
    private int stick;
    private double money;
    private Status status;

    Command(Drink drink, double money, int nbSugar){
        this.drink = drink;
        this.money = money;
        this.nbSugar = Math.max(nbSugar, 0);
        this.stick = (nbSugar > 0) ? 1 : 0;
        this.status = isValidCommand() ? Status.VALID : Status.NO_VALID;
    }

    Drink getDrink() {
        return this.drink;
    }

    double checkMoney() {
        return this.money - this.drink.price;
    }

    boolean isValidCommand() {
        return checkMoney() >= 0;
    }

    String sendCommandToDrinkMaker() {
        double enoughMoney = this.checkMoney();
        String msgMoney;
        if (isValidCommand())
            msgMoney = enoughMoney + "€ on extra.";
        else
            msgMoney = Math.abs(enoughMoney) + "€ is missing.";
        return this.drink.code + ":" + this.nbSugar + ":" + this.stick + ":" + msgMoney;
    }

    @Override
    public String toString() {
        return "Command { " + this.drink.toString() + " }";
    }

    void printCommand() {
        System.out.println(this.toString());
    }

    void printCommand(Status status) {
        if(status.equals(this.status)) {
            printCommand();
        }
    }

}