/**
 * Created by jiken920 on 3/22/17.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(i % 2 != 1) { // Handle even indexes (and zero)
                if(nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else { // Assume odd indexes
                if(nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int source, int target) {
        int tmp = nums[source];
        nums[source] = nums[target];
        nums[target] = tmp;
    }
}
