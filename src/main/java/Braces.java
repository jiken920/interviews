import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by krudio on 3/29/17.
 */
public class Braces {
    static String[] braces(String[] values) {
        List<String> result = new ArrayList<String>(values.length);
        for(String value : values) {
            Stack<Character> stack = new Stack<>();
            char[] cArray = value.toCharArray();
            for (int i = 0; i < cArray.length; i++) {
                if(!stack.empty()) {
                    if (cArray[i] == '}' && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                    if (cArray[i] == ')' && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    if (cArray[i] == ']' && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(cArray[i]);
            }
            if(stack.empty()) {
                result.add("YES");
            }
            else {
                result.add("NO");
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
