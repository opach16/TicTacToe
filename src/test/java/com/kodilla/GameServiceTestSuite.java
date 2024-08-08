package com.kodilla;

import com.kodilla.players.Computer;
import com.kodilla.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTestSuite {

    private GameService gameService;

    @BeforeEach
    public void setUp() {
        Player player1 = new Computer('X');
        Player player2 = new Computer('O');
        gameService = new GameService(player1, player2, player1, new IOController());
    }

    @Test
    @DisplayName("""
            The method should return true when the board on provided position contains whitespace
            or return false when the board on provided position does not contain whitespace
            """)
    void testIsValidMove() {
        //given
        Board board = new Board();
        board.updateBoard(new int[]{1, 0}, 'X');
        board.updateBoard(new int[]{2, 0}, 'O');
        board.updateBoard(new int[]{0, 2}, 'X');

        //when
        boolean validMove = gameService.isValidMove(board, new int[]{0, 0});
        boolean validMove1 = gameService.isValidMove(board, new int[]{0, 1});
        boolean validMove2 = gameService.isValidMove(board, new int[]{2, 2});
        boolean invalidMove = gameService.isValidMove(board, new int[]{1, 0});
        boolean invalidMove1 = gameService.isValidMove(board, new int[]{2, 0});
        boolean invalidMove2 = gameService.isValidMove(board, new int[]{0, 2});

        //then
        assertTrue(validMove);
        assertTrue(validMove1);
        assertTrue(validMove2);
        assertFalse(invalidMove);
        assertFalse(invalidMove1);
        assertFalse(invalidMove2);
    }

    @Test
    @DisplayName("The test checks whether the method returns 'true' when any of the board's row contains 3 signs of currentplayer")
    void testIsWinnerHorizontal() {
        //given
        Board board = new Board();
        Board board1 = new Board();
        Board board2 = new Board();
        Board board3 = new Board();

        board.updateBoard(new int[]{0, 0}, 'X');
        board.updateBoard(new int[]{0, 1}, 'X');
        board.updateBoard(new int[]{0, 2}, 'X');

        board1.updateBoard(new int[]{1, 0}, 'X');
        board1.updateBoard(new int[]{1, 1}, 'X');
        board1.updateBoard(new int[]{1, 2}, 'X');

        board2.updateBoard(new int[]{2, 0}, 'X');
        board2.updateBoard(new int[]{2, 1}, 'X');
        board2.updateBoard(new int[]{2, 2}, 'X');

        board3.updateBoard(new int[]{2, 0}, 'X');
        board3.updateBoard(new int[]{1, 1}, 'X');
        board3.updateBoard(new int[]{2, 2}, 'X');
        board3.updateBoard(new int[]{0, 1}, 'X');

        //when & then
        assertTrue(gameService.isWinner(board.getBoard()));
        assertTrue(gameService.isWinner(board1.getBoard()));
        assertTrue(gameService.isWinner(board2.getBoard()));
        assertFalse(gameService.isWinner(board3.getBoard()));
    }

    @Test
    @DisplayName("The test checks whether the method returns 'true' when any of the board's column contains 3 signs of currentplayer")
    void testIsWinnerVertical() {
        //given
        Board board = new Board();
        Board board1 = new Board();
        Board board2 = new Board();
        Board board3 = new Board();

        board.updateBoard(new int[]{0, 0}, 'X');
        board.updateBoard(new int[]{1, 0}, 'X');
        board.updateBoard(new int[]{2, 0}, 'X');

        board1.updateBoard(new int[]{0, 1}, 'X');
        board1.updateBoard(new int[]{1, 1}, 'X');
        board1.updateBoard(new int[]{2, 1}, 'X');

        board2.updateBoard(new int[]{0, 2}, 'X');
        board2.updateBoard(new int[]{1, 2}, 'X');
        board2.updateBoard(new int[]{2, 2}, 'X');

        board3.updateBoard(new int[]{2, 0}, 'X');
        board3.updateBoard(new int[]{1, 1}, 'X');
        board3.updateBoard(new int[]{2, 2}, 'X');
        board3.updateBoard(new int[]{0, 1}, 'X');

        //when & then
        assertTrue(gameService.isWinner(board.getBoard()));
        assertTrue(gameService.isWinner(board1.getBoard()));
        assertTrue(gameService.isWinner(board2.getBoard()));
        assertFalse(gameService.isWinner(board3.getBoard()));
    }

    @Test
    @DisplayName("The test checks whether the method returns 'true' when any of the board's diagonals contains 3 signs of currentplayer")
    void testIsWinnerDiagonal() {
        //given
        Board board = new Board();
        Board board1 = new Board();
        Board board2 = new Board();

        board.updateBoard(new int[]{0, 0}, 'X');
        board.updateBoard(new int[]{1, 1}, 'X');
        board.updateBoard(new int[]{2, 2}, 'X');

        board1.updateBoard(new int[]{0, 2}, 'X');
        board1.updateBoard(new int[]{1, 1}, 'X');
        board1.updateBoard(new int[]{2, 0}, 'X');

        board2.updateBoard(new int[]{2, 0}, 'X');
        board2.updateBoard(new int[]{1, 1}, 'X');
        board2.updateBoard(new int[]{2, 2}, 'X');
        board2.updateBoard(new int[]{0, 1}, 'X');

        //when & then
        assertTrue(gameService.isWinner(board.getBoard()));
        assertTrue(gameService.isWinner(board1.getBoard()));
        assertFalse(gameService.isWinner(board2.getBoard()));
    }
}
