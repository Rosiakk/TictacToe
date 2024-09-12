package org.example;

public abstract class Board {

    Symbol[][] symbolBoard = new Symbol[3][3];

    public Board(Symbol[][] symbolBoard) {
        this.symbolBoard = symbolBoard;
    }

    public void setSymbolBoard(Symbol symbol, int x, int y) {
        this.symbolBoard[x][y] = symbol;
    }

    public abstract void start();
    public abstract void playGame(Player player1, Player player2);
}
