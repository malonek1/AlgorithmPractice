package org.example.datastructures.doublelinkedlist;

public class Node {
    private int data;

    private Node next;
    private Node prev;

    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
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

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
