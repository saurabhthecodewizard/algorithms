package day03.assignment;

import java.util.Stack;

//Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.
class QueueWithTwoStacks<T> {
    private final Stack<T> stack1; // For enqueue operation
    private final Stack<T> stack2; // For dequeue operation

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return null; // or throw an exception
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}
