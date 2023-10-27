package katas.java.linkedlist;

public class ListIntersectionTraversal implements ListIntersection {

    @Override
    public Node getIntersection(Node listOne, Node listTwo) {
        Node currentOne = listOne;
        Node currentTwo = listTwo;

        if (currentOne == null || currentTwo == null)
            return null;

        if (currentOne == currentTwo) {
            return currentOne;
        }

        while (currentOne.next != null) {
            currentOne = currentOne.next;
        }

        while (currentTwo != null) {
            if (currentTwo == currentOne) {
                return currentTwo;
            }
            currentTwo = currentTwo.next;
        }

        return null;
    }

}
