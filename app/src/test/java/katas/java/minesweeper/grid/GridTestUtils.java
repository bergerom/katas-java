package katas.java.minesweeper.grid;

import org.junit.jupiter.api.Assertions;

import java.util.List;

public class GridTestUtils {
    public static <T> void listEquals(List<T> expectedValues, List<T> actualValues) {
        Assertions.assertEquals(expectedValues.size(), actualValues.size());
        for (Object expected : expectedValues) {
            Assertions.assertTrue(actualValues.stream().anyMatch(actual -> actual.equals(expected)));
        }
    }
}
