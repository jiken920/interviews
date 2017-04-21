import java.util.ArrayList;
import java.util.List;

/**
 * Created by krudio on 4/21/17.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, results, new ArrayList<Integer>(), 0);
        return results;
    }

    public void permute(int[] nums, List<List<Integer>> results, List<Integer> temp, int index) {
        if(index == nums.length) {
            results.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;

            temp.add(nums[i]);
            permute(nums, results, temp, index + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
