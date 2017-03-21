/**
 * Created by krudio on 3/21/17.
 */
public class NumberToWords {
    private final String[] uniques = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private final String[] tens = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }

        String result = translate(num);
        return result.trim();
    }

    private String translate(int num) {
        if(num < 20) {
            return uniques[num] + " ";
        }
        if(num < 100) {
            int prefix = num / 10;
            int remainder = num % 10;
            return tens[prefix] + " " + translate(remainder);
        }
        if(num < 1000) {
            int prefix = num / 100;
            int remainder = num % 100;
            return uniques[prefix] + "Hundred " + translate(remainder);
        }
        if(num < 1000000) {
            int prefix = num / 1000;
            int remainder = num % 1000;
            return translate(prefix) + "Thousand " + translate(remainder);
        }
        if(num < 1000000000) {
            int prefix = num / 1000000;
            int remainder = num % 1000000;
            return translate(prefix) + "Million " + translate(remainder);
        }
        if(num < Integer.MAX_VALUE) {
            int prefix = num / 1000000000;
            int remainder = num % 1000000000;
            return translate(prefix) + "Billion " + translate(remainder);
        }
        return "";
    }
}
