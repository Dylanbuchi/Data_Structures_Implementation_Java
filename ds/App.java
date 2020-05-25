public class App {

    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        list.addFront(1);
        list.addFront(12);

        System.out.println(list);
    }

}