package com.kodilla;

import com.kodilla.players.Computer;
import com.kodilla.players.Human;
import com.kodilla.players.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int maxPoints;
    private boolean singlePlayer;
    private GameService gameService;
    private IOController ioController;

    public void gameInit() {
        while (true) {
            ioController = new IOController();
            singlePlayer = ioController.singlePlayer();
            player1 = new Human(ioController.getUserSign());
            player2 = singlePlayer ? new Computer(player1.getSign() == 'X' ? 'O' : 'X') : new Human(player1.getSign() == 'X' ? 'O' : 'X');
            currentPlayer = player2;
            maxPoints = ioController.getMaxPoints();
            gameService = new GameService(player1, player2, currentPlayer, ioController);
            while (maxPoints > player1.getPoints() && maxPoints > player2.getPoints()) {
                gameService.play();
                ioController.printResult(player1, player2);
            }
            ioController.summaryInfo(player1, player2);
            ioController.playAgain();
        }
    }
}