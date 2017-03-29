/**
 * Created by krudio on 3/29/17.
 */
public class SquareRoot {
    public static void findSquareRoot(int n) {
        System.out.println(findSquareRoot(n, 1));
    }

    private static int findSquareRoot(int n, int root) {
        if (root * root > n) {
            return root - 1;
        }

        return findSquareRoot(n, root + 1);
    }
}
