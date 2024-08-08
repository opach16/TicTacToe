package com.kodilla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("The method should return 'false' if the board is empty")
    void testIsFullWhenEmpty() {
        //when
        boolean result = board.isFull();

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("The method should return 'false' if the board contains at least one whitespace character")
    void testIsFullWhenNotFull() {
        //given
        board.updateBoard(new int[]{0, 0}, 'X');
        board.updateBoard(new int[]{0, 1}, 'O');
        board.updateBoard(new int[]{0, 2}, 'X');
        board.updateBoard(new int[]{1, 0}, 'O');
        board.updateBoard(new int[]{1, 1}, 'X');
        board.updateBoard(new int[]{1, 2}, 'O');
        board.updateBoard(new int[]{2, 0}, 'X');
        board.updateBoard(new int[]{2, 1}, 'O');
        //when
        boolean result = board.isFull();

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("The method should return 'true' if the board does not contain any whitespace character")
    void testIsFullWhenFull() {
        //given
        board.updateBoard(new int[]{0, 0}, 'X');
        board.updateBoard(new int[]{0, 1}, 'O');
        board.updateBoard(new int[]{0, 2}, 'X');
        board.updateBoard(new int[]{1, 0}, 'O');
        board.updateBoard(new int[]{1, 1}, 'X');
        board.updateBoard(new int[]{1, 2}, 'O');
        board.updateBoard(new int[]{2, 0}, 'X');
        board.updateBoard(new int[]{2, 1}, 'O');
        board.updateBoard(new int[]{2, 2}, 'X');

        //when
        boolean full = board.isFull();

        //then
        assertTrue(full);
    }

    @Test
    void testUpdateBoard() {
        //when
        board.updateBoard(new int[]{1, 1}, 'X');
        board.updateBoard(new int[]{0, 2}, 'O');
        board.updateBoard(new int[]{2, 2}, 'X');

        //then
        assertEquals('X', board.getBoard()[1][1]);
        assertEquals('O', board.getBoard()[0][2]);
        assertFalse(board.getBoard()[2][2] != 'X');
    }
}
