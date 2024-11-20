package org.example.adt.ejercicios2;

public class StaticQueueGenérica<T> implements QueueGenérica{
    private static final int MAX = 10000;

    private final Object[] array;
    private int count;

    public StaticQueueGenérica() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return (T) array[0]; // Hacemos un cast a T.
    }

    @Override
    public void add(Object value) {
        if (this.count == MAX) {
            throw new RuntimeException("La cola está llena");
        }
        this.array[this.count] = value;
        this.count++;
    }


    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede remover de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1]; // Desplazamos los elementos hacia la izquierda.
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
