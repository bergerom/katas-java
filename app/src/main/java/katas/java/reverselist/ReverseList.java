package katas.java.reverselist;

import java.util.List;

public class ReverseList {
    public static List<Integer> reverseList(List<Integer> list) {
        return reverseList(list, 0);
    }

    private static List<Integer> reverseList(List<Integer> list, int index) {
        System.out.println(index);
        int lastElemIndex = list.size() - 1;
        if (index == lastElemIndex / 2)
            return list;

        Integer rightElement = list.get(lastElemIndex - index);
        Integer leftElement = list.get(index);
        list.set(index, rightElement);
        list.set(lastElemIndex - index, leftElement);

        return reverseList(list, index + 1);
    }
}
