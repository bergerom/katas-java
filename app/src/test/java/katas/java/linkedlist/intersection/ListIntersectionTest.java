package katas.java.linkedlist.intersection;

import katas.java.linkedlist.intersection.LinkedListBuilder;
import katas.java.linkedlist.intersection.ListIntersectionTraversal;
import katas.java.linkedlist.intersection.ListIntersectionWithHashMap;
import katas.java.linkedlist.intersection.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListIntersectionTest {
    @Test
    public void testListIntersectionOneNode() {
        ListIntersectionWithHashMap listIntersectionWithHashMap = new ListIntersectionWithHashMap();
        ListIntersectionTraversal ListIntersectionTraversal = new ListIntersectionTraversal();

        Node listOne = new Node(5);
        Node listTwo = listOne;
        Assertions.assertEquals(listOne, listIntersectionWithHashMap.getIntersection(listOne, listTwo));
        Assertions.assertEquals(listOne, ListIntersectionTraversal.getIntersection(listOne, listTwo));
    }

    @Test
    public void testListIntersectionNoIntersection() {
        ListIntersectionWithHashMap listIntersectionWithHashMap = new ListIntersectionWithHashMap();
        ListIntersectionTraversal ListIntersectionTraversal = new ListIntersectionTraversal();

        Node listOne = new Node(5);
        Node listTwo = new Node(6);

        Assertions.assertNull(listIntersectionWithHashMap.getIntersection(listOne, listTwo));
        Assertions.assertNull(ListIntersectionTraversal.getIntersection(listOne, listTwo));
    }

    @Test
    public void testListIntersectionMiddleNode() {
        ListIntersectionWithHashMap listIntersectionWithHashMap = new ListIntersectionWithHashMap();
        ListIntersectionTraversal ListIntersectionTraversal = new ListIntersectionTraversal();

        Node sharedNode = new Node(6);

        LinkedListBuilder builder = new LinkedListBuilder();
        builder.addNode(5);
        builder.addNode(sharedNode);
        builder.addNode(7);
        Node listOne = builder.getLinkedList();

        builder.clear();
        builder.addNode(2);
        builder.addNode(sharedNode);
        Node listTwo = builder.getLinkedList();

        Assertions.assertEquals(sharedNode, listIntersectionWithHashMap.getIntersection(listOne, listTwo));
        Assertions.assertEquals(sharedNode, ListIntersectionTraversal.getIntersection(listOne, listTwo));
    }

    @Test
    public void testListIntersectionLastNode() {


        Node sharedNode = new Node(6);

        LinkedListBuilder builder = new LinkedListBuilder();
        builder.addNode(5);
        builder.addNode(7);
        builder.addNode(sharedNode);
        Node listOne = builder.getLinkedList();

        builder.clear();
        builder.addNode(2);
        builder.addNode(9);
        builder.addNode(sharedNode);
        builder.addNode(1);
        builder.addNode(1);
        builder.addNode(1);
        Node listTwo = builder.getLinkedList();

        ListIntersectionWithHashMap listIntersectionWithHashMap = new ListIntersectionWithHashMap();
        ListIntersectionTraversal ListIntersectionTraversal = new ListIntersectionTraversal();
        Assertions.assertEquals(sharedNode, listIntersectionWithHashMap.getIntersection(listOne, listTwo));
        Assertions.assertEquals(sharedNode, ListIntersectionTraversal.getIntersection(listOne, listTwo));
    }

    @Test
    public void testListIntersectionFirstNode() {
        Node sharedNode = new Node(6);

        LinkedListBuilder builder = new LinkedListBuilder();
        builder.addNode(sharedNode);
        builder.addNode(5);
        builder.addNode(7);
        Node listOne = builder.getLinkedList();

        builder.clear();
        builder.addNode(sharedNode);
        builder.addNode(1);
        builder.addNode(1);
        builder.addNode(1);
        Node listTwo = builder.getLinkedList();

        ListIntersectionWithHashMap listIntersectionWithHashMap = new ListIntersectionWithHashMap();
        ListIntersectionTraversal ListIntersectionTraversal = new ListIntersectionTraversal();
        Assertions.assertEquals(sharedNode, listIntersectionWithHashMap.getIntersection(listOne, listTwo));
        Assertions.assertEquals(sharedNode, ListIntersectionTraversal.getIntersection(listOne, listTwo));
    }

    @Test
    public void testListIntersectionSecondListBigger() {
        Node sharedNode = new Node(6);

        LinkedListBuilder builder = new LinkedListBuilder();
        builder.addNode(1);
        builder.addNode(sharedNode);
        builder.addNode(2);

        Node listOne = builder.getLinkedList();

        builder.clear();
        builder.addNode(5);
        builder.addNode(9);
        builder.addNode(11);
        builder.addNode(7);
        builder.addNode(sharedNode);
        builder.addNode(1);
        builder.addNode(1);
        builder.addNode(1);
        builder.addNode(1);
        Node listTwo = builder.getLinkedList();

        ListIntersectionWithHashMap listIntersectionWithHashMap = new ListIntersectionWithHashMap();
        ListIntersectionTraversal ListIntersectionTraversal = new ListIntersectionTraversal();
        Assertions.assertEquals(sharedNode, listIntersectionWithHashMap.getIntersection(listOne, listTwo));
        Assertions.assertEquals(sharedNode, ListIntersectionTraversal.getIntersection(listOne, listTwo));
    }
}
