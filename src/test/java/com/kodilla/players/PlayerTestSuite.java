package com.kodilla.players;

import com.kodilla.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTestSuite {

    @Test
    void testAddPoint() {
        //given
        Player player = new Human('X');
        Player player2 = new Computer('O');
        //when
        player.addPoint();
        player2.addPoint();
        player2.addPoint();
        player2.addPoint();
        //then
        assertEquals(1, player.getPoints());
        assertEquals(3, player2.getPoints());
    }

    @Test
    void testComputerMove() {
        //given
        Board board = new Board();
        Player player = new Computer('O');

        //when
        int[] result1 = player.move(board);
        int[] result2 = player.move(board);
        int[] result3 = player.move(board);

        //then
        assertTrue((result1[0] >= 0 && result1[0] <= 2) && (result1[1] >= 0 && result1[1] <= 2));
        assertTrue((result2[0] >= 0 && result2[0] <= 2) && (result2[1] >= 0 && result2[1] <= 2));
        assertTrue((result3[0] >= 0 && result3[0] <= 2) && (result3[1] >= 0 && result3[1] <= 2));
    }

    @Test
    void testHumanMove() {
        //given
        String userInput = "1\n2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        Board board = new Board();
        Player player = new Human('X');

        //when
        int[] result = player.move(board);

        //then
        assertArrayEquals(new int[]{1, 2}, result);
    }
}