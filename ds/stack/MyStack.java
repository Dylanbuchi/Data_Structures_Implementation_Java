package stack;

import linkedlist.MyLinkedList;

public class MyStack<T> {

    private MyLinkedList<T> stack;

    public MyStack() {
        super();
        this.stack = new MyLinkedList<>();

    }

    public T peek() {
        return stack.peekFront();
    }

    public void push(T data) {
        stack.addFront(data);

    }

    public T pop() {

        return stack.popFront();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {

        return stack.toString();
    }

    public boolean isEmpty() {

        return stack.isEmpty();
    }
}