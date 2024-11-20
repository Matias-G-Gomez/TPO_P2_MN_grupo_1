package org.example.adt.ejercicios1;

import org.example.adt.*;

import static org.example.utils.StackUtil.revert;

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




    // ACALARACIÓN COMPLEJIDAD COMPUTACIONAL:
    // n : es el número de pilas en la cola
    // m : es el tamaño promedio de las pilas


    // RESOLUCIÓN EJERCICIO 2.1.1 + COMPLEJIDAD COMPUTACIONAL
    // 1. Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza.

    public int calcularTraza(StaticQueueOfStacks colaDePilas){

        // Copio la cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaDeColaDePilas = copiaDeCola(colaDePilas); // Complejidad de copiaDeCola: O(n * m), ya que recorre la cola y copia los elementos de cada pila.


        // Creo una nueva colaDePilas
        StaticQueueOfStacks nuevaColaDePilas = new StaticQueueOfStacks(); // O(1)


        // Doy vuelta las pilas para poder calcular la traza de manera más fácil
        // Mientras voy agregando esas pilas dadas vueltas a mi nueva colaDePilas
        while (!copiaDeColaDePilas.isEmpty()){
            nuevaColaDePilas.add(revert(copiaDeColaDePilas.getFirst())); // `revert` tiene complejidad O(m) porque invierte una pila de tamaño `m`.
            copiaDeColaDePilas.remove(); // O(1)
        } // Complejidad total del while: O(n * m), porque procesa `n` pilas y cada pila tiene `m` elementos.

        // Inicializo la traza en 0
        int traza = 0; // O(1)

        // Inicializo la posicion de la Pila y del Valor de la Pila, ya que en la 1° posicion de la Pila,
        // hay que ver la última posicion del Valor de la Pila (que en la nueva pila es Top)
        int posicionPila = 0; // O(1)
        int posicionValorPila = 0; // O(1)

        // A su vez inicializo un contador para ir recorriendo toda la traza
        int recorrido = 0; // O(1)


        // Recorro la cola de pilas y voy calculando la traza
        while (!nuevaColaDePilas.isEmpty()){
            while(posicionPila >= 1){
                // voy removiendo las pilas que ya no uso
                nuevaColaDePilas.remove();
                posicionPila -= 1;
            }  // Este bucle externo se ejecuta O(n) veces porque recorre todas las pilas.

            while(posicionValorPila >= 1){
                // voy removiendo los valores que no uso dentro de la Pila
                Stack pilaACalcularAFuturo = nuevaColaDePilas.getFirst(); // O(1)
                pilaACalcularAFuturo.remove(); // O(1)
                posicionValorPila -= 1;
            } // Complejidad total del while interno: O(m), porque recorre todos los elementos de una pila.

            if( posicionPila == 0 && posicionValorPila == 0 ){
                // Sumo los valores a la traza
                Stack pilaACalcular = nuevaColaDePilas.getFirst(); // O(1)
                int valorACalcular = pilaACalcular.getTop(); // O(1)
                traza += valorACalcular; // O(1)

                // Voy a la siguiente posicion
                recorrido += 1; // O(1)
                posicionPila += recorrido; // O(1)
                posicionValorPila += recorrido; // O(1)
            }
        } // Complejidad total del while externo: O(n * m), porque recorre `n` pilas y procesa `m` elementos por pila.


        return traza; // O(1)
    }




    // RESOLUCIÓN EJERCICIO 2.1.2 + COMPLEJIDAD COMPUTACIONAL
    // 2. Desarrolle una función que reciba una instancia de QueueOfStacks, y devuelva su traspuesta.

    public int calcularTraspuesta(StaticQueueOfStacks colaDePilas){

        // Este while se ejecuta O(n) veces porque recorre todas las pilas de la cola.

        // Copio la cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaDeColaDePilas = copiaDeCola(colaDePilas); // O(n * m), porque `copiaDeCola` recorre todas las pilas y copia sus elementos.

        // Inicializo la traspuesta en 0
        int traspuesta = 0; // O(1)

        // Inicializo la posicion de la Pila y del Valor de la Pila, ya que en la 1° posicion de la Pila,
        // hay que ver la 1° posicion del Valor de la Pila (Top)
        int posicionPila = 0; // O(1)
        int posicionValorPila = 0; // O(1)

        // A su vez inicializo un contador para ir recorriendo toda la traspuesta
        int recorrido = 0; // O(1)


        // Recorro la cola de pilas y voy calculando la traspuesta
        while (!copiaDeColaDePilas.isEmpty()){
            while(posicionPila >= 1){
                // voy removiendo las pilas que ya no uso
                copiaDeColaDePilas.remove();
                posicionPila -= 1;
            } // O(1) por cada operación. La cantidad de iteraciones depende de `posicionPila`, pero en el peor caso es O(n).

            while(posicionValorPila >= 1){
                // voy removiendo los valores que no uso dentro de la Pila
                Stack pilaACalcularAFuturo = copiaDeColaDePilas.getFirst(); // O(1)
                pilaACalcularAFuturo.remove(); // O(1)
                posicionValorPila -= 1;

            } // Complejidad total del while: O(m), porque recorre los elementos de una pila.

            if( posicionPila == 0 && posicionValorPila == 0 ){
                // Sumo los valores a la traspuesta
                Stack pilaACalcular = copiaDeColaDePilas.getFirst(); // O(1)
                int valorACalcular = pilaACalcular.getTop(); // O(1)
                traspuesta += valorACalcular; // O(1)

                // Voy a la siguiente posicion
                recorrido += 1; // O(1)
                posicionPila += recorrido; // O(1)
                posicionValorPila += recorrido; // O(1)
            }
        } // Complejidad total del while externo: O(n * m), considerando el peor caso donde cada pila se recorre completamente.


        return traspuesta; // O(1)

    } // Complejidad Total: O(m*n)



    // RESOLUCIÓN EJERCICIO 2.1.3 CON COMPLEJIDAD COMPUTACIONAL
    // 3. Desarrolle una función que reciba dos instancias de QueueOfStacks y devuelva una nueva instancia de QueueOfStacks que represente la suma matricial.

    public StaticQueueOfStacks sumaMatricial(StaticQueueOfStacks primerColaDePilas, StaticQueueOfStacks segundaColaDePilas){

        // PRECONDICION: LAS COLAS DE PILAS DEBEN SER DEL MISMO TAMAÑO

        // Primero copio las 2 colas de pilas y doy vuelta sus pilas par que al realizar la suma Matricial
        // me quede como debe estar


        // Copio la 1° cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaPrimerColaDePilas = copiaDeCola(primerColaDePilas); // Complejidad de copiaDeCola: O(n * m), donde `n` es el tamaño de la cola y `m` el tamaño de las pilas.


        // Creo una nueva colaDePilas
        StaticQueueOfStacks nuevaPrimerColaDePilas = new StaticQueueOfStacks(); // O(1)


        // Doy vuelta las pilas para poder calcular la traza de manera más fácil
        // Mientras voy agregando esas pilas dadas vueltas a mi nueva primerColaDePilas
        while (!copiaPrimerColaDePilas.isEmpty()){
            nuevaPrimerColaDePilas.add(revert(copiaPrimerColaDePilas.getFirst())); // revert tiene O(m) por invertir una pila de tamaño `m`.
            copiaPrimerColaDePilas.remove(); // O(1) para eliminar de la cola.
        } // Complejidad total del while: O(n * m).

        // --------------------------------------------------------------------------------------------

        // Copio la 2° cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaSegundaColaDePilas = copiaDeCola(segundaColaDePilas); // O(n * m)


        // Creo una nueva colaDePilas
        StaticQueueOfStacks nuevaSegundaColaDePilas = new StaticQueueOfStacks(); // O(1)


        // Doy vuelta las pilas para poder calcular la traza de manera más fácil
        // Mientras voy agregando esas pilas dadas vueltas a mi nueva primerColaDePilas
        while (!copiaSegundaColaDePilas.isEmpty()){
            nuevaSegundaColaDePilas.add(revert(copiaSegundaColaDePilas.getFirst())); // revert tiene O(m).
            copiaSegundaColaDePilas.remove(); // O(1)
        } // Complejidad total del while: O(n * m).

        // --------------------------------------------------------------------------------------------

        // Creo la nueva cola de pilas que va a ser la suma matricial
        StaticQueueOfStacks colaDePilasSumaMatricial = new StaticQueueOfStacks(); // O(1)

        // Uso alguna de las colas de pilas como condicion (ya que las dos miden lo mismo)
        while (!nuevaPrimerColaDePilas.isEmpty()){
            // Creo la pila que voy a agregar en la cola
            Stack pilaAAgregar = new StaticStack(); // O(1)

            // Pila De Primer Cola de Pilas
            Stack pilaDePrimerColaDePilas = nuevaPrimerColaDePilas.getFirst(); // O(1)

            // Mientras la pila (en la que estoy parado) de la segunda cola de pilas no esté vacía:
            Stack pilaDeSegundaColaDePilas = nuevaSegundaColaDePilas.getFirst(); // O(1)


            while(!pilaDeSegundaColaDePilas.isEmpty()){
                int valorSumadoColasDePilas = pilaDeSegundaColaDePilas.getTop() + pilaDePrimerColaDePilas.getTop(); // O(1)
                pilaAAgregar.add(valorSumadoColasDePilas); // O(1)

                // Remuevo los valores de las pilas en las que estoy parado
                pilaDeSegundaColaDePilas.remove(); // O(1)
                pilaDePrimerColaDePilas.remove(); // O(1)
            } // Complejidad del while interno: O(m) (se itera sobre los elementos de cada pila).

            colaDePilasSumaMatricial.add(pilaAAgregar); // O(1)

            // Remuevo las pilas en la que estoy parado
            nuevaPrimerColaDePilas.remove(); // O(1)
            nuevaSegundaColaDePilas.remove(); // O(1)
        }

        return colaDePilasSumaMatricial; // O(1)

    } // Complejidad Total: O(n*m)



}
