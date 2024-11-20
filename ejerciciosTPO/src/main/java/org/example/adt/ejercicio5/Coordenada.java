package org.example.adt.ejercicio5;

// Este TDA representa una coordenada en el plano
public class Coordenada {
    private double x;
    private double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Verifico si la coordenada esta dentro del circulo.
    public boolean estaDentroDelCirculo(double radio) {
        return x * x + y * y <= radio * radio;
    }
}
