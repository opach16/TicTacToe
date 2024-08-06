package com.kodilla;

import com.kodilla.players.Player;

public class GameService {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Board board;
    private int[] playerMove;
    private final IOController ioController;

    public GameService(final Player player1, final Player player2, final Player currentPlayer, final IOController ioController) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
        this.ioController = ioController;
    }

    public void play() {
        board = new Board();
        while (true) {
            switchPlayer();
            if (board.isFull()) {
                ioController.draw();
                break;
            }
            ioController.displayBoard(board);
            do {
                playerMove = currentPlayer.move();
            } while (!isValidMove(playerMove));
            board.updateBoard(playerMove, currentPlayer.getSign());
            if (isWinner()) {
                currentPlayer.addPoint();
                break;
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    public boolean isWinner() {
        char[][] b = board.getBoard();
        char sign = currentPlayer.getSign();

        for (int i = 0; i < 3; i++) {
            if (b[i][0] == sign && b[i][1] == sign && b[i][2] == sign) {
                return true;
            } else if (b[0][i] == sign && b[1][i] == sign && b[2][i] == sign) {
                return true;
            }
        }

        if (b[0][0] == sign && b[1][1] == sign && b[2][2] == sign) {
            return true;
        } else if (b[0][2] == sign && b[1][1] == sign && b[2][0] == sign) {
            return true;
        }
        return false;
    }

    public boolean isValidMove(int[] move) {
        int x = move[0];
        int y = move[1];
        return Character.isWhitespace(board.getBoard()[x][y]);
    }
}