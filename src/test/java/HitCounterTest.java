import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/23/17.
 */
public class HitCounterTest {
    @Test
    public void getHits() throws Exception {
        HitCounter counter = new HitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        assertEquals(3, counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        assertEquals(4, counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        assertEquals(3, counter.getHits(301));
    }

}