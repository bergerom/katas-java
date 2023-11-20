package katas.java.linkedlist.intersection;

public class LinkedListBuilder {

    Node first;

    public LinkedListBuilder() {

    }

    public LinkedListBuilder addNode(int data) {
        if (first == null) {
            first = new Node(data);
        } else {
            first.appendToTail(data);
        }
        return this;
    }

    public LinkedListBuilder addNode(Node node) {
        if (first == null) {
            first = node;
        } else {
            first.appendToTail(node);
        }
        return this;
    }

    public Node getLinkedList() {
        return first;
    }

    public LinkedListBuilder clear() {
        this.first = null;
        return this;
    }
}
