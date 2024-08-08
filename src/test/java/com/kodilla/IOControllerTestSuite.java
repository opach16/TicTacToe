package com.kodilla;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class IOControllerTestSuite {

    @Test
    void testGetUserSignWithValidInputX() {
        //given
        String userInput = "X";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        char result = ioController.getUserSign();

        //then
        assertEquals('X', result);
    }

    @Test
    void testGetUserSignWithValidInputO() {
        //given
        String userInput = "O";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        char result = ioController.getUserSign();

        //then
        assertEquals('O', result);
    }

    @Test
    void testGetUserSignWithInValidInputs() {
        //given
        String userInput = "@\n1\nB\nX";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        char result = ioController.getUserSign();

        //then
        assertEquals('X', result);
    }

    @Test
    void testGetMaxPoints() {
        //given
        String userInput = "1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        int result = ioController.getMaxPoints();

        //then
        assertEquals(1, result);
    }

    @Test
    void testGetMaxPointsOutOfBound() {
        //given
        String userInput = "11\n20\n55\n10";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        int result = ioController.getMaxPoints();

        //then
        assertEquals(10, result);
    }

    @Test
    void testSinglePlayer() {
        //given
        String userInput = "1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        boolean result = ioController.singlePlayer();

        //then
        assertTrue(result);
    }

    @Test
    void testSinglePlayerForTwoPlayers() {
        //given
        String userInput = "2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        boolean result = ioController.singlePlayer();

        //then
        assertFalse(result);
    }

    @Test
    void testSinglePlayerInvalidInputs() {
        //given
        String userInput = "3\n0\n50\n@\nv\n1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        boolean result = ioController.singlePlayer();

        //then
        assertTrue(result);
    }

    @Test
    void testGetMoveFromUser() {
        //given
        String userInput = "1\n2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        int[] result = ioController.getMoveFromUser();

        //then
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testGetMoveFromUserInvalidInputs() {
        //given
        String userInput = "@\n^\n6\ng\n1\n1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        IOController ioController = new IOController();

        //when
        int[] result = ioController.getMoveFromUser();

        //then
        assertArrayEquals(new int[]{1, 1}, result);
    }
}