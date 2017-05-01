import java.util.Arrays;

/**
 * Created by jiken920 on 3/29/17.
 */
public class ClimbStairs {
    //    You are climbing a stair case. It takes n steps to reach to the top.
    //
    //    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //
    //    Note: Given n will be a positive integer.
    public int climbStairs(int n) {
        int[] results = new int[n + 1];
        Arrays.fill(results, -1);
        return climbStairs(n, results);
    }

    private int climbStairs(int n, int[] results) {
        int ways = 0;
        if(n < 0) {
            return 0;
        }
        else if(n == 0) { // no more steps remaining. found a valid way to climb the steps!
            return 1;
        }

        if(results[n] != -1) {
            ways = results[n];
        } else {
            ways = climbStairs(n - 1) + climbStairs(n - 2);
            results[n] = ways;
        }
        return ways;
    }
}
