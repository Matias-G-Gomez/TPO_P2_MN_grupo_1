package org.example.adt.nodes;

public class KeyNode {

    private int key;
    private ValueNode valueNode;
    private KeyNode next;

    public KeyNode(int key, KeyNode next, ValueNode valueNode) {
        this.key = key;
        this.next = next;
        this.valueNode = valueNode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ValueNode getValue() {
        return valueNode;
    }

    public void setValue(ValueNode value) {
        this.valueNode = value;
    }

    public KeyNode getNext() {
        return next;
    }

    public void setNext(KeyNode next) {
        this.next = next;
    }
}
