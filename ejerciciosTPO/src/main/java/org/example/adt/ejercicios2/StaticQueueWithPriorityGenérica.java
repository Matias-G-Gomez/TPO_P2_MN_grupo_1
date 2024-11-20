package org.example.adt.ejercicios2;

public class StaticQueueWithPriorityGenérica<T> implements QueueWithPriorityGenérica {

    private static final int MAX = 10000;

    private final Object[] values; // Usamos Object[] para manejar tipos genéricos.
    private final int[] priorities;
    private int count;

    public StaticQueueWithPriorityGenérica() {
        this.values = new Object[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }


    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return (T) values[0];
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }
        return priorities[0];
    }

    @Override
    public void add(Object value, int priority) {
        if (this.count == MAX) {
            throw new RuntimeException("La cola está llena");
        }

        // Si la cola está vacía, agregamos directamente.
        if (this.isEmpty()) {
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        // Si la nueva prioridad es mayor o igual que la última, va al final.
        if (this.priorities[count - 1] <= priority) {
            this.values[count] = value;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        // Si la nueva prioridad es menor que la primera, se inserta al inicio.
        if (this.priorities[0] > priority) {
            for (int i = this.count; i > 0; i--) {
                this.values[i] = this.values[i - 1];
                this.priorities[i] = this.priorities[i - 1];
            }
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        // Buscar posición intermedia para insertar.
        int index = -1;
        for (int i = 1; i < this.count; i++) {
            if (this.priorities[i - 1] <= priority && this.priorities[i] > priority) {
                index = i;
                break;
            }
        }

        // Mover elementos para abrir espacio.
        for (int i = this.count; i > index; i--) {
            this.values[i] = this.values[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }

        // Insertar nuevo elemento en su posición correcta.
        this.values[index] = value;
        this.priorities[index] = priority;
        this.count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
