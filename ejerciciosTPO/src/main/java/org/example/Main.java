package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.example.adt.StaticQueueOfStacks;
import org.example.adt.StaticStack;
import org.example.utils.StaticQueueOfStacksUtil;

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
// ESTO VA EN UN NUEVO UTIL
    public static int calcularTraza(StaticQueueOfStacksUtil colaDePilas){
        int cantidadPilas = colaDePilas.contadorDePilas();
    }

*/
}