package org.example.adt;

public class StaticNAryTree implements NAryTree {

    private final int indexRoot;
    private final Integer[] values;
    private final int max;
    private final int totalNodes;

    public StaticNAryTree(int root, int totalNodes) {
        int levels = 10;
        double candidate = Math.pow(totalNodes,levels) / (totalNodes - 1);
        while(candidate > Integer.MAX_VALUE) {
            levels--;
            candidate = Math.pow(totalNodes,levels) / (totalNodes - 1);
        }
        if(levels <= 1) {
            System.out.println("Warning: El árbol tendrá como máximo " + levels + "de altura");
        }
        this.max = (int) candidate;
        this.values = new Integer[max];

        this.indexRoot = 0;
        this.values[indexRoot] = root;
        this.totalNodes = totalNodes;
    }

    private StaticNAryTree(int indexRoot, Integer[] values, int max, int totalNodes) {
        this.values = values;
        this.indexRoot = indexRoot;
        this.max = max;
        this.totalNodes = totalNodes;
    }

    @Override
    public int getRoot() {
        return this.values[indexRoot];
    }

    @Override
    public void add(int value, int index) {
        check(index);
        if(this.values[totalNodes*indexRoot + 1 + index] != null) {
            throw new RuntimeException("Ya existe un hijo en la posición " + index);
        }
        this.values[totalNodes*indexRoot + 1 + index] = value;
    }

    @Override
    public NAryTree get(int index) {
        check(index);
        if(this.values[totalNodes*indexRoot + 1 + index] == null) {
            return null;
        }
        return new StaticNAryTree(totalNodes*this.indexRoot + 1 + index, this.values, this.max, this.totalNodes);
    }

    @Override
    public void delete(int index) {
        check(index);
        if(this.values[totalNodes*indexRoot + 1 + index] == null) {
            return;
        }
        NAryTree node = this.get(index);
        for(int i = 0; i < totalNodes; i++) {
            if(node.get(i) != null) {
                for(int j = 0; j < totalNodes; j++) {
                    node.get(i).delete(j);
                }
            }
        }
        this.values[totalNodes*indexRoot + 1 + index] = null;
    }

    private void check(int index) {
        if(index < 0 || index >= totalNodes) {
            throw new IndexOutOfBoundsException();
        }
    }
}
