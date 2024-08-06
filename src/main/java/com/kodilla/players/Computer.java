package com.kodilla.players;

import com.kodilla.Board;

import java.util.Random;

public class Computer extends Player {

    private final static Random RANDOM = new Random();

    public Computer(char sign) {
        super(sign);
    }

    public int[] move(final Board board) {
        return new int[]{RANDOM.nextInt(3), RANDOM.nextInt(3)};
    }
}