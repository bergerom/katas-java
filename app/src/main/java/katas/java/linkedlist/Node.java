package katas.java.linkedlist;

public class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void appendToTail(Node end) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node getLastElement() {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        return n;
    }


}
