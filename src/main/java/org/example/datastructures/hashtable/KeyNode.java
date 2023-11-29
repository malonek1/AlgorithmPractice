package org.example.datastructures.hashtable;

public class KeyNode {

    private int key;
    private KeyNode next;
    private ValueNode valueNode;

    public KeyNode(int key, ValueNode valueNode) {
        this.key = key;
        this.valueNode = valueNode;
        next = null;
    }

    public int getKey() {
        return key;
    }

    public KeyNode getNextKey() {
        return next;
    }

    public void setNextKey(KeyNode next) {
        this.next = next;
    }

    public ValueNode getValueNode() {
        return valueNode;
    }
}
