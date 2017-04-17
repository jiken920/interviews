import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 4/17/17.
 */
public class LRUCacheTest {
    @Test
    public void testCache() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

}