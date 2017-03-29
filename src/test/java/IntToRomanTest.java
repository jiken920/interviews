import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/29/17.
 */
public class IntToRomanTest {
    @Test
    public void intToRoman() throws Exception {
        IntToRoman intToRoman = new IntToRoman();
        String result = intToRoman.intToRoman(20);
        assertEquals("XX", result);
    }

}