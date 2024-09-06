package org.example.adt;

import java.util.Random;
import java.util.Scanner;

public class Matriz{

    private StaticQueue queueOfStacks;
    private Random random = new Random();
    private int n = cantidadElementos();

    public Matriz(){
        this.queueOfStacks = new StaticQueue();
    }

    public int cantidadElementos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la stack: ");
        int result = sc.nextInt();

        return result;
    }

    public StaticStack crearPila(){
        StaticStack pila = new StaticStack();
        for (int i = 0; i < n; i++){
            pila.add(random.nextInt(10));
            pila.getTop();
        }
        return pila;
    }


    /*
    public StaticQueue crearCola(){
        this.queueOfStacks = new StaticQueue();
        for (int i = 0; i < n; i++){
            queueOfStacks.add(crearPila());
        }
    }
    */

}
