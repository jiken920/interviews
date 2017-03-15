import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/8/17.
 */
public class VDMSIntegerTest {
    @Test
    public void parseInteger() throws Exception {
        Integer result = VDMSInteger.parseInteger("123");
        assertEquals(123, result.intValue());

        result = VDMSInteger.parseInteger("123.45");
        assertEquals(123, result.intValue());

        result = VDMSInteger.parseInteger("-123.45");
        assertEquals(-123, result.intValue());

        result = VDMSInteger.parseInteger("abc");
        assertEquals(null, result);
    }
}