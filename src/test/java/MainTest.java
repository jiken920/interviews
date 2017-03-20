import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kenji on 11/15/2016.
 */
public class MainTest {
    @org.junit.Test
    public void longestPalindrome() throws Exception {
        String result = Main.longestPalindrome("babad");
        System.out.println(result);
    }

    @Test
    public void testLongestPath() throws Exception {
        int result = Main.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        assertEquals(32, result);
    }

    @Test
    public void testLicenseKeyFormatting() throws Exception {
        String res = Main.licenseKeyFormatting("a-a-a-a", 1);
        assertEquals("A-A-A-A", res);
    }
}