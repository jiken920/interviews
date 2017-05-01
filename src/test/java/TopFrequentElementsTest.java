import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 4/21/17.
 */
public class TopFrequentElementsTest {
    @Test
    public void topKFrequent() throws Exception {
        TopFrequentElements main = new TopFrequentElements();
        //List<Integer> results = main.topKFrequent(new int[]{1,1,1,2,2,3}, 2);

        List<Integer> results = main.topKFrequent(new int[]{1,2}, 2);

    }

}