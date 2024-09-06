package org.example.utils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.example.adt.Matriz;

public class Main {
    public static void main(String[] args) {
        try{
            Matriz matriz = new Matriz();
            matriz.crearPila();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}