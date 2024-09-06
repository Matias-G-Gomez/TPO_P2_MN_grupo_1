package org.example.adt;

import java.util.NoSuchElementException;

public class StaticQueue implements Queue {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()){
            throw new RuntimeException("No se puede obterner");
        }
        return array[0];
    }

    @Override
    public void add(int value){
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