package stack;

public class App {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        System.out.println("is empty: " + stack.isEmpty());

        for (int i = 2; i <= 20; i *= 2) {
            stack.push(i);
        }

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