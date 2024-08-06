package com.kodilla;

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
}