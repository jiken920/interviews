import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.Scanner;

/**
 * Created by krudio on 5/15/17.
 */
public final class GameOfLife {
    private boolean[][] board;
    private final int ROWS;
    private final int COLS;

    public GameOfLife(int rows, int cols, Pattern pattern) {
        ROWS = rows;
        COLS = cols;
        board = new boolean[rows][cols];

        try {
            pattern.init(board);
            printBoard(board);
        } catch (InvalidArgumentException e) {
            System.out.println("There was an error initializing the Game of Life. " +
                    "Please check your board size and try again.");
            e.printStackTrace();
        }
    }

    private void nextGeneration() {
        boolean[][] nextBoard = cloneBoard();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int neighbors = getLiveNeighborCount(board, i, j);
                if(board[i][j] && (neighbors < 2 || neighbors > 3)) {
                    nextBoard[i][j] = false;
                } else if(board[i][j] && neighbors == 2 || board[i][j] && neighbors == 3) {
                    nextBoard[i][j] = true;
                } else if(!board[i][j] && neighbors == 3) {
                    nextBoard[i][j] = true;
                }
            }
        }

        this.board = nextBoard;
        printBoard(this.board);
    }

    private boolean[][] cloneBoard() {
        boolean[][] newBoard = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        return newBoard;
    }

    private int getLiveNeighborCount(boolean[][] board, int row, int col) {
        int top = row - 1;
        int bottom = row + 1;
        int left = col - 1;
        int right = col + 1;

        int neighborCount = 0;

        // Check top-left cell
        if(top > 0 && left > 0 && board[top][left]) {
            neighborCount++;
        }

        // Check top cell
        if(top > 0 && board[top][col]) {
            neighborCount++;
        }

        // Check top-right cell
        if(top > 0 && right < COLS - 1 && board[top][right]) {
            neighborCount++;
        }

        // Check right cell
        if(right < COLS - 1 && board[row][right]) {
            neighborCount++;
        }

        // Check bottom-right cell
        if(bottom < ROWS - 1 && right < COLS - 1 && board[bottom][right]) {
            neighborCount++;
        }

        // Check bottom cell
        if(bottom < ROWS - 1 && board[bottom][col]) {
            neighborCount++;
        }

        // Check bottom-left cell
        if(bottom < ROWS - 1 && left > 0 && board[bottom][left]) {
            neighborCount++;
        }

        // Check left cell
        if(left > 0 && board[row][left]) {
            neighborCount++;
        }

        return neighborCount;
    }

    private void printBoard(boolean[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                // Print the ends of the columns
                if(j == 0 || j == COLS - 1) {
                    System.out.print("*");
                }
                // Print the header and footer
                else if(i == 0 || i == ROWS - 1) {
                    System.out.print("*");
                } else {
                    if(board[i][j]) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    }
                }

            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Game of Life.\n" +
                "Please enter the height and width of the game board you'd like to create:");
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());

        GameOfLife game = new GameOfLife(height, width, new GliderPattern());

        while(true) {
            System.out.println("Press \"ENTER\" to move to the next generation...");
            scanner.nextLine();
            game.nextGeneration();
        }
    }

}


