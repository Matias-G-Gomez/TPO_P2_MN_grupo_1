package org.example.adt.ejercicios2;

import java.util.Random;

public class StaticSetEjercicio2Util <T> implements SetGenérico {

    private static final int MAX = 10000;

    private final Object[] array;
    private int count;
    private final Random random;

    public StaticSetEjercicio2Util() {
        this.array = new Object[MAX];
        this.count = 0;
        this.random = new Random();
    }



    @Override
    public void add(Object element) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(element)) {
                return;
            }
        }
        if (this.count == MAX) {
            throw new RuntimeException("El conjunto está lleno");
        }
        this.array[this.count] = element;
        this.count++;
    }

    @Override
    public Object choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }

        int i = random.nextInt(count);
        return (Object) this.array[i];
    }

    @Override
    public void remove(Object element) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(element)) {
                this.array[i] = this.array[this.count - 1];
                this.count--;
                return;
            }
        }
    }


    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }


    public <T> StaticSetEjercicio2Util<T> copiarSetGenerico(StaticSetEjercicio2Util<T> setOriginal){
        StaticSetEjercicio2Util<T> copiaSet = new StaticSetEjercicio2Util<>();

        for( int i = 0; i < setOriginal.count; i++){
            copiaSet.add(setOriginal.array[i]);
        }

        return copiaSet;
    }


}
