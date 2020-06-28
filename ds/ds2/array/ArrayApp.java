package ds.ds2.array;

public class ArrayApp {

    public static void main(String[] args) {
        var a = new Array<Integer>(15);

        System.out.println("capacity " + a.capacity());
        a.prepend(232);
        a.prepend(1);
        a.prepend(2);
        a.prepend(2);
        a.prepend(2);
        a.prepend(2);
        a.prepend(2);
        a.remove(2);

        System.out.println(a);
        System.out.println("capacity " + a.capacity());
        System.out.println("size " + a.size());
        System.out.println(a.get(0));

    }

}