import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/21/17.
 */
public class LicenseKeyFormatterTest {
    @Test
    public void testLicenseKeyFormatting() throws Exception {
        LicenseKeyFormatter formatter = new LicenseKeyFormatter();
        String res = formatter.licenseKeyFormatting("a-a-a-a", 1);
        assertEquals("A-A-A-A", res);
    }
}