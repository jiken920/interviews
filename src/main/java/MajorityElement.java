import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiken920 on 3/27/17.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums) {
            if(counts.containsKey(num)) {
                int count = counts.get(num);
                counts.put(num, count + 1);
            } else {
                counts.put(num, 1);
            }

            if(counts.get(num) > nums.length / 2) {
                majority = num;
                break;
            }
        }

        return majority;
    }
}
