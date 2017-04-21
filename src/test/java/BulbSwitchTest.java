import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 4/21/17.
 */
public class BulbSwitchTest {
    @Test
    public void bulbSwitch() throws Exception {
        BulbSwitch main = new BulbSwitch();
        int result = main.bulbSwitch(2);
        assertEquals(result, 1);
    }

}