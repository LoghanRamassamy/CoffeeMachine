package com.lramss;

public enum Drink implements BeverageQuantityChecker, EmailNotifier, ProductInfo {
    TEA("T", "Tea", 0.4),
    HOT_TEA("Th", "Hot Tea", 0.4),

    COFFEE("C", "Coffee", 0.6, ),
    HOT_COFFEE("Ch", "Hot Coffee",0.6),

    CHOCOLATE("H", "Chocolate",0.5),
    HOT_CHOCOLATE("Hh", "Hot Chocolate",0.5),

    ORANGE("O", "Orange",0.6);

    private String code;
    private String name;
    private double price;

    Drink(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return  "Drink = " + this.name + ", Price of drink = " + this.price + "€";
    }

    @Override
    public boolean isEmpty(String drinkWanted) {
        for(Drink drink : Drink.values()){
            if(drinkWanted.equals(drink.name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void notifyMissingProduct(String drink) {
        System.out.println("Your " + drink + " is not found ! :(");
    }
}
