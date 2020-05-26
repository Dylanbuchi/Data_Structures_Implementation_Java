package stack.array;

import java.util.Arrays;

/**
 * MyArrayStack
 */
public class MyStackArray<T> {

    private T[] stack;
    private int front;
    private int size;

    public MyStackArray(int initialSize) {
        this();
        this.stack = (T[]) new Object[initialSize];

    }

    public MyStackArray() {
        super();
        this.stack = (T[]) new Object[10];
        this.front = -1;
        this.size = 0;
    }

    public T peek() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;
        }
        return stack[front];
    }

    public void push(T data) {
        if (isFull()) {
            resize();
        }
        stack[++front] = data;
        size++;

    }

    private void isEmptyMessage() {

        System.out.println("Stack is empty!");

    }

    public T pop() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;
        }
        size--;
        return stack[front--];

    }

    public int size() {
        return size;
    }

    private boolean isFull() {

        return size == stack.length;
    }

    private void resize() {
        int newSize = stack.length * 2;

        var newArray = Arrays.copyOf(stack, newSize);
        stack = newArray;

    }

    @Override
    public String toString() {

        var array = Arrays.copyOf(stack, size);

        return Arrays.toString(array);
    }

    public boolean isEmpty() {

        return size == 0;
    }

}