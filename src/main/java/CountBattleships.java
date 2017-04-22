/**
 * Created by krudio on 4/16/17.
 */
public class CountBattleships {
//    Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots
//    are represented with '.'s. You may assume the following rules:
//
//    * You receive a valid board, made of only battleships or empty slots.
//    * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape
//          1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
//    * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0) return 0;

        int count = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == '.') continue;

                // If there's an X above us, then we've already seen this battleship
                if(row > 0 && board[row - 1][col] == 'X') continue;

                // If there's an X to the left of us, then we've already seen this battleship
                if(col > 0 && board[row][col - 1] == 'X') continue;

                // Otherwise, we must be seeing this 'X' for the first time. Count this battleship.
                count++;
            }
        }

        return count;
    }
}
