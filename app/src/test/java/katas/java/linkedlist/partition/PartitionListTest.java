package katas.java.linkedlist.partition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartitionListTest {

    @Test
    public void partitionListCaseZero() {
        int x = 3;
        ListNode partitioned = PartitionList.partition(null, x);
        Assertions.assertEquals(null, partitioned);
    }


    @Test
    public void partitionListCaseOne() {
        ListNode input = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2))))));

        int x = 3;


        ListNode partitioned = PartitionList.partition(input, x);
        Assertions.assertEquals(1, partitioned.val);
        partitioned = partitioned.next;
        Assertions.assertEquals(2, partitioned.val);
        partitioned = partitioned.next;
        Assertions.assertEquals(2, partitioned.val);
        partitioned = partitioned.next;
        Assertions.assertEquals(4, partitioned.val);
        partitioned = partitioned.next;
        Assertions.assertEquals(3, partitioned.val);
        partitioned = partitioned.next;
        Assertions.assertEquals(5, partitioned.val);

    }
}
