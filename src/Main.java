import java.util.*;

public class Main {

    public static void main(String[] args) {
        cipher();

    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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

    public static void anagrams() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 0;
        String[] inputs = new String[n];
        while(i < n) {
            inputs[i] = sc.nextLine();
        }

        for(String s : inputs) {
            if(s.length() % 2 != 0) {
                System.out.println("-1");
                continue;
            }

            int[] letters = new int[26];
            char[] chars = s.toCharArray();
            int firstHalf = s.length() / 2;
            int k = 0;

            // Iterate through the first half of the string and count the occurrence of each letter.
            while(k < firstHalf) {
                char c = chars[k];
                letters[(int)c]++;
                k++;
            }

            // Iterate through the second half of the string and decrement the count for every letter
            // we've already seen.
            while(k < s.length()) {
                char c = chars[k];
                letters[(int)c]--;
                k++;
            }

            // Loop through the letters array and see what the counts are. This should tell us how many
            // changes are required to get the strings to match
            int changes = 0;
            for(int count : letters) {
                changes += count;
            }

            System.out.println(changes);
        }
    }

    static ListNode reverseLinkedList(ListNode node) {
        if(node == null) {
            return null;
        }
        if(node.next == null) {
            return node;
        }

        // Store a pointer to the next node
        ListNode nextNode = node.next;

        // Unlink the next node
        node.next = null;

        //cur.next = node;
        ListNode reverse = reverseLinkedList(nextNode);
        nextNode.next = node;

        return reverse;
    }


