package page.object.user.cred;

import org.apache.commons.lang3.RandomStringUtils;
import java.security.SecureRandom;
import java.util.Random;

public class UserCred {

    public static String EMAIL = "email678+" + System.nanoTime() +"@gmail.com";
    public static int PHONE = getRandomInt();
    public static String FIRSTNAME = getRandomString(8);
    public static String LASTNAME = getRandomString(10);
    public static String PASSWORD = generateRandomCharSequence(7);
    public static String ADDRESS = generateRandomCharSequence(10);
    public static String CITY = getRandomString(10);
    public static int POST_CODE = getRandomPostCode();


    private static int getRandomInt() {
        return new Random().nextInt((883364534) - 88336453);
    }

    private static int getRandomPostCode() {
        return 10000 + new Random().nextInt(90000);
    }

    private static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomCharSequence(int len)
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

}


