package com.kodilla.players;

import com.kodilla.Board;

public class Human extends Player {

    public Human(char sign) {
        super(sign);
    }

    public int[] move(Board board) {
        return new int[]{1,1};
    }
}