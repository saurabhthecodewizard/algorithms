package day03.stack;

import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T> {
    private Node head = null;

    private class Node {
        T item;
        Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void push(T item) {
        Node old = head;
        head = new Node();
        head.item = item;
        head.next = old;
    }

    public T pop() {
        T item = head.item;
        head = head.next;
        return item;
    }
}
