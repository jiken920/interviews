/**
 * Created by krudio on 4/18/17.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;

        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '1') {
                    islands++;
                    searchNeighbors(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void searchNeighbors(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if(i != row && j != col) {
                    searchNeighbors(grid, i, j);
                }
            }
        }
    }
}
