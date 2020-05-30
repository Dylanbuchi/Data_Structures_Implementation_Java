package linkedlist.list.circularlinkedlist;

public class CircularLinkedList {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
    }

    public void insertHead(int data) {
        var node = new Node(data);
        if (isEmpty()) {
            tail = node;
            tail.next = tail;
        } else {

            node.next = tail.next;
            tail.next = node;

        }
        size++;
    }

    public int removeHead() {
        if (!isEmpty()) {
            int delete = tail.next.data;
            if (tail == tail.next) {
                tail = null;
            } else {

                tail.next = tail.next.next;

            }

            size--;
            return delete;
        }
        return -1;
    }

    public int removeTail() {
        if (!isEmpty()) {
            int delete = tail.data;

            if (tail == tail.next) {
                tail = null;
            } else {

                var prev = getPrev();
                prev.next = tail.next;
                tail.next = null;
                tail = prev;
            }
            size--;
            return delete;
        }
        return -1;
    }

    private Node getPrev() {
        var prev = tail;
        while (prev.next != tail) {
            prev = prev.next;

        }
        return prev;

    }

    public void insertTail(int data) {
        var node = new Node(data);
        if (isEmpty()) {
            tail = node;
            tail.next = tail;
        } else {

            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        var temp = tail.next;
        while (temp != tail) {

            System.out.print(temp.data + " --> ");

            temp = temp.next;

        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        var c = new CircularLinkedList();
        c.insertHead(0);
        c.insertHead(1);
        c.removeTail();
        c.removeTail();
        c.print();

    }

}