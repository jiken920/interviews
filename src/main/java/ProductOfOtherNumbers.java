/**
 * Created by krudio on 4/10/17.
 */
public class ProductOfOtherNumbers {
  /*
   * Transforms a list of numbers where the output list is:
   *   a) of equivalent length, where each of those numbers
   *   b) is the product of all the numbers in the input, EXCEPT
   *   c) the number at the corresponding index, AND
   *   d) division is not used
   *
   * For example, given this input:
   *   [1,2,3,4,5]
   * Generates this output:
   *   [120,60,40,30,24]
   *
   */
    static int[] productOfOtherNumbers(int[] input) {
        int[] output = new int[input.length];

        for(int i = 0; i < input.length; i++) {

            int curResult = 1;
            for(int j = 0; j < input.length; j++) {
                if(i == j) {
                    continue;
                }
                curResult *= input[j];
            }
            output[i] = curResult;
        }

        return output;
    }

    static int[] productOfOtherNumbersV2(int[] input) {
        int[] output = new int[input.length];

        int leftProduct = 1;
        for(int i = 0; i < input.length; i++) {
            output[i] = leftProduct;
            leftProduct *= input[i];
        }

        int rightProduct = 1;
        for(int i = input.length - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= input[i];
        }

        return output;
    }
}
