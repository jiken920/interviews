import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/21/17.
 */
public class ZigzagIteratorTest {
    @Test
    public void next() throws Exception {
        List<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        List<Integer> v2 = new ArrayList<>();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);

        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    public void hasNext() throws Exception {

    }

}