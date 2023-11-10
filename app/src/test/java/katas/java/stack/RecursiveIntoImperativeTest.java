package katas.java.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursiveIntoImperativeTest {
    @Test
    public void testFibonacciImperative() throws EmptystackException {
        RecursiveIntoImperative recursiveIntoImperative = new RecursiveIntoImperative();
        Assertions.assertEquals(55, recursiveIntoImperative.fibonacciStack(10));
        Assertions.assertEquals(13, recursiveIntoImperative.fibonacciStack(7));
    }
}
