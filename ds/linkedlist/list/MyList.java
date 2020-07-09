package ds.linkedlist.list;

/**
 * MyList
 */
public interface MyList<T> {

    void addFront(T data);

    T peekFront();

    T popFront();

    void append(T data);

    T peekLast();

    T popLast();

    boolean find(T data);

    boolean isEmpty();

    void addBefore(T current, T data);

    void addAfter(T current, T data);

    int size();

    T remove(T data);
}