package org.example.adt.ejercicio6;

import org.example.adt.Queue;
import org.example.adt.ejercicio6.nodesej6.NodeEJ6ColaDinamicaCiclica;

public class ColaDinamicaCiclicaDoblementeEnlazadaEJ6 implements Queue {

    // Para implementar una cola dinámica cíclica doblemente enlazada,
    // uso nodos que tengan referencias tanto al nodo siguiente como al anterior
    private NodeEJ6ColaDinamicaCiclica first; // Nodo inicial de la cola
    private NodeEJ6ColaDinamicaCiclica last;  // Nodo final de la cola

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }

        if (this.first == this.last) { // Caso especial: un solo elemento
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(this.last);
            this.last.setNext(this.first);
        }
    }

    @Override
    public void add(int value) {
        NodeEJ6ColaDinamicaCiclica newNode = new NodeEJ6ColaDinamicaCiclica(value, null, null);

        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
            this.first.setNext(newNode);
            this.first.setPrevious(newNode);
        } else {
            newNode.setPrevious(this.last);
            newNode.setNext(this.first);
            this.last.setNext(newNode);
            this.first.setPrevious(newNode);
            this.last = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

}
