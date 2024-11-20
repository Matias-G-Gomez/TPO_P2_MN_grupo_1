package org.example.adt.ejercicios2;

public interface StackGenérica<T> {

    void add(T item);
    void remove();
    T getTop();
    boolean isEmpty();
}
