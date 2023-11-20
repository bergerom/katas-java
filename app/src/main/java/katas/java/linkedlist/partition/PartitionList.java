package katas.java.linkedlist.partition;

import java.util.List;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null) {
            return null;
        }

        ListNode cur = head;
        ListNode greater = null;
        ListNode lower = null;
        ListNode next = null;

        ListNode firstLower = null;
        ListNode firstGreater = null;

        while (cur != null) {
            next = cur.next;
            if (cur.val >= x) {
                if (firstGreater == null) {
                    firstGreater = cur;
                }
                appendToList(greater, cur);
                greater = cur;
            } else if (cur.val < x) {
                if (firstLower == null) {
                    firstLower = cur;
                }
                appendToList(lower, cur);
                lower = cur;
            }
            cur = next;
        }
        if (lower != null) {
            lower.next = firstGreater;
            return firstLower;
        } else {
            return firstGreater;
        }

    }

    public static void appendToList(ListNode list, ListNode nodeToAppend) {
        nodeToAppend.next = null;

        if (list == null) {
            list = nodeToAppend;
        } else {
            list.next = nodeToAppend;
        }
    }
}
