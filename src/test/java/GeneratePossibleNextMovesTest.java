import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/23/17.
 */
public class GeneratePossibleNextMovesTest {
    @Test
    public void testGenerateNextPossibleMoves() throws Exception {
        GeneratePossibleNextMoves main = new GeneratePossibleNextMoves();
        List<String> results = main.generatePossibleNextMoves("++++");
        List<String> expected = new ArrayList<>();
        expected.add("--++");
        expected.add("+--+");
        expected.add("++--");

        assertEquals(expected, results);
    }
}