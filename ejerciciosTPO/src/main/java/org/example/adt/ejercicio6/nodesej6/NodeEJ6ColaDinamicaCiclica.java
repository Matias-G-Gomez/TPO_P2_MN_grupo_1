package org.example.adt.ejercicio6.nodesej6;

public class NodeEJ6ColaDinamicaCiclica {

    private int value;
    private NodeEJ6ColaDinamicaCiclica next;
    private NodeEJ6ColaDinamicaCiclica previous; // Referencia al nodo anterior

    public NodeEJ6ColaDinamicaCiclica(int value, NodeEJ6ColaDinamicaCiclica next, NodeEJ6ColaDinamicaCiclica previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeEJ6ColaDinamicaCiclica getNext() {
        return next;
    }

    public void setNext(NodeEJ6ColaDinamicaCiclica next) {
        this.next = next;
    }

    public NodeEJ6ColaDinamicaCiclica getPrevious() {
        return previous;
    }

    public void setPrevious(NodeEJ6ColaDinamicaCiclica previous) {
        this.previous = previous;
    }
}
