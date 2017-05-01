/**
 * Created by jiken920 on 4/20/17.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            counts[charIdx]++;
        }

        for (int j = 0; j < t.length(); j++) {
            int charIdx = t.charAt(j) - 'a';
            counts[charIdx]--;
        }

        for(int count : counts) {
            if(count != 0) return false;
        }

        return true;
    }
}
