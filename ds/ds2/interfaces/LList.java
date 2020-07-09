package ds.ds2.interfaces;

public interface LList<T> {

    int size();

    int capacity();

    boolean isEmpty();

    T get(int index);

    void push(T item);

    void insert(int index, T item);

    void prepend(T item);

    T pop();

    T delete(int index);

    T remove(T item);

    int find(T item);

}