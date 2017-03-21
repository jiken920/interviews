/**
 * Created by krudio on 3/21/17.
 */
public class LicenseKeyFormatter {
    public static String licenseKeyFormatting(String S, int K) {
        String in = S.replace("-", "").toUpperCase();
        if(K >= in.length()) {
            return in;
        }
        int firstGroupSize = in.length() % K;

        StringBuilder sb = new StringBuilder(in);

        if(firstGroupSize > 0) {
            sb.insert(firstGroupSize, '-');
        }

        int counter = firstGroupSize == 0 ? K : firstGroupSize + K + 1;
        while(counter < sb.length()) {
            sb.insert(counter, '-');
            counter += K + 1;
        }

        return sb.toString();
    }
}