    static void shares() {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        int i = 0;
        while(i < t) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            int j = 0;
            while(j < n) {
                arr[j] = sc.nextInt();
                j++;
            }

            int maxProfit = 0;
            int numShares = 0;

            for(int k = 0; k < n - 1; k++) {
                if(arr[k] < arr[k+1]) {
                    maxProfit += arr[k]; // buy
                    numShares++;
                }

                if(arr[k] > arr[k+1]) {
                    maxProfit = arr[k]*numShares - maxProfit; // sell
                    numShares = 0;
                }

                if(k == n - 2) { // If we're on the last iteration, figure out if we should sell
                    if(arr[k] < arr[k+1]) {
                        maxProfit += arr[k+1]*numShares - maxProfit; // sell
                        numShares = 0;
                    }
                }
            }

            System.out.println(maxProfit);

            ++i;
        }
    }

    static void funnyString() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int i = 0;
        while(i < n) {
            char[] s = sc.nextLine().toCharArray();

            int sSum = 0;
            int rSum = 0;
            for(int j = s.length - 2, k = 1; j > 0; j--, k++) {
                sSum = Math.abs(s[k] - s[k-1]);
                rSum = Math.abs(s[j] - s[j+1]);
                if(sSum != rSum) {
                    System.out.println("Not Funny");
                    break;
                }
            }

            if(sSum == rSum) {
                System.out.println("Funny");
            }

            i++;
        }
    }

    static void lexographicWords() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        for(String word : words) {
            if(word.length() == 1) {
                System.out.println("no answer");
                continue;
            }

            char[] chars = word.toCharArray();
            int len = chars.length;

            // Find the first decreasing suffix
            int i = len - 1;
            while(i > 0 && chars[i - 1] >= chars[i]) {
                i--;
            }

            if(i <= 0) {
                System.out.println("no answer");
                continue;
            }

            // Set i - 1 to be the pivot
            int pivot = i - 1;

            // Find the rightmost element that is bigger than the pivot
            int j = len - 1;
            while(j > pivot && chars[j] <= chars[pivot]) {
                j--;
            }

            // Swap the pivot with the rightmost element in the suffix that is larger than it
            char temp = chars[pivot];
            chars[pivot] = chars[j];
            chars[j] = temp;

            // Reverse the suffix after swapping
            j = len - 1;
            while(i < j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }

            System.out.println(chars);
        }
    }

    static String firstRepeatedWord(String s) {
        String[] parsedInput = s.split(" ");
        Set<String> values = new HashSet<String>(parsedInput.length);
        for(String word : parsedInput) {
            if(!values.add(word)) {
                return word;
            }
        }
        return "";
    }

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

    static int[] mergeArrays(int[] a, int[] b) {
        int mergedLength = a.length + b.length;
        int[] mergedArray = new int[mergedLength];
        int mergeIndex = 0, i = 0, j = 0;

        while(i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mergedArray[mergeIndex] = a[i];
                i++;
            }
            else {
                mergedArray[mergeIndex] = b[j];
                j++;
            }
            mergeIndex++;
        }

        while(i < a.length) {
            mergedArray[mergeIndex] = a[i];
            mergeIndex++;
            i++;
        }
        while(j < b.length) {
            mergedArray[mergeIndex] = b[i];
            mergeIndex++;
            j++;
        }

        return mergedArray;
    }

    private static int isPresent(Node root, int val){
        if(root == null) {
            return 0;
        }
        if(root.data == val) {
            return 1;
        }

        if(val < root.data) {
            return isPresent(root.left, val);
        }
        else {
            return isPresent(root.right, val);
        }
    }

    public static class ListNode {
        int data;
        ListNode next;

        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }

    public static class Node {
        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    public static boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.data >= min && root.data <= max &&
                isBST(root.left, min, root.data) && isBST(root.right, root.data, max)) {
            return true;
        } else {
            return false;
        }
    }

    private static int height(Node root) {
        if(root == null) { return -1; }

        int lefth = height(root.left);
        int righth = height(root.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    private static Node insert(Node node, int data) {
        if (node==null) {
            node = new Node(data);
        }
        else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            }
            else {
                node.right = insert(node.right, data);
            }
        }
        return(node);
    }

    static void pairs() throws Exception {
        Scanner sc = new Scanner(System.in);
        int numberOfInts = sc.nextInt();
        int difference = sc.nextInt();
        int[] values = new int[numberOfInts];

        for(int i = 0; i < numberOfInts; i++) {
            values[i] = sc.nextInt();
        }

        int numPairs = 0;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i+1; j < values.length; j++) {
                if(Math.abs(values[i] - values[j]) == difference) {
                    numPairs++;
                }
            }
        }

        System.out.println(numPairs);
        sc.close();
    }

    static String closestNumbers(int len, String s) {
        int[] input = new int[len];
        String[] numbers = s.split(" ");
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(numbers[i]);
            input[i] = num;
        }

        Arrays.sort(input);

        int a = 0, b = 0;
        int minDiff = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 1; j < input.length; i++, j++) {
            int curDiff = Math.abs(input[i] - input[j]);
            if(curDiff == minDiff) {
                sb.append(input[i] + " " + input[j] + "\n");
            }
            else if(curDiff < minDiff) {
                a = input[i];
                b = input[j];
                minDiff = curDiff;
            }
        }

        sb.append(a + " " + b);
        return sb.toString();
    }

    static int distributeCandy(int[] score) {
        int numberOfStudents = score[0];
        int candies = numberOfStudents;

        if(numberOfStudents == 2) {
            if(score[1] != score[2]) {
                return ++candies;
            }
        }

        for (int i = 1; i < numberOfStudents; i++) {
            // Special case to handle the first score in the list.
            if(i == 1) {
                if(score[i] > score[i + 1]) {
                    candies++;
                }
                continue;
            }
            // Special case to handle the last score in the list.
            if(i == numberOfStudents) {
                if(score[i] > score[i - 1]) {
                    candies++;
                }
                break;
            }
            // Otherwise, compare each score against its neighbors.
            if(score[i] > score[i - 1]) {
                candies++;
            }
            if(score[i] > score[i + 1]) {
                candies++;
            }
        }

        return candies;
    }

    static int maxDifference(int[] a) {
        int maxDiff = -1;
//        if(a.length == 3) {
//            maxDiff = Math.max(a[2] - a[1], maxDiff);
//        }
        for (int i = a.length - 1; i > 1; i--) {
            for (int j = i - 1; j > 0; j--) {
                maxDiff = Math.max(a[i] - a[j], maxDiff);
            }
        }

        return maxDiff;
    }

    static int maxDifferenceSorted(int[] a) {
        int maxDiff = -1;

        Map<Integer, Integer> counts = new HashMap<>(a.length - 1);
        for (int i = 1; i < a.length; i++) {
            if(counts.containsKey(a[i])) {
                int curValue = counts.get(a[i]);
                if(i > curValue) {
                    counts.put(a[i], i);
                }
            }
            else {
                counts.put(a[i], i);
            }
        }

        Arrays.sort(a, 1, a.length);
        int i = 1;
        int j = a.length - 1;
        while(i != j) {
            if(counts.get(a[j]) > counts.get(a[i])) {
                maxDiff = Math.max(a[j] - a[i], maxDiff);
            }
            i++;
            j--;
        }

        return maxDiff;
    }

    static int maxDifferenceSorted2(int[] a) {
        int maxDiff = -1;

        int i = 1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIdx = Integer.MIN_VALUE, minIdx = Integer.MAX_VALUE;
        while(i < a.length) {
            int cur = a[i];
            if(cur > max) {
                maxIdx = i;
                max = cur;
            }

            if(cur < min) {
                minIdx = i;
                min = cur;
            }

            if(maxIdx > minIdx) {
                maxDiff = Math.max(max - min, maxDiff);
            }
            ++i;
        }

        return maxDiff;
    }

    static void castleOnTheGrid() {
        Scanner sc = new Scanner(System.in);
        int gridSize = sc.nextInt();
        char[][] board = new char[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();

        int minSteps = 0;


        sc.close();
    }

    static String nonRepeated(String s) {
        HashMap<Character,Integer>  characterhashtable=
                new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= s.length();  // Scan string and build hash table
        for (i=0;i < length;i++)
        {
            c=s.charAt(i);
            if(characterhashtable.containsKey(c))
            {
                // increment count corresponding to c
                characterhashtable.put(  c ,  characterhashtable.get(c) +1 );
            }
            else
            {
                characterhashtable.put( c , 1 ) ;
            }
        }
        // Search characterhashtable in in order of string str

        for (i =0 ; i < length ; i++ )
        {
            c= s.charAt(i);
            if( characterhashtable.get(c)  == 1 )
                return c.toString();
        }
        return null ;
    }
}
