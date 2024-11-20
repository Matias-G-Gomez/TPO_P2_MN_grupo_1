package org.example.adt.ejercicios3;

import org.example.adt.Queue;
import org.example.adt.StaticQueue;

public class StaticQueueOfQueue implements QueueOfQueue{

    private static final int MAX = 10000;
    private final Queue[] array; // Array que contiene las colas internas
    private int count; // Cantidad de colas en la QueueOfQueue

    public StaticQueueOfQueue() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    @Override
    public void add(Queue queue) {
        if (this.count == MAX) {
            throw new RuntimeException("La QueueOfQueue está llena");
        }
        this.array[this.count] = queue;
        this.count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La QueueOfQueue está vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Queue getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La QueueOfQueue está vacía");
        }
        return this.array[0];
    }

    @Override
    public QueueOfQueue concatenate(QueueOfQueue[] otraColaDeCola) {
        StaticQueueOfQueue result = new StaticQueueOfQueue();

        // Agrego las colas de la instancia actual
        for (int i = 0; i < this.count; i++) {
            result.add(this.array[i]);
        }

        // Agrego las colas de las otras instancias
        for (QueueOfQueue queueOfQueue : otraColaDeCola) {
            while (!queueOfQueue.isEmpty()) {
                result.add(queueOfQueue.getFirst());
                queueOfQueue.remove();
            }
        }

        return result;
    }

    @Override
    public Queue flat() {
        Queue result = new StaticQueue();

        // Recorrer todas las colas y agregar sus elementos a la cola plana
        for (int i = 0; i < this.count; i++) {
            Queue currentQueue = this.array[i];
            while (!currentQueue.isEmpty()) {
                result.add(currentQueue.getFirst());
                currentQueue.remove();
            }
        }

        return result;
    }

    @Override
    public QueueOfQueue reverseWithDepth() {
        StaticQueueOfQueue reversed = new StaticQueueOfQueue();

        // Recorrer en orden inverso las colas
        for (int i = this.count - 1; i >= 0; i--) {
            Queue currentQueue = this.array[i];
            Queue reversedQueue = new StaticQueue();

            // Invertir los elementos de cada cola
            while (!currentQueue.isEmpty()) {
                int value = currentQueue.getFirst();
                currentQueue.remove();

                // Agregar al tope de la nueva cola
                Queue tempQueue = new StaticQueue();
                while (!reversedQueue.isEmpty()) {
                    tempQueue.add(reversedQueue.getFirst());
                    reversedQueue.remove();
                }
                reversedQueue.add(value);
                while (!tempQueue.isEmpty()) {
                    reversedQueue.add(tempQueue.getFirst());
                    tempQueue.remove();
                }
            }

            // Agregar la cola invertida a la QueueOfQueue invertida
            reversed.add(reversedQueue);
        }

        return reversed;
    }
}
