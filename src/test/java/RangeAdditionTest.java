import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/23/17.
 */
public class RangeAdditionTest {
    @Test
    public void getModifiedArray() throws Exception {
        RangeAddition adder = new RangeAddition();
        int[] result = adder.getModifiedArray(5, new int[][]{ {1,3,2}, {2,4,3}, {0,2,-2}});
        assertArrayEquals(new int[]{-2, 0, 3, 5, 3}, result);
    }

}