package org.example.adt;

public interface Queue {
    int getFirst();

    void add(int value);

    void remove();

    boolean isEmpty();
}
