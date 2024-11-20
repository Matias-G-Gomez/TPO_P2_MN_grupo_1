package org.example.adt.ejercicio4;

import org.example.adt.Stack;

public class BuilderStack {
    private StaticStackEJ4 stack;

    public BuilderStack() {
        this.stack = new StaticStackEJ4();
    }

    public BuilderStack add(int value) {
        stack.add(value);
        return this;
    }

    public BuilderStack addAll(Stack otherStack) {
        while (!otherStack.isEmpty()) {
            stack.add(otherStack.getTop());
            otherStack.remove();
        }
        return this;
    }

    public StaticStackEJ4 build() {
        return stack;
    }
}
