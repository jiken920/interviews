/**
 * Created by krudio on 3/29/17.
 */
public class MergeArrays {
    static int[] mergeArrays(int[] a, int[] b) {
        int mergedLength = a.length + b.length;
        int[] mergedArray = new int[mergedLength];
        int mergeIndex = 0, i = 0, j = 0;

        while(i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mergedArray[mergeIndex] = a[i];
                i++;
            }
            else {
                mergedArray[mergeIndex] = b[j];
                j++;
            }
            mergeIndex++;
        }

        while(i < a.length) {
            mergedArray[mergeIndex] = a[i];
            mergeIndex++;
            i++;
        }
        while(j < b.length) {
            mergedArray[mergeIndex] = b[i];
            mergeIndex++;
            j++;
        }

        return mergedArray;
    }
}
