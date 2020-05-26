package queue.array;

import java.util.Arrays;

public class MyArrayQueue<T> {
    private T[] queue;
    private int size;
    private int back;
    private int front;

    public MyArrayQueue(int startingSize) {
        this();
        this.queue = (T[]) new Object[startingSize];

    }

    public MyArrayQueue() {
        super();
        this.size = 0;
        this.front = 0;
        this.back = -1;
        this.queue = (T[]) new Object[10];

    }

    public void enqueue(T data) {
        if (isFull()) {

            resize();
        }

        queue[++back] = data;
        size++;
    }

    private boolean isFull() {

        return size == queue.length;
    }

    private void resize() {
        int newSize = queue.length * 2;

        var newArray = Arrays.copyOf(queue, newSize);
        queue = newArray;

    }

    public boolean isEmpty() {

        return size == 0;
    }

    private void isEmptyMessage() {
        System.out.println("Queue is empty!");
    }

    public T dequeue() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;
        }

        size--;
        return queue[front++];

    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            isEmptyMessage();
        }
        return queue[front];
    }

    @Override
    public String toString() {

        var array = Arrays.copyOfRange(queue, front, back + 1);

        return Arrays.toString(array);
    }
}