package org.example.adt.ejercicios3;

import org.example.adt.Queue;

public interface QueueOfQueue {
    void add(Queue queue);
    void remove();
    boolean isEmpty();
    Queue getFirst();

    // Métodos específicos
    QueueOfQueue concatenate(QueueOfQueue[] otraColaDeCola);
    Queue flat();
    QueueOfQueue reverseWithDepth();
}
