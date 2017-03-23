/**
 * Created by krudio on 3/23/17.
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, cur = 0;
        for(int i : nums) {
            if(i == 1) {
                cur++;
                result = Math.max(result, cur);
            } else {
                cur = 0;
            }
        }
        return result;
    }
}
