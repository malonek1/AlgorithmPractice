package org.example.datastructures.linkedlist;

public class LinkedList {

    private Node head;

    public void insert(LinkedList list, int data) {
        Node node = new Node(data);
        if(list.head == null) {
            list.head = node;
        }
        else {
            Node last = list.head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    public void printList() {
        if(head == null) {
            System.out.println("The list is empty");
        }
        else {
            while(head != null) {
                System.out.println(head.getData());
                head = head.getNext();
            }
        }
    }
}
