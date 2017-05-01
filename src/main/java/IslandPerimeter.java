/**
 * Created by jiken920 on 3/21/17.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int edges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    // Count the out-of-bounds spaces next to us
                    if(i + 1 >= grid.length) { edges++; }
                    if(i - 1 < 0) { edges++; }
                    if(j + 1 >= grid[i].length) { edges++; }
                    if(j - 1 < 0) { edges++; }

                    // Count the 0's in the 4 spaces next to us
                    if(i + 1 < grid.length && grid[i + 1][j] == 0) {
                        edges++;
                    }
                    if(i - 1 >= 0 && grid[i - 1][j] == 0) {
                        edges++;
                    }
                    if(j + 1 < grid[i].length && grid[i][j + 1] == 0) {
                        edges++;
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 0) {
                        edges++;
                    }
                }
            }
        }
        return edges;
    }
}
