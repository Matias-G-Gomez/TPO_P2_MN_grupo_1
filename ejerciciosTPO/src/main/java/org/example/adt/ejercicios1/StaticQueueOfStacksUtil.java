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



    // RESOLUCIÓN EJERCICIO 2.1.1
    // 1. Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza.

    public int calcularTraza(StaticQueueOfStacks colaDePilas){

        // Copio la cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaDeColaDePilas = copiaDeCola(colaDePilas);


        // Creo una nueva colaDePilas
        StaticQueueOfStacks nuevaColaDePilas = new StaticQueueOfStacks();


        // Doy vuelta las pilas para poder calcular la traza de manera más fácil
        // Mientras voy agregando esas pilas dadas vueltas a mi nueva colaDePilas
        while (!copiaDeColaDePilas.isEmpty()){
            nuevaColaDePilas.add(revert(copiaDeColaDePilas.getFirst()));
            copiaDeColaDePilas.remove();
        }

        // Inicializo la traza en 0
        int traza = 0;

        // Inicializo la posicion de la Pila y del Valor de la Pila, ya que en la 1° posicion de la Pila,
        // hay que ver la última posicion del Valor de la Pila (que en la nueva pila es Top)
        int posicionPila = 0;
        int posicionValorPila = 0;

        // A su vez inicializo un contador para ir recorriendo toda la traza
        int recorrido = 0;


        // Recorro la cola de pilas y voy calculando la traza
        while (!nuevaColaDePilas.isEmpty()){
            while(posicionPila >= 1){
                // voy removiendo las pilas que ya no uso
                nuevaColaDePilas.remove();
                posicionPila -= 1;
            }

            while(posicionValorPila >= 1){
                // voy removiendo los valores que no uso dentro de la Pila
                Stack pilaACalcularAFuturo = nuevaColaDePilas.getFirst();
                pilaACalcularAFuturo.remove();
                posicionValorPila -= 1;
            }

            if( posicionPila == 0 && posicionValorPila == 0 ){
                // Sumo los valores a la traza
                Stack pilaACalcular = nuevaColaDePilas.getFirst();
                int valorACalcular = pilaACalcular.getTop();
                traza += valorACalcular;

                // Voy a la siguiente posicion
                recorrido += 1;
                posicionPila += recorrido;
                posicionValorPila += recorrido;
            }
        }


        return traza;
    }




    // RESOLUCIÓN EJERCICIO 2.1.2
    // 2. Desarrolle una función que reciba una instancia de QueueOfStacks, y devuelva su traspuesta.

    public int calcularTraspuesta(StaticQueueOfStacks colaDePilas){

        // Copio la cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaDeColaDePilas = copiaDeCola(colaDePilas);

        // Inicializo la traspuesta en 0
        int traspuesta = 0;

        // Inicializo la posicion de la Pila y del Valor de la Pila, ya que en la 1° posicion de la Pila,
        // hay que ver la 1° posicion del Valor de la Pila (Top)
        int posicionPila = 0;
        int posicionValorPila = 0;

        // A su vez inicializo un contador para ir recorriendo toda la traspuesta
        int recorrido = 0;


        // Recorro la cola de pilas y voy calculando la traspuesta
        while (!copiaDeColaDePilas.isEmpty()){
            while(posicionPila >= 1){
                // voy removiendo las pilas que ya no uso
                copiaDeColaDePilas.remove();
                posicionPila -= 1;
            }

            while(posicionValorPila >= 1){
                // voy removiendo los valores que no uso dentro de la Pila
                Stack pilaACalcularAFuturo = copiaDeColaDePilas.getFirst();
                pilaACalcularAFuturo.remove();
                posicionValorPila -= 1;
            }

            if( posicionPila == 0 && posicionValorPila == 0 ){
                // Sumo los valores a la traspuesta
                Stack pilaACalcular = copiaDeColaDePilas.getFirst();
                int valorACalcular = pilaACalcular.getTop();
                traspuesta += valorACalcular;

                // Voy a la siguiente posicion
                recorrido += 1;
                posicionPila += recorrido;
                posicionValorPila += recorrido;
            }
        }


        return traspuesta;
    }



    // RESOLUCIÓN EJERCICIO 2.1.3
    // 3. Desarrolle una función que reciba dos instancias de QueueOfStacks y devuelva una nueva instancia de QueueOfStacks que represente la suma matricial.

    public StaticQueueOfStacks sumaMatricial(StaticQueueOfStacks primerColaDePilas, StaticQueueOfStacks segundaColaDePilas){

        // PRECONDICION: LAS COLAS DE PILAS DEBEN SER DEL MISMO TAMAÑO

        // Primero copio las 2 colas de pilas y doy vuelta sus pilas par que al realizar la suma Matricial
        // me quede como debe estar


        // Copio la 1° cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaPrimerColaDePilas = copiaDeCola(primerColaDePilas);


        // Creo una nueva colaDePilas
        StaticQueueOfStacks nuevaPrimerColaDePilas = new StaticQueueOfStacks();


        // Doy vuelta las pilas para poder calcular la traza de manera más fácil
        // Mientras voy agregando esas pilas dadas vueltas a mi nueva primerColaDePilas
        while (!copiaPrimerColaDePilas.isEmpty()){
            nuevaPrimerColaDePilas.add(revert(copiaPrimerColaDePilas.getFirst()));
            copiaPrimerColaDePilas.remove();
        }

        // --------------------------------------------------------------------------------------------

        // Copio la 2° cola de pilas que paso por parámetro
        StaticQueueOfStacks copiaSegundaColaDePilas = copiaDeCola(segundaColaDePilas);


        // Creo una nueva colaDePilas
        StaticQueueOfStacks nuevaSegundaColaDePilas = new StaticQueueOfStacks();


        // Doy vuelta las pilas para poder calcular la traza de manera más fácil
        // Mientras voy agregando esas pilas dadas vueltas a mi nueva primerColaDePilas
        while (!copiaSegundaColaDePilas.isEmpty()){
            nuevaSegundaColaDePilas.add(revert(copiaSegundaColaDePilas.getFirst()));
            copiaSegundaColaDePilas.remove();
        }

        // --------------------------------------------------------------------------------------------

        // Creo la nueva cola de pilas que va a ser la suma matricial
        StaticQueueOfStacks colaDePilasSumaMatricial = new StaticQueueOfStacks();

        // Uso alguna de las colas de pilas como condicion (ya que las dos miden lo mismo)
        while (!nuevaPrimerColaDePilas.isEmpty()){
            // Creo la pila que voy a agregar en la cola
            Stack pilaAAgregar = new StaticStack();

            // Pila De Primer Cola de Pilas
            Stack pilaDePrimerColaDePilas = nuevaPrimerColaDePilas.getFirst();

            // Mientras la pila (en la que estoy parado) de la segunda cola de pilas no esté vacía:
            Stack pilaDeSegundaColaDePilas = nuevaSegundaColaDePilas.getFirst();
            while(!pilaDeSegundaColaDePilas.isEmpty()){
                int valorSumadoColasDePilas = pilaDeSegundaColaDePilas.getTop() + pilaDePrimerColaDePilas.getTop();
                pilaAAgregar.add(valorSumadoColasDePilas);

                // Remuevo los valores de las pilas en las que estoy parado
                pilaDeSegundaColaDePilas.remove();
                pilaDePrimerColaDePilas.remove();
            }

            colaDePilasSumaMatricial.add(pilaAAgregar);

            // Remuevo las pilas en la que estoy parado
            nuevaPrimerColaDePilas.remove();
            nuevaSegundaColaDePilas.remove();
        }

        return colaDePilasSumaMatricial;

    }



}
