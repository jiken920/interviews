/**
 * Created by jiken920 on 4/17/17.
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:

     A -> 1
     AA -> 27
     BA -> 53
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'A';

            // Each time through the loop, take the previous result and multiply it by 26. Then, add our current char
            // index to the result. Need to add 1 because Excel uses a 1-based counting system.
            result = result * 26 + (charIndex + 1);
        }
        return result;
    }
}
