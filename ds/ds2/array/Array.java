package ds.ds2.array;

import ds.ds2.interfaces.LList;

/**
 * Array
 * 
 * 
 */
@SuppressWarnings("unchecked")

public class Array<T> implements LList<T> {

    private int capacity;
    private T[] array;
    private int size;

    public Array() {
        this(16);
    }

    public Array(final int capacity) {

        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;

    }

    private void resize(final int newCapacity) {
        capacity = newCapacity;
        final var copy = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            copy[i] = array[i];

        }
        array = copy;

    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public int capacity() {

        return capacity;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public T get(final int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();

        } else {
            return array[index];
        }

    }

    @Override
    public void push(final T item) {

        if (size == capacity) {
            resize(capacity * 2);

        }
        array[size++] = item;

    }

    @Override
    public void insert(final int index, final T item) {
        if (isEmpty() && index == 0) {
            array[index] = item;
            size++;

        } else if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();

        } else if (item == null) {
            throw new NullPointerException("The item to insert can't be null");

        } else {
            if (size == capacity) {
                resize(capacity * 2);

            }

            for (int i = size; i > index; i--) {

                array[i] = array[i - 1];

            }

            array[index] = item;
            size++;

        }

    }

    @Override
    public void prepend(final T item) {

        insert(0, item);

    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return array[size--];
    }

    @Override
    public T delete(final int index) {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        else if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];

            }

            T deleted = array[index];
            size--;
            return deleted;
        }

    }

    @Override
    public T remove(final T item) {
        int index = 0;
        while (true) {
            index = find(item);
            if (index == -1) {
                break;

            }
            delete(index);
        }
        throw new NullPointerException();
    }

    @Override
    public int find(final T item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb = i == size - 1 ? sb.append("[" + array[i] + "]") : sb.append("[" + array[i] + "], ");

        }

        return sb.toString();

    }

}