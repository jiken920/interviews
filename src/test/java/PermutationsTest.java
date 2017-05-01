import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 4/21/17.
 */
public class PermutationsTest {
    @Test
    public void permute() throws Exception {
        Permutations main = new Permutations();
        List<List<Integer>> results = main.permute(new int[]{1, 2, 3});
    }

}