package org.example.datastructures.Queue;

public class Queue {

    private QNode front;
    private QNode rear;

    public void enqueue(int data) {
        QNode current = new QNode(data);
        if(rear == null) {
            rear = current;
            front = current;
        }
        else {
            rear.setNext(current);
            rear = current;
        }
    }

    public void getValue() {
        System.out.println("Rear value: " + rear.getData());
        System.out.println("Front value: " + front.getData());
    }

    public void dequeue() {
        if(front != null) {
            front = front.getNext();
        }
    }

    public void printAll() {
        QNode temp = front;
        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
