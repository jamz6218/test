import java.util.Scanner;

public class ChessBoard {
    private static final int BOARD_SIZE = 8;
    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    private int currentRow;
    private int currentCol;

    // Constructor to initialize the chessboard and place the piece at the specified starting position
    public ChessBoard(int startRow, int startCol) {
        initializeBoard();
        placePiece(startRow, startCol);
    }

    // Initialize the chessboard with empty squares
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Place the chess piece at the specified position on the board
    private void placePiece(int startRow, int startCol) {
        currentRow = validatePosition(startRow, BOARD_SIZE);
        currentCol = validatePosition(startCol, BOARD_SIZE);
        board[currentRow][currentCol] = 'P';
    }

    // Ensure the position is within the bounds of the board
    private int validatePosition(int position, int boardSize) {
        return Math.max(0, Math.min(position, boardSize - 1));
    }

    // Print the current state of the chessboard
    private void printBoard() {
        System.out.println("Current Board:");
        System.out.print("  ");
        for (int i = 1; i <= BOARD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((char) ('a' + i) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Move the chess piece to the new position, handling board boundaries
    private void movePiece(int newRow, int newCol) {
        newRow = validatePosition(newRow, BOARD_SIZE);
        newCol = validatePosition(newCol, BOARD_SIZE);

        board[currentRow][currentCol] = '-';
        currentRow = newRow;
        currentCol = newCol;
        board[currentRow][currentCol] = 'P';
    }

    // Main method to run the chessboard program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the starting position from the user
        System.out.println("Enter starting position (e.g., a1 to 8h): ");
        String startPosInput = scanner.next().toLowerCase();

        int startRow = startPosInput.charAt(1) - '1';
        int startCol = startPosInput.charAt(0) - 'a';

        // Create a ChessBoard instance with the user-defined starting position
        ChessBoard chessBoard = new ChessBoard(startRow, startCol);

        int newRow;
        int newCol;

        do {
            // Display the current state of the chessboard
            chessBoard.printBoard();
            // Get the new position from the user
            System.out.println("Enter new position (e.g., b3 or 8h, Q to quit): ");
            String moveInput = scanner.next().toLowerCase();

            // Check if the user wants to quit
            if (moveInput.equals("q")) {
                break;
            }

            try {
                // Extract row and column values from the user input
                newRow = moveInput.charAt(1) - '1';
                newCol = moveInput.charAt(0) - 'a';

                // Move the chess piece to the new position
                chessBoard.movePiece(newRow, newCol);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please enter a valid position.");
            }

        } while (true);

        System.out.println("Game Over");
        scanner.close();
    }
}
