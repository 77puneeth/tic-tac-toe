import java.util.Scanner;

public class TicTacToe {

    private static char[][] grid = new char[3][3];

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        while (true) {
            printGrid();

            int row, col;

            // Input validation loop
            while (true) {
                System.out.print("Player " + currentPlayer + " enter row (0-2): ");
                row = scanner.nextInt();

                System.out.print("Player " + currentPlayer + " enter col (0-2): ");
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (grid[row][col] == ' ') {
                        break;
                    } else {
                        System.out.println("Cell already occupied! Try again.");
                    }
                } else {
                    System.out.println("Invalid input! Enter values between 0 and 2.");
                }
            }

            // Place move
            grid[row][col] = currentPlayer;

            // Check game status
            if (hasWinner()) {
                printGrid();
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                break;
            }

            if (isFull()) {
                printGrid();
                System.out.println("🤝 It's a tie!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }

    // Print grid
    private static void printGrid() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Check winner
    private static boolean hasWinner() {

        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) ||
                (grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])) {
                return true;
            }
        }

        // Diagonals
        return (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) ||
               (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]);
    }

    // Check if grid full
    private static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
