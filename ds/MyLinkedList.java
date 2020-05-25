
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
        this.tail = null;
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
        head = head.next;
        return delete;
    }

    @Override
    public void append(T data) {
        // TODO Auto-generated method stub

    }

    @Override
    public T peekLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T popLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean find(T data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {

        return head == null;
    }

    @Override
    public void addBefore(T current, T data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addAfter(T current, T data) {
        // TODO Auto-generated method stub

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

        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            if (temp == tail) {
                sb.append(temp.data);
            } else {
                sb.append(temp.dataString());
            }

            temp = temp.next;
        }

        return sb.toString();
    }

}