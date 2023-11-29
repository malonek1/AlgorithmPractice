package org.example.datastructures.linkedlist;

public class Node {
    private int data;

    private Node next;

    public Node (int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }
}
