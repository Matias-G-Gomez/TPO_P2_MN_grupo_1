package org.example.adt;

import java.util.LinkedList;
import java.util.List;

public class DynamicNAryTree implements NAryTree {

    private final int root;
    private final List<NAryTree> nodes;
    private final int totalNodes;

    public DynamicNAryTree(int root, int totalNodes) {
        this.root = root;
        this.nodes = new LinkedList<>();
        for(int i = 0; i < totalNodes; i++) {
            this.nodes.add(null);
        }
        this.totalNodes = totalNodes;
    }

    @Override
    public int getRoot() {
        return root;
    }

    @Override
    public void add(int value, int index) {
        check(index);

        if(this.nodes.get(index) != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.nodes.set(index, new DynamicNAryTree(value, this.totalNodes));
    }

    @Override
    public NAryTree get(int index) {
        check(index);

        return this.nodes.get(index);
    }

    @Override
    public void delete(int index) {
        check(index);
        this.nodes.set(index, null);
    }

    private void check(int index) {
        if(index < 0 || index >= totalNodes) {
            throw new IndexOutOfBoundsException();
        }
    }
}
