package org.example;

import java.util.Scanner;

public class HumanPlayer extends Player {

Symbol [][]board;

    public HumanPlayer(Symbol symbol) {
        this.symbol = symbol;
    }

    private String showBoard(Symbol[][] symbolBoard) {
        System.out.println("Aktualny stan planszy:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(symbolBoard[i][j]); // Wyświetlamy symbol w danym polu
                if (j < 2) {
                    System.out.print(" | "); // Dodajemy separator między kolumnami, ale nie na końcu
                }
            }
            System.out.println(); // Przechodzimy do nowej linii po każdej kolumnie

            if (i < 2) {
                System.out.println("---------"); // Dodajemy separator poziomy między wierszami
            }
        }
        return null;
    }


    private void listenInput (Symbol[][] symbolBoard) {
            int x = 0;
            int y = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj x;");
            x = scanner.nextInt();
            System.out.println("Podaj y;");
            y = scanner.nextInt();
            if (symbolBoard[x][y] == Symbol.B) {
                symbolBoard[x][y] = this.symbol;
            } else {
                System.out.println("To pole jest już zajęte!");
            }
        }


        @Override
        public void playTurn (Symbol[][] board) {
          listenInput(board);
          showBoard(board);
          inform("Koniec tury");
        }

        @Override
        public String inform (String text){
            return text;
        }


}
