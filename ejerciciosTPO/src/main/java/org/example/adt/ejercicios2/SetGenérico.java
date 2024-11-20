package org.example.adt.ejercicios2;

public interface SetGenérico<T> {
    void add(T element);
    T choose();
    void remove(T element);
    boolean isEmpty();
}
