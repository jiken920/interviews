import java.util.*;

/**
 * Created by krudio on 4/16/17.
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row of an
 * American keyboard
 *
 */
public class KeyboardRow {

    private static final String[] rows = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public String[] findWords(String[] words) {
        if(words == null || words.length == 0) return null;

        Map<Character, Integer> rowMappings = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            for(char c : row.toCharArray()) {
                rowMappings.put(c, i);
            }
        }

        List<String> result = new ArrayList<>();
        for(String word : words) {
            int rowIndex = rowMappings.get(word.toLowerCase().charAt(0)); // Store the index of the first character

            // Check this index against the index of every other character in the word. If there's a mismatch, then
            // we know we can't create the word using only a single keyboard row.
            for(char c : word.toLowerCase().toCharArray()) {
                if(rowIndex != rowMappings.get(c)) {
                    rowIndex = -1;
                    break;
                }
            }

            if(rowIndex != -1) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
