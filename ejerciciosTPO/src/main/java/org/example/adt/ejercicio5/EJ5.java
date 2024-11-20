package org.example.adt.ejercicio5;
import org.example.adt.*;

public class EJ5 {

    // Elijo esta opcion:
    // Dada una pila de elementos desordenados, generar una nueva pila sin elementos repetidos y ordenados.

    //Complejidad: O(N^2) (dominado por la eliminacion de repetidos y el ordenamiento)
    public static Stack notRepeatedElementsOrdered(Stack stack) { // O(N^2) + O(N^2) + O(N) = O(N^2)
        Stack copy = copy(stack); // O(N) para copiar la pila usando el metodo copy
        Stack candidate = new StaticStack(); // O(C) para crear la pila estática
        Stack aux = new StaticStack(); // O(C) para crear la pila auxiliar
        Stack orderedStack = new StaticStack(); // O(C) para la pila ordenada

        // Elimina elementos repetidos de la pila.
        // El bucle externo se ejecuta O(N) veces (por cada elemento en la pila original).
        // Dentro de cada iteracion del bucle externo, el bucle interno itera sobre el resto de la pila,
        // lo que también es O(N)
        // O(C) + O(N * (C + C + N + N)) = O(N^2)
        while (!copy.isEmpty()) {
            candidate.add(copy.getTop()); // O(C)
            copy.remove(); // O(C)

            // O(C) + O(N * (C + C)) = O(N)
            while (!copy.isEmpty()) {
                if (copy.getTop() != candidate.getTop()) { // O(C)
                    aux.add(copy.getTop()); // O(C)
                }
                copy.remove(); // O(C)
            }

            // O(C) + O(N * (C + C)) = O(N)
            while (!aux.isEmpty()) {
                copy.add(aux.getTop()); // O(C)
                aux.remove(); // O(C)
            }
        }

        // Ordena los elementos de la pila resultante.
        // O(N * (N + N + C)) = O(N^2)
        while (!candidate.isEmpty()) {
            int min = findMin(candidate, aux); // O(N) por cada llamada para encontrar el minimo

            // O(C) + O(N * (C + C)) = O(N)
            while (!aux.isEmpty()) { //Restaura candidate
                int current = aux.getTop(); // O(C)
                aux.remove(); // O(C)
                if (current != min) {
                    candidate.add(current); // O(C)
                }
            }

            orderedStack.add(min); // O(C)
        }

        return orderedStack; // O(C)
    }

    // El metodo findMin mueve todos los elementos de candidate a aux y regresa el menor.
    // Este metodo tiene complejidad O(N) ya que encuentra el minimo recorriendo la pila una vez
    private static int findMin(Stack source, Stack target) { // O(N)
        int min = Integer.MAX_VALUE; // O(1)

        // O(C) + O(N * (C + C)) = O(N)
        while (!source.isEmpty()) {
            int top = source.getTop(); // O(C)
            source.remove(); // O(C)
            if (top < min) {
                min = top; // O(1)
            }
            target.add(top); // O(C)
        }

        return min; // O(1)
    }

    // Este metodo tiene complejidad O(N), ya que hace dos recorridos
    public static Stack copy(Stack stack) { // O(N) + O(N) = O(N)
        Stack aux = new StaticStack(); // O(C) para crear la pila auxiliar
        Stack aux2 = new StaticStack(); // O(C) para crear la pila auxiliar2

        while(!stack.isEmpty()) { // Primer bucle  O(N)
            aux.add(stack.getTop()); // O(C)
            stack.remove(); // O(C)
        }

        while(!aux.isEmpty()) { // Segundo bucle  O(N)
            stack.add(aux.getTop()); // O(C)
            aux2.add(aux.getTop()); // O(C)
            aux.remove(); // O(C)
        }

        return aux2; // O(C)
    }

    //Por lo tanto, la complejidad computacional es O(N^2) ya que domina sobre O(N).
}
