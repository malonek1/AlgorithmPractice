package org.example.datastructures.hashtable;

public class ValueNode {

    private int value;
    private ValueNode valueNode;

    public ValueNode(int value) {
        this.value = value;
        valueNode = null;
    }

    public int getValue() {
        return value;
    }

    public ValueNode getValueNode() {
        return valueNode;
    }

    public void setValueNode(ValueNode valueNode) {
        this.valueNode = valueNode;
    }
}
