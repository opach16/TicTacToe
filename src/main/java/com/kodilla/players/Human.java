package com.kodilla.players;

import com.kodilla.IOController;

public class Human extends Player {

    private final IOController ioController = new IOController();

    public Human(char sign) {
        super(sign);
    }

    public int[] move() {
        return ioController.getMoveFromUser();
    }
}