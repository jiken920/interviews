import java.util.Arrays;

/**
 * Created by krudio on 3/29/17.
 */
public class ProductExceptSelf {
    //    Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the
    //    product of all the elements of nums except nums[i].
    //
    //    Solve it without division and in O(n).
    //
    //    For example, given [1,2,3,4], return [24,12,8,6].
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 0);
        int total = 0;
        int numZeros = 0;

        for(int n : nums) {
            if(n == 0) {
                ++numZeros;
            } else {
                if(total == 0) {
                    total = n;
                } else {
                    total *= n;
                }
            }
        }

        if(numZeros >= 2) {
            return output;
        }

        for (int i = 0; i < nums.length; i++) {
            if(numZeros == 1 && nums[i] == 0) {
                output[i] = total;
            } else if(numZeros == 1 && nums[i] != 0) {
                output[i] = 0;
            } else {
                output[i] = nums[i] != 0 ? total / nums[i] : total;
            }
        }

        return output;
    }
}
