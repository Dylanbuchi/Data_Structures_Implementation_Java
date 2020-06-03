package ds.linkedlist.integerlist;

import ds.linkedlist.list.MySecondList;

public class MyIntegerLinkedList implements MySecondList {
    private static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public MyIntegerLinkedList() {

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void prepend(int data) {
        var node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void append(int data) {
        var node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        var temp = head;
        while (temp != null) {

            if (temp == tail) {
                System.out.println(temp.data);
            } else {
                System.out.print(temp.data + " --> ");
            }

            temp = temp.next;
        }
    }

    public int removeHead() {

        if (!isEmpty()) {

            int delete = head.data;

            if (head == tail) {
                head = tail = null;

            } else {
                delete = head.data;
                head = head.next;

            }
            size--;
            return delete;

        }
        return -1;
    }

    public int removeTail() {

        if (!isEmpty()) {

            int deleted = tail.data;

            if (head == tail) {
                head = tail = null;
            } else {
                var prev = getPrevNodeOf(tail);
                prev.next = null;
                tail = prev;
            }
            size--;
            return deleted;
        }
        return -1;
    }

    private Node getPrevNodeOf(Node tail) {
        var prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        return prev;
    }

    public int remove(int data) {

        if (!isEmpty() && find(data)) {

            var temp = head;
            var prev = head;

            while (temp.data != data) {
                prev = temp;
                temp = temp.next;
            }
            if (temp.data == head.data) {

                return removeHead();

            } else if (temp.data == tail.data) {

                return removeTail();

            } else {

                prev.next = prev.next.next;
                size--;
                return temp.data;

            }

        }
        return -1;
    }

    public boolean find(int data) {
        if (!isEmpty()) {
            var temp = head;

            while (temp != null) {
                if (temp.data == data) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public void insert(int data, int index) {
        if (index == 0) {
            prepend(data);
            return;
        } else if (index < 0 || index >= size) {
            return;
        }
        var node = new Node(data);
        if (isEmpty()) {
            head = tail = node;

        } else {

            var temp = head;
            var prev = head;
            while (index-- != 0) {
                prev = temp;
                temp = temp.next;

            }

            node.next = temp;
            prev.next = node;
        }

        size++;
    }

}