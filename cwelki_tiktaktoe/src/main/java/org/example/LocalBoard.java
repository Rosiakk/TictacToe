package org.example;

public class LocalBoard extends Board {

    public LocalBoard(Symbol[][] symbolBoard) {
        super(symbolBoard);
    }

    @Override
    public void start() {
        Player player1 = new HumanPlayer(Symbol.O);
        Player player2 = new HumanPlayer(Symbol.X);
        playGame(player1, player2);
    }

    public static boolean winCon(Player player, Symbol[][] symbolBoard) {
        for (int i = 0; i < 3; i++) {
            if (symbolBoard[i][0] == player.symbol && symbolBoard[i][1] == player.symbol && symbolBoard[i][2] == player.symbol) {
                return true;
            }
            if (symbolBoard[0][i] == player.symbol && symbolBoard[1][i] == player.symbol && symbolBoard[2][i] == player.symbol) {
                return true;
            }
        }
        if (symbolBoard[0][0] == player.symbol && symbolBoard[1][1] == player.symbol && symbolBoard[2][2] == player.symbol) {
            return true;
        }
        if (symbolBoard[0][2] == player.symbol && symbolBoard[1][1] == player.symbol && symbolBoard[2][0] == player.symbol) {
            return true;
        }
        return false;
    }

    public boolean drawCon(Symbol[][] symbolBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (symbolBoard[i][j] == Symbol.B) {
                    return false; // Jeśli jakieś pole jest puste, nie mamy remisu
                }
            }
        }
        return true; // Wszystkie pola są zapełnione, remis
    }

    public void setBlankBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                symbolBoard[i][j] = Symbol.B; // Inicjalizacja pustej planszy
            }
        }
    }

    @Override
    public void playGame(Player player1, Player player2) {
        int count = 1;
        setBlankBoard();
        while (!winCon(player1, symbolBoard) && !winCon(player2, symbolBoard) && !drawCon(symbolBoard)) {
            System.out.println(player1.inform("Tura: " + count));
            System.out.println(player1.inform("kolo"));
            player1.playTurn(symbolBoard); // Gracz 1 wykonuje ruch
            if (winCon(player1, symbolBoard)) {
                System.out.println(player1.inform("Gracz 1 wygrał!"));
                break;
            }
            System.out.println (player2.inform("Tura:" + count));
            System.out.println (player2.inform("krzyz" ));
            ;
            player2.playTurn(symbolBoard); // Gracz 2 wykonuje ruch
            if (winCon(player2, symbolBoard)) {
                System.out.println(player2.inform("Gracz 2 wygrał!"));
                break;
            }
            if (drawCon(symbolBoard)) { // Remis, gdy plansza jest pełna
                System.out.println("Remis");
                break;
            }

            count++;
        }
    }
}