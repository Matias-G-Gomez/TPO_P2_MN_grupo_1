package org.example.adt.ejercicio4;

import org.example.adt.Stack;

public class StaticStackEJ4 implements Stack {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticStackEJ4() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        count--;
    }

    @Override
    public void add(int value) {
        if (this.count == MAX) {
            throw new RuntimeException("La pila está llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    // Metodo Builder para StaticStack
    public static BuilderStack builder() {
        return new BuilderStack();
    }
}
