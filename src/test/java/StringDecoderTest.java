import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/21/17.
 */
public class StringDecoderTest {
    @Test
    public void decodeString() throws Exception {
        StringDecoder decoder = new StringDecoder();
        String result = decoder.decodeString("3[a2[c]]");
        assertEquals("accaccacc", result);
    }

}