package linkedlist;

public class MyLinkedListApp {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println(list);
        list.printReversed();

    }
}