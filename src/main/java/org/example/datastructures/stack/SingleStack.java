package org.example.datastructures.stack;

public class SingleStack {
    private StackNode top;

    public void push(int data) {
        StackNode current = new StackNode(data);
        if(top != null) {
            current.setBelow(top);
            top = current;
        }
        else {
            top = current;
        }
    }

    public void pop() {
        if(top != null) {
            top = top.getBelow();
        }
    }

    public int findMin() {
        StackNode temp = top;
        int min = temp.getData();
        while(temp.getBelow() != null) {
            min = Math.min(min, temp.getBelow().getData());
            temp = temp.getBelow();
        }
        return min;
    }

    public StackNode peek() {
        return top;
    }

    public void printAll(SingleStack stack) {
        StackNode temp = stack.top;
        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getBelow();
        }
    }
}
