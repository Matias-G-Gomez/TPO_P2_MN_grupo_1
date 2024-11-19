package org.example.adt.ejercicios1;

import org.example.adt.QueueOfStacks;
import org.example.adt.Stack;
import org.example.adt.StaticStack;

public class StaticQueueOfStacks implements QueueOfStacks {

    private static final int MAX = 10000;

    private final Stack[] array;
    private int count;

    public StaticQueueOfStacks() {
        this.array = new StaticStack[MAX];
        this.count = 0;
    }

    @Override
    public Stack getFirst() {
        if(isEmpty()){
            throw new RuntimeException("No se puede obterner");
        }
        return array[0];
    }

    @Override
    public void add(Stack value){
        if(this.count == MAX){
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public void remove() {
        if(isEmpty()){
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        for (int i=0; i<count -1; i++){
            this.array[i] = this.array[i+1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() { return this.count == 0; }


}
