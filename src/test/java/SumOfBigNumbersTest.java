import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 4/28/17.
 */
public class SumOfBigNumbersTest {
    @Test
    public void sumOfBigNumbers() throws Exception {
        SumOfBigNumbers main = new SumOfBigNumbers();
        List<String> input = new ArrayList<>();
        input.add("99");
        input.add("201");
        String result = main.sumOfBigNumbers(input);

        assertEquals(result, "300");
    }

}