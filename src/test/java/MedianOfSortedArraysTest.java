import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 4/17/17.
 */
public class MedianOfSortedArraysTest {
    @Test
    public void findMedianSortedArrays() throws Exception {
        MedianOfSortedArrays main = new MedianOfSortedArrays();
        int[] a1 = new int[] { 1, 2 };
        int[] a2 = new int[] { 3, 4 };

        //double median = main.findMedianSortedArrays(a1, a2);
        //assertEquals(2.5, median, 0.0);

        a1 = new int[] { 1, 3 };
        a2 = new int[] { 2 };

        double median = main.findMedianSortedArrays(a1, a2);
        assertEquals(2.0, median, 0.0);
    }

}