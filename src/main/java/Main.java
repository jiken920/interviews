import java.util.*;

/**
 * Created by Kenji on 10/19/2016.
 */
public class Main {
    public static void main(String[] args) {
        pangrams();
    }

    private static int lo, maxLen;

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    static void pangrams() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String inputLower = input.toLowerCase();

        boolean[] letters = new boolean[26];

        for(char c : inputLower.toCharArray()) {
            if(Character.isLowerCase(c)) {
                int index = c - 'a';
                if (!letters[index]) {
                    letters[index] = true;
                }
            }
        }

        for(boolean b : letters) {
            if(!b) {
                System.out.println("not pangram");
                return;
            }
        }

        System.out.println("pangram");
    }

    static void repeatedString() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();

        long len = (long)s.length();
        long numAs = 0;

        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == 'a') {
                numAs++;
            }

            if(i == n) {
                System.out.println(numAs);
                return;
            }
        }

        long numWordsBeforeN = n / len;
        numAs = numWordsBeforeN * numAs;

        long remainder = n % len;
        if(remainder > 0) {
            for(int i = 0; i < remainder; i++) {
                if(s.charAt(i) == 'a') {
                    numAs++;
                }
            }
            System.out.println(numAs);
        } else {
            System.out.println(numAs);
        }
    }

    static void numLoaves() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }

        int numLoaves = 0;
        for(int i = 0; i < N - 1; i++) {
            if(B[i] % 2 > 0) {
                numLoaves += 2;
                B[i]++;
                B[i + 1]++;
            }
        }

        for(int i = 0; i < N; i++) {
            if(B[i] % 2 > 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(numLoaves);
    }

    public static void almostSorted() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        boolean sorted = true;
        int startIndex = -1, endIndex = -1;
        for(int i = 0; i < n - 1; i++) {
            if(a[i] > a[i+1]) {
                sorted = false;
                if(startIndex == -1) {
                    startIndex = i;
                } else {
                    endIndex = i + 1;
                }
            }

            if(startIndex > -1 && endIndex == -1 && i == n - 2) { // we've reached the end but haven't found the end index yet.
                endIndex = i + 1;
            }
        }

        if(sorted) {
            System.out.println("yes");
            return;
        } else { // Try swapping first
            int[] b = a.clone();
            if(startIndex > -1 && endIndex > -1) {
                swap(b, startIndex, endIndex);
            }

            if(isSorted(b)) {
                System.out.println("yes");
                System.out.println("swap " + ++startIndex + " " + ++endIndex);
                return;
            } else { // Try reversing next
                for(int i = startIndex, j = endIndex; i < j; i++, j--) {
                    swap(a, i, j);
                }

                if(isSorted(a)) {
                    System.out.println("yes");
                    System.out.println("reverse " + ++startIndex + " " + ++endIndex);
                    return;
                } else {
                    System.out.println("no");
                    return;
                }
            }
        }
    }

    public static void swap(int[] a, int startIndex, int endIndex) {
        int tmp = a[startIndex];
        a[startIndex] = a[endIndex];
        a[endIndex] = tmp;
    }

    public static void larrysArray() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }

            // find three numbers that meet our sorting criteria...
            int start = 0;
            for(int k = 0; k < n - 2; k++) {
                if(a[k] < a[k + 1] && a[k] > a[k + 2]) {
                    // found
                    start = k;
                    rotateThree(a, k);
                } else if(a[k + 2] < a[k] && a[k + 2] > a[k + 1]) {
                    start = k;
                    rotateThree(a, k);
                }
            }

            if(isSorted(a)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isSorted(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            if(a[i] > a[i+1]) {
                return false;
            }
        }

        return true;
    }

    private static void rotateThree(int[] a, int k) {
        int tmp = a[k];
        a[k] = a[k + 1];
        a[k + 1] = a[k + 2];
        a[k + 2] = tmp;

        if(a[k] < a[k + 1] && a[k + 1] < a[k + 2]) {
            return;
        } else {
            rotateThree(a, k);
        }
    }

    public static int lengthLongestPath(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int maxCount = 0, curCount = 0;
        String[] words = input.split("\n");

        for(String word : words) {
            // Count the \t's to see which level we're on
            int level = word.length() - word.replace("\t", "").length();

            while(stack.size() > level) {
                int val = stack.pop();
                curCount -= val;
            }

            String cur = word.replace("\t", "");

            if(cur.contains(".")) {
                maxCount = Math.max(curCount + cur.length(), maxCount);
            } else {
                int tokenSizeWithSlash = cur.length() + 1;
                curCount += tokenSizeWithSlash; // handle slashes
                stack.push(tokenSizeWithSlash);
            }
        }

        return maxCount;
    }

    public class Logger {
        private Map<String, Integer> messages;

        /** Initialize your data structure here. */
        public Logger() {
            this.messages = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(messages.containsKey(message) && timestamp - messages.get(message) < 10) {
                return false;
            } else {
                messages.put(message, timestamp);
                return true;
            }
        }
    }
}
