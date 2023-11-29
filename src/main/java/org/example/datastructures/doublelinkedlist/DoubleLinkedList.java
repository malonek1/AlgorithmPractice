package org.example.datastructures.doublelinkedlist;

public class DoubleLinkedList {

    private Node head;
    private Node tail;

    public void frontInsert(int data) {
        Node current = new Node(data);
        if(head == null) {
            head = current;
            tail = current;
        }
        else {
            current.setNext(head);
            head.setPrev(current);
            head = current;
        }
    }

    public void backInsert(int data) {
        Node current = new Node(data);
        if(tail == null) {
            head = current;
            tail = current;
        }
        else {
            tail.setNext(current);
            current.setPrev(tail);
            tail = current;
        }
    }

    public void deleteDuplicate(int dup) {
        Node temp = head;
        while(temp.getNext() != null) {
            if(dup == temp.getNext().getData()) {
                temp.setNext(temp.getNext().getNext());
            }
            temp = temp.getNext();
        }
    }

    public void printList(DoubleLinkedList current) {
        Node temp = current.head;
        if(temp == null) {
            System.out.println("The list is empty");
        }
        else {
            while(temp != null) {
                if(temp.getPrev() == null) {
                    System.out.print(" |-|" + temp.getData() + "|" + temp.getNext().getData() + "| -->");
                }
                else if(temp.getNext() == null) {
                    System.out.print(" |" + temp.getPrev().getData() + "|" + temp.getData() + "|-|");
                }
                else {
                    System.out.print(" |" + temp.getPrev().getData() + "|" + temp.getData() + "|" + temp.getNext().getData() + "| -->");
                }
                temp = temp.getNext();
            }
        }
    }
}
