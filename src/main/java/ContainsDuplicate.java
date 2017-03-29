import java.util.HashSet;
import java.util.Set;

/**
 * Created by krudio on 3/29/17.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            if(!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
