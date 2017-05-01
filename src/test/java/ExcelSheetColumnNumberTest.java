import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 4/17/17.
 */
public class ExcelSheetColumnNumberTest {
    @Test
    public void titleToNumber() throws Exception {
        ExcelSheetColumnNumber main = new ExcelSheetColumnNumber();
        int result = main.titleToNumber("A");
        assertEquals(1, result);
    }

}