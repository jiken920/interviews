/**
 * Created by jiken920 on 4/17/17.
 */
public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] allNums = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                allNums[k] = nums1[i];
                i++;
            } else {
                allNums[k] = nums2[j];
                j++;
            }

            k++;
        }

        while(i < nums1.length && k < allNums.length) {
            allNums[k] = nums1[i];
            k++;
            i++;
        }
        while(j < nums1.length && k < allNums.length) {
            allNums[k] = nums2[j];
            k++;
            j++;
        }

        double median = 0;
        if(allNums.length % 2 == 0) {
            median = (double)(allNums[allNums.length / 2] + allNums[(allNums.length / 2) - 1]) / 2;
        } else {
            median = allNums[allNums.length / 2];
        }

        return median;
    }
}
