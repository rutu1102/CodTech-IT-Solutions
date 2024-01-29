package codtech;

import java.util.Scanner;

public class Tictactoe {
    private static final int BOARD_SIZE = 3;
    private static final char HUMAN_PLAYER = 'X';
    private static final char COMPUTER_PLAYER = 'O';
    private static final char EMPTY_CELL = ' ';
    private static final Scanner scanner = new Scanner(System.in);

    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        initializeBoard();
        char currentPlayer = HUMAN_PLAYER;
        while (true) {
            printBoard();
            if (currentPlayer == HUMAN_PLAYER) {
                humanMove();
            } else {
                computerMove();
            }
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println(currentPlayer + " wins!");
                break;
            } else if (isDraw()) {
                printBoard();
                System.out.println("It's a tie!");
                break;
            }
            currentPlayer = currentPlayer == HUMAN_PLAYER ? COMPUTER_PLAYER : HUMAN_PLAYER;
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void humanMove() {
        while (true) {
            System.out.print("Enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY_CELL) {
                board[row][col] = HUMAN_PLAYER;
                return;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void computerMove() {
        System.out.println("Computer is thinking...");
        int row, col;
        do {
            row = (int) (Math.random() * BOARD_SIZE);
            col = (int) (Math.random() * BOARD_SIZE);
        } while (board[row][col] != EMPTY_CELL);
        board[row][col] = COMPUTER_PLAYER;
    }

    private static boolean checkWin(char player) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    private static boolean isDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}
