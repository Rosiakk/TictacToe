package org.example;

public class Main {
    public static void main(String[] args) {

        Symbol[][] symbols= new Symbol[3][3];
        Board gameBoard = new LocalBoard(symbols);
        gameBoard.start();


    }

}