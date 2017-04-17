/**
 * Created by krudio on 4/16/17.
 */
public class ReverseWordsIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        String[] words = s.split(" ");
        for(String word : words) {
            char[] letters = word.toCharArray();
            for(int i = 0, j = letters.length - 1; i < j; i++, j--) {
                char tmp = letters[i];
                letters[i] = letters[j];
                letters[j] = tmp;
            }

            sb.append(letters);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
