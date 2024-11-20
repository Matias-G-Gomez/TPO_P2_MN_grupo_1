package org.example.adt.ejercicio5;
import java.util.ArrayList;
import java.util.List;

public class Montecarlo {
    private List<Coordenada> coordenadas;
    private double radio;

    public Montecarlo(double radio) {
        this.radio = radio;
        this.coordenadas = new ArrayList<>();
    }

    // Agrego coordenadas si estan dentro del cuadrado.
    public void agregarCoordenada(Coordenada c) {
        if (c.getX() <= radio && c.getY() <= radio) {
            coordenadas.add(c);
        }
    }

    // Aproximo π usando el metodo de Montecarlo.
    public double aproximarPi() {
        int dentroDelCirculo = 0;

        for (Coordenada c : coordenadas) {
            if (c.estaDentroDelCirculo(radio)) {
                dentroDelCirculo++;
            }
        }

        // Area del circulo (estimada) dividida por el area del cuadrado (radio * radio).
        return 4.0 * dentroDelCirculo / coordenadas.size();
    }
}
