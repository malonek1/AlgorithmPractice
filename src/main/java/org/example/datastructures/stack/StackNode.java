package org.example.datastructures.stack;

public class StackNode {
    private int data;
    private StackNode below;

    public StackNode(int data) {
        this.data = data;
    }

    public StackNode getBelow() {
        return below;
    }

    public void setBelow(StackNode below) {
        this.below = below;
    }

    public int getData() {
        return data;
    }
}
