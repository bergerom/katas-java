package katas.java.strings.oneaway;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneAwayTest {

    @Test
    public void emptyStrings() {
        String s1 = "";
        String s2 = "";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void sameString() {
        String s1 = "toto";
        String s2 = "toto";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void lengthCannotDifferMoreThanOne() {
        String s1 = "ot";
        String s2 = "toto";
        Assertions.assertFalse(OneAway.compute(s1, s2));
    }

    @Test
    public void oneAwayEmptyStringOneChar() {
        String s1 = "";
        String s2 = "a";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void oneCharEmptyString() {
        String s1 = "a";
        String s2 = "";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void emptyStringTwoChars() {
        String s1 = "";
        String s2 = "aa";
        Assertions.assertFalse(OneAway.compute(s1, s2));
    }

    @Test
    public void twoCharsEmptyString() {
        String s1 = "aa";
        String s2 = "";
        Assertions.assertFalse(OneAway.compute(s1, s2));
    }


    @Test
    public void testOneAwayRemoveChar() {
        String s1 = "oto";
        String s2 = "toto";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void testOneAwayAddChar() {
        String s1 = "toto";
        String s2 = "oto";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void testOneAwayRemoveMiddle() {
        String s1 = "tototo";
        String s2 = "totto";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void testOneAwayReplaceMiddle() {
        String s1 = "tototo";
        String s2 = "totito";
        Assertions.assertTrue(OneAway.compute(s1, s2));
    }

    @Test
    public void testOneAwayReplaceTwoMiddle() {
        String s1 = "tototo";
        String s2 = "totiti";
        Assertions.assertFalse(OneAway.compute(s1, s2));
    }

}
