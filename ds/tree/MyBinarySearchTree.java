package tree;

public class MyBinarySearchTree<T> {

    private static class Node<T> {

        private T data;
        private int key;
        private Node<T> left;
        private Node<T> right;

        private Node(int key, T data) {
            this.key = key;
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {

            return "(key: " + key + ", data: " + data + ")";
        }
    }

    private Node<T> root;

    public MyBinarySearchTree() {
        super();
        this.root = null;

    }

    public void delete(int key) {

        root = delete(root, key);

    }

    private Node<T> delete(Node<T> root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {

                root = root.right;

            } else if (root.right == null) {

                root = root.left;

            } else {
                var temp = findMin(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);

            }
        }
        return root;
    }

    private Node<T> findMin(Node<T> root) {

        if (root.left != null) {
            return findMin(root.left);
        }
        return root;
    }

    public void insert(int key, T data) {
        root = insert(root, key, data);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printInOrder(Node<T> root) {
        if (root != null) {

            printInOrder(root.left);
            System.out.println(root);
            printInOrder(root.right);

        }

    }

    private Node<T> insert(Node<T> root, int key, T data) {
        if (root == null) {

            root = new Node<T>(key, data);
        } else if (key < root.key) {
            root.left = insert(root.left, key, data);
        } else {
            root.right = insert(root.right, key, data);
        }
        return root;
    }

    public void printPreOrder(Node<T> root) {
        if (root != null) {

            System.out.println(root);
            printInOrder(root.left);
            printInOrder(root.right);

        }
    }

    public void printPostOrder(Node<T> root) {
        if (root != null) {

            printInOrder(root.left);
            printInOrder(root.right);
            System.out.println(root);

        }
    }

}