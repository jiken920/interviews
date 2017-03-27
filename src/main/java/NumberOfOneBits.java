/**
 * Created by krudio on 3/27/17.
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                ++count;
            }
            n = n >>> 1;
        }

        return count;
    }
}
