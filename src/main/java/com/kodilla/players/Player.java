package com.kodilla.players;

import com.kodilla.Board;

public abstract class Player {

    private char sign;
    private int points = 0;

    public Player(char sign) {
        this.sign = sign;
    }

    public abstract int[] move(Board board);

    public void addPoint() {
        points++;
    }

    public char getSign() {
        return sign;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;

        return sign == player.sign;
    }

    @Override
    public int hashCode() {
        return sign;
    }
}