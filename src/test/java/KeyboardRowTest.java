import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 4/16/17.
 */
public class KeyboardRowTest {
    @Test
    public void findWords() throws Exception {
        KeyboardRow main = new KeyboardRow();
        String[] result = main.findWords(new String[] {"Hello","Alaska","Dad","Peace"});
        String[] expected = new String[] {"Alaska","Dad"};

        assertArrayEquals(expected, result);
    }

}