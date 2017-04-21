import java.util.HashSet;
import java.util.Set;

/**
 * Created by krudio on 4/21/17.
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] set = new boolean[nums.length + 1];

        for (int i = 0; i < set.length; i++) {
            set[i] = true;
        }

        for(int n : nums) {
            if(set[n]) {
                set[n] = false;
            }
        }

        for (int i = 0; i < set.length; i++) {
            if(set[i]) return i;
        }

        return -1;
    }
}
