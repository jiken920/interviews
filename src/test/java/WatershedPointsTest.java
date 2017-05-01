import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 4/21/17.
 */
public class WatershedPointsTest {
    @Test
    public void findWatershedPoints() throws Exception {
        int[][] grid = new int[][] {
                { 0, 1, 1, 2 },
                { 3, 0, 8, 4 },
                { 2, 7, 5, 3 }
        };

        WatershedPoints main = new WatershedPoints();
        main.findWatershedPoints(grid);
    }

}