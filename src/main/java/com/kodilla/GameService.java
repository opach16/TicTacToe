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
                playerMove = currentPlayer.move(board);
            } while (!isValidMove(board, playerMove));
            board.updateBoard(playerMove, currentPlayer.getSign());
            if (isWinner(board.getBoard())) {
                currentPlayer.addPoint();
                break;
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    public boolean isWinner(char[][] board) {
        char sign = currentPlayer.getSign();

        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == sign) && (board[i][1] == sign) && (board[i][2] == sign)) {
                return true;
            } else if ((board[0][i] == sign) && (board[1][i] == sign) && (board[2][i] == sign)) {
                return true;
            }
        }

        if ((board[0][0] == sign) && (board[1][1] == sign) && (board[2][2] == sign)) {
            return true;
        } else if ((board[0][2] == sign) && (board[1][1] == sign) && (board[2][0] == sign)) {
            return true;
        }
        return false;
    }

    public boolean isValidMove(Board board, int[] move) {
        int x = move[0];
        int y = move[1];
        return Character.isWhitespace(board.getBoard()[x][y]);
    }
}