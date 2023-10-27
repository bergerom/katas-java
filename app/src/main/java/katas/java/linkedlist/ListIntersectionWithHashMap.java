package katas.java.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class ListIntersectionWithHashMap implements ListIntersection{

    private Set<Node> firstListNodes = new HashSet<>();

    public Node getIntersection(Node listOne, Node listTwo) {
        if (listOne == listTwo) {
            return listOne;
        }

        Node current = listOne;
        while (current != null) {
            firstListNodes.add(current);
            current = current.next;
        }

        current = listTwo;
        while (current != null) {
            if (firstListNodes.contains(current))
                return current;
            current = current.next;
        }

        return null;
    }
}
