import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jiken920 on 3/16/17.
 */
public class DateUtils {
    private static final SimpleDateFormat MONTH_INPUT_FORMAT = new SimpleDateFormat("MMMM");
    private static final SimpleDateFormat MONTH_OUTPUT_FORMAT = new SimpleDateFormat("MM");
    private static final String MONTH_YEAR_TIMESTAMP_FORMAT = "%1s-%2s-01 00:00:00";

    public static String monthYearToJDBCTimestamp(String monthName, String year) {
        String month = convertMonthNameToNumber(monthName);
        return String.format(MONTH_YEAR_TIMESTAMP_FORMAT, year, month);
    }

    public static String convertMonthNameToNumber(String monthName) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(MONTH_INPUT_FORMAT.parse(monthName));
            return MONTH_OUTPUT_FORMAT.format(cal.getTime());
        } catch(ParseException ex) {
            System.out.println("Can't parse month name: " + monthName);
            return null;
        }
    }
}
