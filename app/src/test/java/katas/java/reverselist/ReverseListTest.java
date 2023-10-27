package katas.java.reverselist;

import katas.java.reverselist.ReverseList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReverseListTest {

    @Test
    public void testReverseList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(ReverseList.reverseList(list));
    }
}
