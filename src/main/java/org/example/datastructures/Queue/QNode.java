package org.example.datastructures.Queue;

public class QNode {
    int data;

    QNode next;
    
    public QNode(int data) {
        this.next = null;
        this.data = data;
    }

    public int getData() {
        return data;
    }


    public QNode getNext() {
        return next;
    }

    public void setNext(QNode next) {
        this.next = next;
    }
}
