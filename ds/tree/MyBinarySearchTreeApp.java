package ds.tree;

public class MyBinarySearchTreeApp {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();

        bst.insert(12, 12);
        bst.insert(1, 1);
        bst.insert(0, 0);
        bst.insert(13, 13);
        bst.insert(14, 14);
        bst.insert(15, 15);
        bst.insert(16, 16);
        bst.insert(17, 17);

        bst.delete(0);
        bst.delete(13);

        bst.printInOrder();

    }
}