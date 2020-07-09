package ds.queue;

public class QueueApp {
    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println("is empty: " + queue.isEmpty());
        System.out.println(queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

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