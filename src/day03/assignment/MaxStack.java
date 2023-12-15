package day03.assignment;

import java.util.Stack;

class MaxStack {
    private final Stack<Double> mainStack;
    private final Stack<Double> maxStack;

    public MaxStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(double value) {
        mainStack.push(value);

        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }

    public double pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        double poppedValue = mainStack.pop();

        if (poppedValue == maxStack.peek()) {
            maxStack.pop();
        }

        return poppedValue;
    }

    public double getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return maxStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }
}
