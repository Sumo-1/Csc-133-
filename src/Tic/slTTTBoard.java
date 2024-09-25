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