/**
 * Created by jiken920 on 4/18/17.
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            n--;

            // Prepend the computed character
            result.insert(0, ((char)('A' + n % 26)));
            n /= 26;
        }

        return result.toString();

    }
}
