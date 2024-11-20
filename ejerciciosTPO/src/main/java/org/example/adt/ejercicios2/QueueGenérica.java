package org.example.adt.ejercicios2;

public interface QueueGenérica<T> {
    T getFirst();
    void add(Object value);
    void remove();
    boolean isEmpty();
}
