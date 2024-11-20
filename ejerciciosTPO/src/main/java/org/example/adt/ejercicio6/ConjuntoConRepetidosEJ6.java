package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConjuntoConRepetidosEJ6 {

    private final Set elements; // Conjunto base
    private final Map<Integer, Integer> counts; // Mapeo de elementos a sus cantidades

    public ConjuntoConRepetidosEJ6() {
        this.elements = new StaticSetEJ6();
        this.counts = new HashMap<>();
    }

    // Agrega un elemento al conjunto, incrementando su contador.
    public void add(int value) {
        if (!SetUtilEJ6.in(value, elements)) {
            elements.add(value);
            counts.put(value, 1);
        } else {
            counts.put(value, counts.get(value) + 1);
        }
    }

    // Elimina una ocurrencia del elemento del conjunto.
    // Si el contador llega a cero, elimina el elemento por completo.
    public void remove(int value) {
        if (!SetUtilEJ6.in(value, elements)) {
            throw new RuntimeException("Elemento no encontrado en el conjunto");
        }

        int currentCount = counts.get(value);
        if (currentCount == 1) {
            elements.remove(value);
            counts.remove(value);
        } else {
            counts.put(value, currentCount - 1);
        }
    }

    // Devuelve cuantas veces aparece un elemento en el conjunto.
    public int count(int value) {
        return counts.getOrDefault(value, 0);
    }

    // Devuelve true si el conjunto esta vacio.
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Devuelve una lista de todos los elementos (con repeticion).
    public List<Integer> toList() {
        List<Integer> result = new ArrayList<>();
        Set copy = SetUtilEJ6.copy(elements);

        while (!copy.isEmpty()) {
            int element = copy.choose();
            int repetitions = counts.get(element);
            for (int i = 0; i < repetitions; i++) {
                result.add(element);
            }
            copy.remove(element);
        }
        return result;
    }

    // Devuelve el conjunto base de elementos unicos en el conjunto
    public Set uniqueElements() {
        return SetUtilEJ6.copy(elements);
    }

    // Imprime todos los elementos del conjunto con sus cantidades.
    public void print() {
        Set copy = SetUtilEJ6.copy(elements);
        while (!copy.isEmpty()) {
            int element = copy.choose();
            System.out.println(element + ": " + counts.get(element));
            copy.remove(element);
        }
    }
}
