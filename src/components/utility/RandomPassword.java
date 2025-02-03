package components.utility;

import java.util.Random;

public class RandomPassword {
    private static final String UPP = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String LOW = "qwertyuiopasdfghjklzxcvbnm";
    private static final String DIG = "1234567890";
    private static final String SPE = "!@#$%^&*()-_=+<>?/";
    private static final String ALL = UPP + LOW + DIG + SPE;
    private static final Random random = new Random();

    public static String generatePass() {
        final int length = 20;
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(ALL.length());
            password.append(ALL.charAt(rand));
        }
        return password.toString();
    }
}
