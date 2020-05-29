package linkedlist.doublylinkedlist;

import linkedlist.list.MySecondList;

/**
 * DoublyLinkedList
 */
public class MyDoublyLinkedList implements MySecondList {
    private static class Node {
        Node next;
        Node prev;
        int data;

        public Node(int data) {
            this.next = null;
            this.prev = null;
            this.data = data;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public MyDoublyLinkedList() {
        super();
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void prepend(int data) {
        var node = new Node(data);

        if (isEmpty()) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
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

    @Override
    public void append(int data) {
        var node = new Node(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public int removeHead() {
        if (!isEmpty()) {
            int temp = head.data;
            if (head == tail) {
                head = tail = null;
            } else {

                head = head.next;
                head.prev = null;

            }
            size--;
            return temp;
        }
        return -1;
    }

    @Override
    public int removeTail() {
        if (!isEmpty()) {
            int temp = tail.data;
            if (head == tail) {
                head = tail = null;
            } else {
                var prev = tail.prev;
                tail.prev.next = null;
                tail.prev = null;
                tail = prev;
            }
            size--;
            return temp;
        }
        return -1;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size) {
            return -1;

        } else if (!isEmpty()) {

            if (index == 0) {

                return removeHead();
            } else if (index == size - 1) {

                return removeTail();
            } else {
                var temp = head;

                while (index-- != 0) {
                    temp = temp.next;

                }
                var deleted = temp.data;

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;

                temp.prev = null;
                temp.next = null;

                size--;
                return deleted;
            }
        }

        return -1;
    }

    @Override
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

            while (index-- != 0) {
                temp = temp.next;

            }

            temp.prev.next = node;
            node.next = temp;
            node.prev = temp.prev;

        }

        size++;
    }

    @Override
    public boolean isEmpty() {

        return head == null;
    }

    @Override
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

    public void printReverse() {
        if (tail == null) {
            System.out.println("[]");
            return;
        }
        var temp = tail;
        while (temp != null) {

            if (temp == head) {
                System.out.println(temp.data);
            } else {
                System.out.print(temp.data + " --> ");
            }

            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        var l = new MyDoublyLinkedList();

        l.print();
        l.append(1);
        l.append(2);
        l.append(3);

        l.print();

        System.out.println(l.find(3));
    }
}