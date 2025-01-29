package com.kodilla;

import com.kodilla.players.Player;

import java.util.Arrays;

public class Board {

    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public boolean isFull() {
        return Arrays.stream(board)
                .map(String::valueOf)
                .noneMatch(row -> row.contains(" "));
    }

    public void updateBoard(int[] position, char sign) {
        int x = position[0];
        int y = position[1];
        board[x][y] = sign;
    }

    public char[][] getBoard() {
        return board;
    }

    public void displayBoard(Player currentPlayer) {
        System.out.println("Player " + currentPlayer.getSign() + " move:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
}