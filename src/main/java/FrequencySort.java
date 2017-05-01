import java.util.Arrays;

/**
 * Created by jiken920 on 3/23/17.
 */
public class FrequencySort {
    public String frequencySort(String s) {
        if(s.length() < 3)
            return s;
        int max = 0;
        int[] map = new int[256]; // ascii char array
        for(char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max,map[ch]);
        }
        String[] buckets = new String[max + 1]; // create max buckets
        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
            String str = buckets[map[i]];
            if(map[i] > 0) { // if this character has shown up at least once...
                if(str == null) {
                    buckets[map[i]] = String.valueOf((char)i);
                } else {
                    buckets[map[i]] = str + (char)i; // append the character to the others
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = max; i >= 0; i--) { // iterate backwards from the highest frequency buckets to the lowest
            if(buckets[i] != null)
                for(char ch : buckets[i].toCharArray())
                    for(int j = 0; j < i; j++)
                        sb.append(ch);
        }
        return sb.toString();
    }
}
