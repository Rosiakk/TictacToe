package org.example;

public class TicTacToe {
    public static void main(String[] args) {
        String trybGry= "hotseats";

        if ( trybGry.equals("hotseats")) {
            System.out.println("Tryb 'hotseats' aktywny. Rozpoczynam grę.");

            // Tworzymy planszę 3x3
            Symbol[][] symbols = new Symbol[3][3];


            // Tworzymy grę typu LocalBoard
            Board gameBoard = new LocalBoard(symbols);

            // Rozpoczynamy grę
            gameBoard.start();
        }

    }
}
