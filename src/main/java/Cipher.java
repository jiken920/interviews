import java.util.Scanner;

/**
 * Created by jiken920 on 3/29/17.
 */
public class Cipher {
    public static void cipher() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();

        char[] input = s.toCharArray();
        for(int i = 0; i < n; i++) {
            if(input[i] >= 'a' && input[i] <= 'z') {
                // Get a zero-based index
                int baseIndex = (int)input[i] - 'a';
                int newIndex = baseIndex + k;
                if (newIndex > 'z' - 'a') {
                    baseIndex = newIndex % 26;
                    newIndex = 'a' + baseIndex;
                    // Replace the current letter with the rotated letter
                    input[i] = (char)(newIndex);
                } else {
                    // Make sure to add 'a' back to the index to get into the right range
                    input[i] = (char)(newIndex + 'a');
                }

            } else if(input[i] >= 'A' && input[i] <= 'Z') {
                int baseIndex = (int)input[i] - 'A';
                int newIndex = baseIndex + k;
                if (newIndex > 'Z' - 'A') {
                    baseIndex = newIndex % 26;
                    newIndex = 'A' + baseIndex;
                    // Replace the current letter with the rotated letter
                    input[i] = (char)(newIndex);
                } else {
                    // Make sure to add 'a' back to the index to get into the right range
                    input[i] = (char)(newIndex + 'A');
                }
            }
        }

        System.out.println(input);
    }
}
