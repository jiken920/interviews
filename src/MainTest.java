import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kenji.rudio on 2/1/16.
 */
public class MainTest {

    @org.junit.Test
    public void testClosestNumbers() throws Exception {
        Main test = new Main();
        test.closestNumbers(10, "-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854");

    }

    @Test
    public void testInorderTraversal() {
        Main test = new Main();
        Main.TreeNode root = new Main.TreeNode(1);
        root.right = new Main.TreeNode(2);
        root.right.left = new Main.TreeNode(3);
        test.inorderTraversal(root);
    }

    @Test
    public void testFindSquareRoot() {
        Main test = new Main();
        test.findSquareRoot(4);

    }


    @Test
    public void testLex() throws Exception {

    }

    @Test
    public void testMergeArrays() throws Exception {
        int[] a = {1, 2, 3, 5, 6};
        int[] b = {4, 7, 8, 9, 10};

        Main test = new Main();
        test.mergeArrays(a, b);
    }

    @Test
    public void testReverseLinkedList() throws Exception {
        Main.ListNode a = new Main.ListNode();
        a.data = 1;
        Main.ListNode b = new Main.ListNode();
        b.data = 2;
        Main.ListNode c = new Main.ListNode();
        c.data = 3;

        a.next = b;
        b.next = c;

        Main test = new Main();
        Main.ListNode result = test.reverseLinkedList(a);
    }

    @Test
    public void testDistributeCandy() throws Exception {
        int[] scores = { 10, 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 };

        Main test = new Main();
        int result = test.distributeCandy(scores);
    }

    @Test
    public void testMaxDifference() throws Exception {
        Main test = new Main();
        int[] input = {
                6,
                7,
                9,
                5,
                6,
                3,
                2

        };
        int result = test.maxDifference(input);
    }

    @Test
    public void testMaxDifferenceSorted() throws Exception {
        Main test = new Main();
        int[] input = {
                6,
                7,
                9,
                5,
                6,
                3,
                2


        };
        test.maxDifferenceSorted2(input);
    }
}