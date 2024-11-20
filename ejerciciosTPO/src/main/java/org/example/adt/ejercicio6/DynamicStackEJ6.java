package org.example;

import org.example.nodes.Node;

public class DynamicStackEJ6 implements Stack{

    private Node first;
    private int maxCapacity;
    private int currentSize;

    public DynamicStackEJ6(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0");
        }
        this.maxCapacity = maxCapacity;
        this.currentSize = 0;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacía");
        }
        this.first = this.first.getNext();
        this.currentSize--;
    }

    @Override
    public void add(int value) {
        if (this.currentSize >= this.maxCapacity) {
            throw new RuntimeException("No se puede apilar: la pila ha alcanzado su capacidad máxima");
        }
        this.first = new Node(value, this.first);
        this.currentSize++;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }
}

