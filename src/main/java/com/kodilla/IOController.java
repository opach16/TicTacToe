package com.kodilla;

import com.kodilla.players.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IOController {

    private final static Scanner SCANNER = new Scanner(System.in);

    public void printResult(Player player1, Player player2) {
        System.out.println(player1.getSign() + ": " + player1.getPoints());
        System.out.println(player2.getSign() + ": " + player2.getPoints());
    }

    public void summaryInfo(Player player1, Player player2) {
        System.out.println("*********************");
        if (player1.getPoints() > player2.getPoints()) {
            System.out.println(player1.getSign() + " - winner - " + player1.getPoints() + " points");
        } else if (player2.getPoints() > player1.getPoints()) {
            System.out.println(player2.getSign() + " - winner - " + player2.getPoints() + " points");
        } else {
            System.out.println("DRAW!");
        }
        System.out.println("*********************");
    }

    public void saveStatistics(Player player1, Player player2, int maxPoints) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\Users\\User\\OneDrive\\dev\\ttc\\src\\main\\resources\\log.txt", true));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(LocalDateTime.now());
        printWriter.println(date);
        printWriter.printf("Number of rounds: %d\n", maxPoints);
        printWriter.printf("%s: %d points\n", player1.getSign(), player1.getPoints());
        printWriter.printf("%s: %d points\n", player2.getSign(), player2.getPoints());
        printWriter.println();
        printWriter.close();
    }

    public int getMaxPoints() {
        int result;
        while (true) {
            try {
                System.out.print("Enter a number of rounds you want to play (1-10): ");
                result = SCANNER.nextInt();
                if (result > 0 && result <= 10) {
                    break;
                } else {
                    System.out.println("Invalid input!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a numerical value!");
                SCANNER.next();
            }
        }
        return result;
    }

    public void displayBoard(Board board) {
        System.out.println("_______");
        Arrays.stream(board.getBoard())
                .forEach(n -> System.out.println("|" + n[0] + "|" + n[1] + "|" + n[2] + "|"));

    }

    public int[] getMoveFromUser() {
        int x;
        int y;
        while (true) {
            try {
                System.out.print("Enter X: ");
                x = SCANNER.nextInt();
                System.out.print("Enter Y: ");
                y = SCANNER.nextInt();
                if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a numerical value!");
                SCANNER.next();
            }
        }
        return new int[]{x, y};
    }

    public char getUserSign() {
        char result;
        while (true) {
            System.out.print("Enter your symbol (X or O): ");
            result = SCANNER.nextLine().toUpperCase().charAt(0);
            if (result == 'X' || result == 'O') {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        return result;
    }

    public boolean singlePlayer() {
        char result;
        while (true) {
            System.out.print("Enter \'1\' to single player or \'2\' to two players game: ");
            result = SCANNER.nextLine().toUpperCase().charAt(0);
            if (result == '1') {
                return true;
            } else if (result == '2') {
                return false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void draw() {
        System.out.println("DRAW!");
    }

    public void playAgain() {
        do {
            System.out.println("Press \'n\' to play again or \'x\' to exit the game");
            String playAgain = SCANNER.nextLine().toLowerCase();
            if (playAgain.equals("x")) {
                System.exit(0);
            } else if (playAgain.equals("n")) {
                break;
            }
        } while (true);
    }
}