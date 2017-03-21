import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/21/17.
 */
public class MovingAverageTest {
    @Test
    public void next() throws Exception {
        MovingAverage avg = new MovingAverage(3);
        avg.next(3);
        avg.next(1);
        avg.next(10);
        double res = avg.next(4);

        assertEquals(5, res, 0.000001);
    }
}