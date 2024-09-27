package org.example.adt;

import java.util.Random;

public class StaticSet implements Set{

    private static final int MAX = 10000;


    // 1,5,7,7,2,5,14
    // inicio : [0,0,0,0,0,0, ...
    // 14 -> [14,0,0,0,0,...
    // 5 -> [14,5,0,0,0,...
    // 2 -> [14,5,2,0,0,...
    // 7 -> [14,5,2,7,0,...



    private final int[] array;
    private int count;
    private final Random random;

    public StaticSet(int[] array) {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(int a) {
        for(int i=0; i < this.count; i++){
            if(this.array[i] == a){
                return;
            }

            this.array[this.count]=a;
            this.count++;
        }
    }

    @Override
    public int choose() {
        if(this.isEmpty()){
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }

        // i en el rango [0, count)
        // array[i]

        int i = random.nextInt(count);
        return this.array[i];
    }

    @Override
    public void remove(int a) {
        for(int i=0; i < this.count; i++){
            if(this.array[i] == a){
                this.array[i] = this.array[this.count-1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
