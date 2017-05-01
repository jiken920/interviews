import java.util.Arrays;

/**
 * Created by jiken920 on 4/21/17.
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
 * Find how many bulbs are on after n rounds.
 *
 * Example:
 *
 * Given n = 3.
 *
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 */
public class BulbSwitch {
    public int bulbSwitch(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        boolean[] bulbs = new boolean[n];
        Arrays.fill(bulbs, true);

        for (int i = 2; i <= n; i++) {
            int j = i - 1;

            while(j < n) {
                bulbs[j] = !bulbs[j];
                j += i;
            }
        }

        int count = 0;
        for(boolean b : bulbs) {
            if(b) count++;
        }

        return count;
    }
}
