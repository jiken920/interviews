/**
 * Created by krudio on 3/27/17.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String input = s.trim();
        String[] words = input.split("\\s+");

        StringBuilder out = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            out.append(words[i]);
            if(i != 0) {
                out.append(" ");
            }
        }

        return out.toString();
    }
}
