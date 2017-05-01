import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/23/17.
 */
public class FrequencySortTest {
    @Test
    public void frequencySort() throws Exception {
        FrequencySort sort = new FrequencySort();
        String result = sort.frequencySort("tree");
        assertEquals("eert", result);
    }

}