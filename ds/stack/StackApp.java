package ds.stack;

public class StackApp {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        System.out.println("is empty: " + stack.isEmpty());
        System.out.println(stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("size: " + stack.size());

        System.out.println("stack: " + stack);
        System.out.println("is empty: " + stack.isEmpty());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
        System.out.println("size: " + stack.size());

        System.out.println("stack: " + stack);

        System.out.println("reverse dylan" + "\nresult: " + reverse("dylan"));

        System.out.println("reverse:   \n" + reverse(" "));

    }

    public static String reverse(String str) {

        if (str == null || str.isEmpty() || str.isBlank()) {
            return "value is empty";
        }
        MyStack<Character> stack = new MyStack<>();
        StringBuilder result = new StringBuilder();
        for (Character ch : str.toCharArray()) {
            stack.push(ch);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}