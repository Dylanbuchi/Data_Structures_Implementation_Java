package ds.stack;

public class MyStack<T> {

    private static class Node<T> {
        private Node<T> next;
        private T data;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;

    private int size;

    public MyStack() {
        super();
        this.front = null;
        this.size = 0;

    }

    public T peek() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;
        }
        return front.data;
    }

    public void push(T data) {
        var node = new Node<>(data);
        if (isEmpty()) {
            front = node;

        } else {
            node.next = front;
            front = node;

        }

        size++;

    }

    private void isEmptyMessage() {

        System.out.println("Stack is empty!");

    }

    public T pop() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;

        } else {
            T delete = front.data;
            front = front.next;
            size--;
            return delete;

        }

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        var temp = front;
        StringBuilder sb = new StringBuilder();

        while (temp != null) {

            sb.append("\n [" + temp.data + "] ");

            temp = temp.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {

        return front == null;
    }

}