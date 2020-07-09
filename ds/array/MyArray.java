package ds.array;

import java.util.Arrays;

/**
 * array
 */
@SuppressWarnings("unchecked")

public class MyArray<T> {

    private T[] array;
    private int size;

    public MyArray(int initialSize) {
        this.array = (T[]) new Object[initialSize];
        this.size = 0;
    }

    public MyArray() {
        this(10);
    }

    public void add(T data) {
        if (isFull()) {
            resize();
        }
        array[size++] = data;

    }

    public T replace(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            T old = array[index];
            array[index] = data;
            return old;

        }
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T deleted = array[index];

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }

        size--;
        return deleted;
    }

    public int indexOf(T data) {

        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return i;

            }
        }
        return -1;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAt(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        if (isFull()) {
            resize();
        }

        for (int i = index; i < size + 1; i++) {
            T tmp = data;
            data = array[i];
            array[i] = tmp;
        }
        size++;
    }

    private void resize() {
        int len = array.length * 2;
        var copy = Arrays.copyOf(array, len);
        array = copy;
    }

    @Override
    public String toString() {
        var copy = Arrays.copyOf(array, size);
        return Arrays.toString(copy);
    }

}