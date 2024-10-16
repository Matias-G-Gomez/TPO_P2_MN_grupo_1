package org.example.utils;

import org.example.adt.QueueOfStacks;
import org.example.adt.Stack;
import org.example.adt.StaticQueueOfStacks;

public class StaticQueueOfStacksUtil implements QueueOfStacks {
    @Override
    public Stack getFirst() {
        return null;
    }

    @Override
    public void add(Stack value) {

    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public StaticQueueOfStacks copiaDeCola(StaticQueueOfStacks cola){
        StaticQueueOfStacks copia1 = new StaticQueueOfStacks();
        StaticQueueOfStacks copia2 = new StaticQueueOfStacks();

        while(!cola.isEmpty()){
            copia1.add(cola.getFirst());
            copia2.add(cola.getFirst());
            cola.remove();
        }

        while(!copia2.isEmpty()){
            cola.add(copia2.getFirst());
            copia2.remove();
        }

        return copia1;
    }

    public int contadorDePilas(StaticQueueOfStacks colaDePilas) {
        int count = 0;
        StaticQueueOfStacks aux = copiaDeCola(colaDePilas);
        while(!aux.isEmpty()){
            count ++;
            aux.remove();
        }
        return count;
    }


    // RESOLUCIÓN EJERCICIO 2.1.1
    // 1. Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza.

    public int calcularTraza(StaticQueueOfStacks colaDePilas){
        int traza = 0;

        return traza;
    }

}
