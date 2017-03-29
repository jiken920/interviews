import java.util.HashMap;
import java.util.Map;

/**
 * Created by krudio on 3/29/17.
 */
public class FirstNonRepeatingCharacter {
    static String firstNonRepeatedCharacter(String s) {
        Map<Character, Integer> charMap = new HashMap<>(s.length());

        char[] inputChars = s.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if(charMap.containsKey(inputChars[i])) {
                int count = inputChars[i];
                charMap.put(inputChars[i], count++);
            }
            else {
                charMap.put(inputChars[i], 1);
            }
        }

        String result = null;
        for(Character c : charMap.keySet()) {
            if(charMap.get(c) == 1) {
                result = String.valueOf(c);
                break;
            }
        }

        return result;
    }

    static String firstNonRepeatedCharacterBruteForce(String s) {
        char[] inputChars = s.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            boolean isRepeated = false;
            for (int j = 0; j < inputChars.length; j++) {
                if(i == j) {
                    continue;
                }
                if(inputChars[i] == inputChars[j]) {
                    isRepeated = true;
                    break;
                }
            }

            if(!isRepeated) {
                return String.valueOf(inputChars[i]);
            }
        }

        return "";
    }
}
