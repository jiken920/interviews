import java.util.ArrayList;
import java.util.List;

/**
 * Created by krudio on 3/23/17.
 */
public class GeneratePossibleNextMoves {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.isEmpty() || s.length() < 2) {
            return results;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder result = new StringBuilder(s);
                result.setCharAt(i, '-');
                result.setCharAt(i + 1, '-');
                results.add(result.toString());
            }
        }

        return results;
    }
}
