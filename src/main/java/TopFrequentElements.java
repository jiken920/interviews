import java.util.*;

/**
 * Created by krudio on 4/21/17.
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int num : nums) {
            if(!numbers.containsKey(num)) {
                numbers.put(num, 1);
            } else {
                numbers.put(num, numbers.get(num) + 1);
            }
        }

        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            buckets.add(null);
        }

        for(int key : numbers.keySet()) {
            int count = numbers.get(key);
            List<Integer> cur = buckets.get(count);
            if(cur == null) {
                cur = new ArrayList<>();
            }
            cur.add(key);
            buckets.set(count, cur);
        }

        List<Integer> results = new ArrayList<>(k);
        int j = 1;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            if (buckets.get(i) != null) {
                for (int val : buckets.get(i)) {
                    results.add(val);
                    if (j == k) {
                        return results;
                    } else {
                        j++;
                    }
                }
            }
        }

        return results;
    }
}
