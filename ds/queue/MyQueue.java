package queue;

public class MyQueue<T> {
    private static class Node<T> {
        private Node<T> next;
        private T data;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> back;
    private int size;

    public MyQueue() {
        super();
        this.back = null;
        this.front = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        var node = new Node<>(data);
        if (isEmpty()) {
            front = back = node;
        } else {
            back.next = node;
            back = node;
        }
        size++;
    }

    private void isEmptyMessage() {
        System.out.println("Queue is empty!");
    }

    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        var temp = front;
        StringBuilder sb = new StringBuilder();

        while (temp != null) {

            if (temp == back) {
                sb.append("[" + temp.data + "]");
            } else {
                sb.append("[" + temp.data + "] <-- ");
            }

            temp = temp.next;
        }
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public T dequeue() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;
        }
        T delete = front.data;
        front = front.next;
        size--;
        return delete;

    }

    public T peek() {
        if (isEmpty()) {
            isEmptyMessage();
            return null;
        }
        return front.data;
    }

}