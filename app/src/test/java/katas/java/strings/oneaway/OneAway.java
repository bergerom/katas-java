package katas.java.strings.oneaway;

import java.util.Arrays;

public class OneAway {
    public static boolean compute(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }


        int lengthS1 = s1.length();
        int lengthS2 = s2.length();
        if (Math.abs(lengthS1 - lengthS2) >= 2) {
            return false;
        }


        if (lengthS1 == 0 && lengthS2 == 1 || lengthS1 == 1 && lengthS2 == 0) {
            return true;
        }

        String longerString = lengthS1 > lengthS2 ? s1 : s2;
        String shorterString = lengthS1 > lengthS2 ? s1 : s2;

        // replace
        if (lengthS1 == lengthS2) {
            for (int i = 0; i < lengthS1; i++) {
                Character s1Char = s1.charAt(i);
                Character s2Char = s1.charAt(i);
                if (s1Char != s2Char) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
