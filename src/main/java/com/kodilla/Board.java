package com.kodilla;

import java.util.Arrays;

public class Board {

    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public boolean isFull() {
        boolean result = Arrays.stream(board)
                .map(String::valueOf)
                .anyMatch(row -> row.contains(" "));
        return !result;
    }

    public void updateBoard(int[] position, char sign) {
        int x = position[0];
        int y = position[1];
        board[x][y] = sign;
    }

    public char[][] getBoard() {
        return board;
    }
}