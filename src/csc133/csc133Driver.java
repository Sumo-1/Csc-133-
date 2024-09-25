package csc133;

import mechanicsBE.slTTTBoard;

import java.util.Scanner;

public class csc133Driver {
    private final slTTTBoard my_board = new slTTTBoard();

    // Local constants to handle game status
    private static final int GAME_INCOMPLETE = 0;
    private static final int GAME_QUIT = -1;

    public static void main(String[] args) {
        (new csc133Driver()).startGame();
    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);
        int game_status = GAME_INCOMPLETE;

        // Ask player to choose their marker at the beginning
        my_board.choosePlayerMarker();

        while (GAME_QUIT != game_status) {


            // Reset the board for a new game
            my_board.resetBoard();
            my_board.printBoard();

            // Ask the user if they want to start the game
            System.out.println("Do you want to start the game? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                game_status = my_board.play(); // Play the game if they choose yes
            } else {
                game_status = GAME_QUIT; // Quit the game if they say no
            }
        }
    }
}
