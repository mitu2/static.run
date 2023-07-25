package io.github.mitu2.static_run_springboot.util;

import org.springframework.util.Assert;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chenmoand
 * @date 2023/7/19 20:24
 */
public class KeyUtils {


    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final char[] SPECIAL_CHARS = new char[]{
            '\u0008', '\u202E', '\u202D', '\u2028', '\u2029'
    };

    public static String randomKey(int minLength, int maxLength) {
        Assert.state(minLength > 0, "minLength must be greater than 0");
        Assert.state(maxLength > 0, "minLength must be greater than 0");
        Assert.state(maxLength >= minLength, "maxLength must be greater than minLength");
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int length = random.nextInt(minLength, maxLength + 1);
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = RANDOM_STR.charAt(random.nextInt(RANDOM_STR.length() - 1));

        }
        return new String(chars);
    }


    public static String unicodeRandomKey(int minLength, int maxLength) {
        Assert.state(minLength > 0, "minLength must be greater than 0");
        Assert.state(maxLength > 0, "minLength must be greater than 0");
        Assert.state(maxLength >= minLength, "maxLength must be greater than minLength");
        return "";
    }
}
