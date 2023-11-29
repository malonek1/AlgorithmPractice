package org.example.datastructures.hashtable;

public class HashTable {

    private int key, value;
    private KeyNode head;

    public void insert(int key, int value) {
        ValueNode valueNode = new ValueNode(value);
        KeyNode current = new KeyNode(key, valueNode);
        if(head == null) {
            head = current;
        }
        else {
            KeyNode last = head;
            while(last.getNextKey() != null) {
                last = last.getNextKey();
            }
            last.setNextKey(current);
        }
    }

    public int get(int key) {
        while(head.getNextKey() != null) {
            if (head.getKey() == key) {
                return head.getValueNode().getValue();
            }
        }
        return 0;
    }

    public void printTable(HashTable table) {
        KeyNode temp = table.head;
        while(temp != null) {
            System.out.println(head.getKey() + ", " + head.getValueNode().getValue());
            temp = temp.getNextKey();
        }
    }
}
