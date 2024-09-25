package mechanicsBE;

import java.util.Scanner;
import java.util.Random;

public class slTTTBoard {
    private final char[][] board = new char[3][3];
    private char playerMarker;
    private char computerMarker;
    private char currentPlayerMarker;

    public slTTTBoard() {
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Reset the board for a new game
    public void resetBoard() {
        initializeBoard();
    }

    public void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void choosePlayerMarker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your marker (X or O): ");
        playerMarker = scanner.next().toUpperCase().charAt(0);

        while (playerMarker != 'X' && playerMarker != 'O') {
            System.out.println("Invalid marker! Please choose X or O: ");
            playerMarker = scanner.next().toUpperCase().charAt(0);
        }

        computerMarker = (playerMarker == 'X') ? 'O' : 'X'; // Assign the other marker to the computer
        currentPlayerMarker = playerMarker; // Player starts first
    }

    // The main play loop
    public int play() {
        Scanner scanner = new Scanner(System.in);
        while (!isBoardFull() && !checkForWin()) {
            if (currentPlayerMarker == playerMarker) {
                playerTurn(scanner);
            } else {
                computerTurn(); // Computer always forces a draw or wins
            }
            printBoard();

            // Check for win after each move and stop the game if someone wins
            if (checkForWin()) {
                if (currentPlayerMarker == computerMarker) {
                    System.out.println("Computer wins!");
                } else {
                    System.out.println("Player wins! (This should never happen)");
                }
                break; // Stop the game when there's a win
            }

            switchPlayer();
        }

        if (!checkForWin() && isBoardFull()) {
            System.out.println("It's a draw!");
        }
        return 0; // Game finished
    }

    private void playerTurn(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player's turn. Enter row (1-3) and column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = playerMarker;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
