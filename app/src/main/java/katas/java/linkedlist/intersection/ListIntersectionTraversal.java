package katas.java.linkedlist.intersection;

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

        // 1 - Compute length of the two list and check if they have an intersection
        int listOneLength = 0;
        while (currentOne.next != null) {
            currentOne = currentOne.next;
            listOneLength++;
        }

        int listTwoLength = 0;
        while (currentTwo.next != null) {
            currentTwo = currentTwo.next;
            listTwoLength++;
        }

        if (currentOne != currentTwo) {
            return null;
        }

        // 2 - chop items
        int numbersItemsToIgnore = Math.max(listOneLength, listTwoLength)
                - Math.min(listOneLength, listTwoLength);
        if (listOneLength > listTwoLength) {
            currentOne = listOne;
            for (int i = 0; i < numbersItemsToIgnore; i++) {
                currentOne = currentOne.next;
            }
        } else {
            currentOne = listTwo;
            for (int i = 0; i < numbersItemsToIgnore; i++) {
                currentOne = currentOne.next;
            }
        }
        currentTwo = listOne;

        // 3 - traverse two list at the same time
        while (currentTwo != currentOne) {
            currentOne = currentOne.next;
            currentTwo = currentTwo.next;
        }

        return currentOne;

    }

}
