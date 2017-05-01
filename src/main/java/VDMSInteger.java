/**
 * Created by jiken920 on 3/8/17.
 */
public class VDMSInteger {

    private static final String PERIOD_PATTERN = "\\.";

    private VDMSInteger() {}

    /**
     * parseInteger: parses an Integer from a given string input. If the given value cannot be parsed into an integer,
     * then a null value is returned.
     *
     * @param value a {@code String} containing the {@code int}
     *             representation to be parsed.
     * @return the integer value represented by the argument in decimal, or null if an invalid integer is provided.
     */
    public static Integer parseInteger(String value) {
        if(value == null || value.isEmpty()) {
            return null;
        }

        // Handle decimal points
        if(value.contains(".")) {
            String[] nums = value.split(PERIOD_PATTERN);
            value = nums[0];
        }

        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException e) {
            return null;
        }
    }
}
