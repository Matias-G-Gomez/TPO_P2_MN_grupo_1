package org.example.adt;

public interface Set {

    /**
     *
     * @param a es el valor a agregar, solo si no existe en el conjunto
     */

    void add(int a);

    int choose();


    /**
     *
     * @param a es el elemento a borrar y si no existe en la estructura, no se hace nada
     */

    void remove(int a);

    boolean isEmpty();
}
