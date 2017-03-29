/**
 * Created by krudio on 3/29/17.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        int diff = x ^ y;

        while(diff > 0) {
            if((diff & 1) == 1) {
                distance++;
            }

            diff = diff >>> 1;
        }

        return distance;
    }
}
