/**
 * Created by jiken920 on 4/21/17.
 *
 * Write a function to find all of the points in a 2D array that are considered to be watershed points.
 * A watershed point is a point such that a drop of water that lands on it can flow either to the north/west oceans
 * OR to the south/east oceans.
 */
public class WatershedPoints {
    public void findWatershedPoints(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(northWest(grid, row, col) && southEast(grid, row, col)) {
                    System.out.println(grid[row][col] + " at (" + row + ", " + col + ") is a watershed point.");
                }
            }
        }
    }
    public boolean northWest(int[][] grid, int row, int col) {
        if(row == 0 || col == 0) return true;

        boolean north = false, west = false;
        int cur = grid[row][col];
        if(cur > grid[row - 1][col]) { // go up
            north =  northWest(grid, row - 1, col);
        }
        if(cur > grid[row][col - 1]) { //go left
            west = northWest(grid, row, col - 1);
        }

        return north || west;
    }

    public boolean southEast(int[][] grid, int row, int col) {
        if(row == grid.length - 1 || col == grid[0].length - 1) return true;

        boolean south = false, east = false;
        int cur = grid[row][col];
        if(cur > grid[row + 1][col]) { // go down
            south = southEast(grid, row + 1, col);
        }
        if(cur > grid[row][col + 1]) { //go right
            east = southEast(grid, row, col + 1);
        }

        return south || east;
    }
}
