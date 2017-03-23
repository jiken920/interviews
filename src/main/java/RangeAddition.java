import java.util.Arrays;

/**
 * Created by krudio on 3/23/17.
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] output = new int[length];
        Arrays.fill(output, 0);

        for(int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int updateVal = update[2];

            for (int i = startIndex; i <= endIndex; i++) {
                output[i] += updateVal;
            }
        }

        return output;
    }
}
