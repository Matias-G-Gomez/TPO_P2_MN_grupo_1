package org.example.adt.ejercicios2;

public class StaticStackGenericoEjercicio1Util<T> implements StackGenérica {

    private static final int MAX = 10000;

    private final Object[] array;
    private int count;

    public StaticStackGenericoEjercicio1Util() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(Object item) {
        if (this.count == MAX) {
            throw new RuntimeException("La pila está llena");
        }
        this.array[this.count] = item;
        this.count++;
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        count--;
    }

    @Override
    public T getTop() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        return (T) array[this.count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }


    public <T> void invertirStack(StaticStackGenericoEjercicio1Util<T> pilaGenerica) {

        // Creo una pila para invertir el orden
        StaticStackGenericoEjercicio1Util pilaOrdenInvertido = new StaticStackGenericoEjercicio1Util();

        // Paso los elementos de la pilaGenerica a la pilaOrdenInvertido
        while(!pilaGenerica.isEmpty()){
            pilaOrdenInvertido.add(pilaGenerica.getTop());
            pilaGenerica.remove();
        }

    }


}
