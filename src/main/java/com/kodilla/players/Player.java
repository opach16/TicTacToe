package com.kodilla.players;

public abstract class Player {

    private char sign;
    private int points = 0;

    public Player(char sign) {
        this.sign = sign;
    }

    public abstract int[] move();

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