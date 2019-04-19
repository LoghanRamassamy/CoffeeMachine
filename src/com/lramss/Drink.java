package com.lramss;

public enum Drink {
    TEA("T", "Tea", 0.4),
    HOT_TEA("Th", "Hot Tea", 0.4),

    COFFEE("C", "Coffee", 0.6),
    HOT_COFFEE("Ch", "Hot Coffee",0.6),

    CHOCOLATE("H", "Chocolate",0.5),
    HOT_CHOCOLATE("Hh", "Hot Chocolate",0.5),

    ORANGE("O", "Orange",0.6);

    private final String code;
    private final String libelle;
    private final double price;

    Drink(String code, String libelle, double price) {
        this.code = code;
        this.libelle = libelle;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrice() {
        return price;
    }
}
