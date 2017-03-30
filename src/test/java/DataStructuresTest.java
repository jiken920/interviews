import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by krudio on 3/30/17.
 */
public class DataStructuresTest {
    @Test
    public void testMapEquality() throws Exception {
        Map<String, Integer> votes1 = new HashMap<>();
        Map<String, Integer> votes2 = new HashMap<>();

        votes1.put("Test", 27);
        votes1.put("Foo", 2);
        votes1.put("Bar", 32);

        votes2.put("Test", 27);
        votes2.put("Foo", 2);
        votes2.put("Bar", 32);

        assertEquals(votes1, votes2);
    }
}
