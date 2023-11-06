package katas.java.minesweeper.grid;

import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.stream.Collectors;

public class GridTestUtils {
    public static <T> void collectionsEquals(Collection<T> expectedValues, Collection<T> actualValues) {
        Assertions.assertEquals(expectedValues.size(), actualValues.size());
        for (Object expected : expectedValues) {
            boolean anyMatch = actualValues.stream().anyMatch(actual -> actual.equals(expected));
            if (!anyMatch) {
                String errMsg = String.format("List are not equal. \n Expected: %s\n  Actual: %s\n",
                        expectedValues.stream().map(o -> o != null ? o + " - " + o.hashCode() : "null").collect(Collectors.toList()),
                        actualValues.stream().map(o -> o != null ? o + " - " + o.hashCode() : "null").collect(Collectors.toList()));
                Assertions.fail(errMsg);
            }
        }
    }
}
