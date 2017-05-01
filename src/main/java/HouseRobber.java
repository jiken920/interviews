/**
 * Created by jiken920 on 3/29/17.
 */
public class HouseRobber {
    //    You are a professional robber planning to rob houses along a street.
    // Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
    // that adjacent houses have security system connected and it will automatically contact the police if two adjacent
    // houses were broken into on the same night.
    //
    //    Given a list of non-negative integers representing the amount of money of each house, determine the maximum
    // amount of money you can rob tonight without alerting the police.
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) { return 0; }

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                evenSum += nums[i];
                evenSum = evenSum > oddSum ? evenSum : oddSum;
            } else {
                oddSum += nums[i];
                oddSum = oddSum > evenSum ? oddSum : evenSum;
            }
        }

        return Math.max(oddSum, evenSum);
    }
}
