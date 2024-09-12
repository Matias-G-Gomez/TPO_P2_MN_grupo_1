package org.example.adt;

public interface QueueOfStacks {
    Stack getFirst();

    void add(Stack value);

    void remove();

    boolean isEmpty();
}
