package com.lramss;

public class Main {

    public static void main(String[] args) {
	System.out.println(new Commande("C",0.2).sendCommandeToDrinkMaker());
	System.out.println(new Commande("T",2,0.20).sendCommandeToDrinkMaker());

    }
}
