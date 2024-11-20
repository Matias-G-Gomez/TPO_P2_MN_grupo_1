package org.example.adt.ejercicios2;

public interface QueueWithPriorityGenérica<T> {
    T getFirst();
    int getPriority();
    void add(T value, int priority);
    void remove();
    boolean isEmpty();
}
