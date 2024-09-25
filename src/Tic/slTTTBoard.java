package mechanicsBE;

import java.util.Scanner;

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

        computerMarker = (playerMarker == 'X') ? 'O' : 'X';
        currentPlayerMarker = computerMarker;
    }

    public int play() {
        Scanner scanner = new Scanner(System.in);
        while (!isBoardFull() && !checkForWin()) {
            if (currentPlayerMarker == playerMarker) {
                playerTurn(scanner);
            } else {
                computerTurn();
            }
            printBoard();

            if (checkForWin()) {
                if (currentPlayerMarker == computerMarker) {
                    System.out.println("Computer wins!");
                } else {
                    System.out.println("Player wins! (This should never happen)");
                }
                break;
            }

            switchPlayer();
        }

        if (!checkForWin() && isBoardFull()) {
            System.out.println("It's a draw!");
        }
        return 0;
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

    private void computerTurn() {
        int[] bestMove = minimax(0, true);
        board[bestMove[0]][bestMove[1]] = computerMarker;
        System.out.println("Computer places at: " + (bestMove[0] + 1) + ", " + (bestMove[1] + 1));
    }

    private int[] minimax(int depth, boolean isMaximizing) {
        // Base cases for win/loss/draw
        if (checkForWin()) {
            if (currentPlayerMarker == computerMarker) {
                return new int[]{-1, -1, 10 - depth}; // Computer wins
            } else {
                return new int[]{-1, -1, depth - 10}; // Player wins
            }
        }

        if (isBoardFull()) {
            return new int[]{-1, -1, 0}; // Draw
        }

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int[] bestMove = {-1, -1, bestScore};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = isMaximizing ? computerMarker : playerMarker;
                    int[] score = minimax(depth + 1, !isMaximizing);
                    board[i][j] = '-'; // Undo move

                    if (isMaximizing) {
                        if (score[2] > bestScore) {
                            bestScore = score[2];
                            bestMove = new int[]{i, j, bestScore};
                        }
                    } else {
                        if (score[2] < bestScore) {
                            bestScore = score[2];
                            bestMove = new int[]{i, j, bestScore};
                        }
                    }
                }
            }
        }

        return bestMove;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayerMarker = (currentPlayerMarker == playerMarker) ? computerMarker : playerMarker;
    }

    private boolean checkForWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayerMarker && board[i][1] == currentPlayerMarker && board[i][2] == currentPlayerMarker) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayerMarker && board[1][i] == currentPlayerMarker && board[2][i] == currentPlayerMarker) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] == currentPlayerMarker && board[1][1] == currentPlayerMarker && board[2][2] == currentPlayerMarker) ||
                (board[0][2] == currentPlayerMarker && board[1][1] == currentPlayerMarker && board[2][0] == currentPlayerMarker);
    }
}
