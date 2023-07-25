package io.github.mitu2.static_run_springboot.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author chenmoand
 * @date 2023/7/19 20:38
 */
class KeyUtilsTest {

    @Test
    public void testCase() {
        char[] specialChars = KeyUtils.SPECIAL_CHARS;
        System.out.println("S" + Arrays.toString(specialChars) + "E");

    }

}