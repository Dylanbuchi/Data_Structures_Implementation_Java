public class App {

    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        // list2.append(1);
        // list2.append(2);
        // list2.append(3);

        // list2.printReversed();

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