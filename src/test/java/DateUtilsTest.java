import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/16/17.
 */
public class DateUtilsTest {
    @Test
    public void convertMonthNameToNumber() throws Exception {
        DateUtils.convertMonthNameToNumber("Feb");
    }

    @Test
    public void monthYearToJDBCTimestamp() throws Exception {
        String output = DateUtils.monthYearToJDBCTimestamp("Feb", "2016");
        assertEquals("2016-02-01 00:00:00", output);
    }
}