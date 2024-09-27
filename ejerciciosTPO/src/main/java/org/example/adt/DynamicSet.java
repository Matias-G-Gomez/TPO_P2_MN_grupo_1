package org.example.adt;

import org.example.adt.nodes.Node;

import java.util.Random;

public class DynamicSet implements Set{

    private Node first;
    private final Random random;
    private int size;

    public DynamicSet() {
        this.random = new Random();
        this.first = null;
        this.size = 0;
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()){
            this.first = new Node(a, null);
            this.size++;
            return;
        }

        Node current = this.first;
        while(current.getNext() != null){
            if(current.getValue() == a){
                return;
            }
            current = current.getNext();
        }

        if(current.getValue() == a){
            return;
        }

        current.setNext(new Node(a, null));

    }

    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(size);
        int count = 0;
        Node current = this.first;
        while(current != null) {
            if(count == i) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()){
            return;
        }
        if(this.first.getNext() == null){
            if(this.first.getValue() == a){
                this.first = null;
            }
            return;
        }
        if(this.first.getValue()==a){
            this.first = this.first.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
