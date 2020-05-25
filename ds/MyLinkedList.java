
public class MyLinkedList<T> implements MyList<T> {

    private static class Node<T> {
        private Node<T> next;
        private T data;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private String dataString() {
            return "[" + data + "] -> ";

        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        super();
        this.head = null;
        this.tail = head;
        this.size = 0;

    }

    @Override
    public void addFront(T data) {
        var node = new Node<>(data);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public T peekFront() {

        isEmptyException();
        return head.data;
    }

    private void isEmptyException() {

        if (isEmpty()) {
            try {
                throw new Exception("The list is Empty");
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    @Override
    public T popFront() {
        isEmptyException();

        T delete = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;

        }
        size--;
        return delete;
    }

    @Override
    public void append(T data) {
        var node = new Node<>(data);

        if (isEmpty()) {
            head = tail = node;

        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T peekLast() {

        isEmptyException();

        if (tail == head) {
            return head.data;
        }
        return tail.data;
    }

    @Override
    public T popLast() {

        isEmptyException();

        T delete = tail.data;

        if (head == tail) {
            head = tail = null;

        } else {
            var temp = head;
            Node<T> prev = null;

            while (temp.next != null) {

                prev = temp;
                temp = temp.next;
            }

            prev.next = null;
            tail = prev;
        }
        size--;
        return delete;
    }

    private boolean nodeExist(T data) {
        if (isEmpty()) {
            isEmptyException();
        }

        var temp = head;

        while (temp != null) {
            if (temp == tail) {
                return true;

            } else if (temp.data == data) {

                return true;
            }

            temp = temp.next;

        }

        return false;
    }

    @Override
    public boolean find(T data) {

        isEmptyException();

        var temp = head;
        int count = 0;
        boolean found = false;

        while (temp != null) {
            if (temp == tail) {
                return true;

            } else if (temp.data == data) {
                count++;
                found = true;
            }
            temp = temp.next;

        }

        if (count > 1 && found == true) {

            System.out.println("found the value " + data + " : " + count + " times");
            return true;

        } else if (found == true) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {

        return head == null;
    }

    @Override
    public void addBefore(T current, T data) {

        if (isEmpty() || nodeExist(current) && head == tail || nodeExist(current) && current == head.data) {
            addFront(data);

        } else if (nodeExist(current)) {

            var node = new Node<>(data);
            var temp = previousNode(current);

            node.next = temp.next;
            temp.next = node;

            size++;

        }

        else {
            System.out.println("the element to add before does not exist");
        }

    }

    @Override
    public void addAfter(T current, T data) {

        if (isEmpty() || nodeExist(current) && head == tail || nodeExist(current) && current == tail.data) {
            append(data);

        } else if (nodeExist(current)) {

            var node = new Node<>(data);
            var temp = findCurrentNode(current);

            node.next = temp.next;
            temp.next = node;

            size++;

        }

        else {
            System.out.println("the element to add after does not exist");
        }

    }

    private Node<T> findCurrentNode(T current) {

        var temp = head;

        while (temp != null) {
            if (temp.data == current) {
                return temp;
            }
            temp = temp.next;
        }

        return null;

    }

    private Node<T> previousNode(T current) {

        var temp = head;

        while (temp != null) {

            if (temp.next.data == current) {
                return temp;
            }
            temp = temp.next;
        }

        return null;

    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        var temp = head;

        StringBuilder sb = printNode(temp);

        return sb.toString();
    }

    private StringBuilder printNode(Node<T> temp) {

        StringBuilder sb = new StringBuilder();

        while (temp != null) {
            if (temp == tail) {
                sb.append("[" + temp.data + "]");
            } else if (temp == head && temp.next == null) {
                sb.append("[" + temp.data + "]");
            } else {
                sb.append(temp.dataString());
            }

            temp = temp.next;
        }
        return sb;
    }

    private Node<T> reverse() {
        Node<T> temp = head;
        Node<T> prev = null;

        Node<T> next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;

    }

    public void printReversed() {
        var temp = reverse();

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;

        }

    }

    @Override
    public T remove(T data) {
        isEmptyException();

        if (nodeExist(data)) {
            var delete = data;
            if (data == head.data) {
                return popFront();
            }
            if (data == tail.data) {
                return popLast();
            }
            var prev = previousNode(data);
            prev.next = prev.next.next;
            return delete;
        }
        return null;
    }

}
