package ds.queue.array;

public class MyQueueArrayApp {
    public static void main(String[] args) {

        MyQueueArray<Integer> queue = new MyQueueArray<>();

        System.out.println("is empty: " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("size: " + queue.size());

        System.out.println("queue: " + queue);

        System.out.println("is empty: " + queue.isEmpty());
        System.out.println("remove: " + queue.dequeue());

        System.out.println("remove: " + queue.dequeue());
        System.out.println("peek: " + queue.peek());
        System.out.println("size: " + queue.size());

        System.out.println("queue: " + queue);

    }

}