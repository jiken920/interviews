/**
 * Created by jiken920 on 4/18/17.
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

        searchNeighbors(grid, row + 1, col);
        searchNeighbors(grid, row - 1, col);
        searchNeighbors(grid, row , col + 1);
        searchNeighbors(grid, row , col - 1);
    }
}
