/**
 * Created by jiken920 on 4/4/17.
 */
public class CountUniqueDigits {
    //    Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
    //
    //    Example:
    //    Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) { return 1; }

        int res = 10; // If n >= 1, we will always start with 10 unique numbers

        // For n > 1, we will only have 9 unique numbers to choose from, since the digit to the left has already been
        // taken
        int uniqueDigits = 9;

        // As we move from left to right, our number of available choices decreases. The largest number with unique
        // digits will be 9876543210
        int availableNumber = 9;

        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
