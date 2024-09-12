package org.example;

public abstract class Player {
    Symbol symbol;
    Board board;

    public abstract void playTurn(Symbol[][] board);
    public abstract String inform(String text);


}
