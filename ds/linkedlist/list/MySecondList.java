package ds.linkedlist.list;

public interface MySecondList {

    void prepend(int data);

    void append(int data);

    int size();

    int removeHead();

    int removeTail();

    int remove(int data);

    void insert(int data, int index);

    boolean isEmpty();

    boolean find(int data);

}