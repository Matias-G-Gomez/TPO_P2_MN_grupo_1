package org.example.adt.ejercicio4;

import org.example.adt.Set;

public class BuilderSet {
    private StaticSetEJ4 set;

    public BuilderSet() {
        this.set = new StaticSetEJ4();
    }

    public BuilderSet add(int a) {
        set.add(a);
        return this;
    }

    public BuilderSet addAll(Set otherSet) {
        while (!otherSet.isEmpty()) {
            set.add(otherSet.choose());
            otherSet.remove(otherSet.choose());
        }
        return this;
    }

    public StaticSetEJ4 build() {
        return set;
    }
}
