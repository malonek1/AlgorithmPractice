package org.example.datastructures.stack;

public class MultiStack {

    private SingleStack[] stackArray;

    public MultiStack(int stackSize) {
        stackArray = new SingleStack[stackSize];
        for(int i = 0; i < stackArray.length; i ++) {
            stackArray[i] = new SingleStack();
        }
    }

    public void push(int stackIndex, int data) {
        stackArray[stackIndex].push(data);
    }

    public void pop(int stackIndex) {
        stackArray[stackIndex].pop();
    }

    public StackNode peek(int stackIndex) {
        return stackArray[stackIndex].peek();
    }

    public SingleStack getStack(int stackIndex) {
        return stackArray[stackIndex];
    }

    public void printAll(MultiStack stack) {
        for(int stackIndex = 0; stackIndex < stackArray.length; stackIndex ++) {
            System.out.println("Data contained in stack " + (stackIndex + 1) + ": ");
            stackArray[stackIndex].printAll(stack.getStack(stackIndex));
        }
    }
}
