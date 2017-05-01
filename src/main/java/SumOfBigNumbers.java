import java.util.List;

/**
 * Created by jiken920 on 4/28/17.
 */
public class SumOfBigNumbers {
    private int carry = 0;

    public final String sumOfBigNumbers(List<String> input) {
        StringBuilder sb = new StringBuilder();
        String curSum = null;

        for (String number : input) {
            if (curSum == null) {
                curSum = number;
                continue;
            }

            int i = number.length() - 1;
            int j = curSum.length() - 1;
            while (i >= 0 && j >= 0) {
                int digitSum = addDigits(number.charAt(i), curSum.charAt(j));
                sb.insert(0, digitSum);
                i--; j--;
            }

            while (i >= 0) {
                int digitSum = addDigits(number.charAt(i), '0');
                sb.insert(0, digitSum);
                i--;
            }

            while (j >= 0) {
                int digitSum = addDigits('0', number.charAt(j));
                sb.insert(0, digitSum);
                j--;
            }

            if (carry == 1) {
                sb.insert(0, carry);
                carry = 0;
            }

            curSum = sb.toString();
        }

        return sb.toString();

    }

    private int addDigits(char x, char y) {
        int digitA = Integer.parseInt(String.valueOf(x));
        int digitB = Integer.parseInt(String.valueOf(y));

        int digitSum = digitA + digitB + carry;
        if (digitSum >= 10) {
            carry = 1;
            digitSum = digitSum % 10;
        } else {
            carry = 0;
        }

        return digitSum;
    }
}
