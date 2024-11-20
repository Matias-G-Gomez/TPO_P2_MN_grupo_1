package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.example.adt.StaticStack;
import org.example.adt.ejercicios1.StaticQueueOfStacksUtil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 2.1

        // El usuario introduce un número, el scanner lo lee y lo guarda
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        //Llamo a la funcion colaCargadaDePilas que devuelve una cola estática de pilas cargadas
        StaticQueueOfStacksUtil colaDePilas = colaCargadaDePilas(n);

        //Llamo a la función calcularTraza y devuelvo el resultado por pantalla


    }

    //Ejercicio 2.1

    private static StaticQueueOfStacksUtil colaCargadaDePilas(int n) {
        StaticQueueOfStacksUtil colaPilas = new StaticQueueOfStacksUtil();
        for(int i = 0; i < n; i++){
            StaticStack pilaACargar = new StaticStack();
            cargarPila(pilaACargar,n);
            colaPilas.add(pilaACargar);
        }
        return colaPilas;
    }


    private static void cargarPila(StaticStack stack, int n){
        Random random = new Random();
        int numeroRandom = random.nextInt();

        for(int i = 0; i < n; i++){
            stack.add(numeroRandom);
        }
    }

    /*
    //Para el ejercicio 5 primera parte
    Stack stack = new StaticStack();
        stack.add(5);
        stack.add(1);
        stack.add(3);
        stack.add(5);
        stack.add(2);
        stack.add(1);
        stack.add(4);
        stack.add(3);

    // Pila original.
        System.out.println("Pila original:");
    printStack(stack);

    // Elimina elementos repetidos y ordena
    Stack result = EJ5.notRepeatedElementsOrdered(stack);

    // Impresion de la pila resultante
        System.out.println("\nPila sin repetidos y ordenada:");
    printStack(result);

    // Metodo auxiliar para imprimir el contenido de una pila
    public static void printStack (Stack stack){
        Stack aux = new StaticStack();

        while (!stack.isEmpty()) {
            System.out.print(stack.getTop() + " ");
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            aux.remove();
        }
        System.out.println();
    }


    // Ejercicio Montecarlo

    int totalCoordenadas = 1000;
    double radio = 1.0; // Radio del círculo.

    // Crear el conjunto de coordenadas y la estructura Montecarlo.
    Montecarlo montecarlo = new Montecarlo(radio);
    Random random = new Random();

        for (
    int i = 0;
    i < totalCoordenadas; i++) {
        double x = random.nextDouble() * radio;
        double y = random.nextDouble() * radio;
        Coordenada c = new Coordenada(x, y);

        montecarlo.agregarCoordenada(c);
    }

    // Aproximar π y mostrar el resultado
    double piAproximado = montecarlo.aproximarPi();
        System.out.println("Valor aproximado de π: " + piAproximado);


     */
}