package linkedlist;

public class LinkedListApp {

    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();

        list.append(1);
        list.append(2);
        list.append(3);

        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list.remove(2));
        System.out.println(list.remove(3));

        list.append(2);
        list.popLast();

        System.out.println(list);
    }
}