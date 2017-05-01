import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiken920 on 4/20/17.
 *
 * Given a string, determine if a permutation of the string could form a palindrome.

     For example,
     "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.isEmpty()) return false;

        Set<Character> vals = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(vals.contains(c)) {
                vals.remove(c);
            } else {
                vals.add(c);
            }
        }

        return vals.size() == 0 || vals.size() == 1;
    }
}
