package components.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FdateTime {
    private static final String regex = "^\\d{2}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";
    private static final Pattern pattern = Pattern.compile(regex);
    public static String getTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String formatedTime = dateTime.format(dateTimeFormatter);
        return formatedTime;
    }

    public static boolean validateTime(String line) {
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
