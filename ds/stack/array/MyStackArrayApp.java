package ds.stack.array;

public class MyStackArrayApp {
    public static void main(String[] args) {

        MyStackArray<Integer> stack = new MyStackArray<>(4);

        System.out.println("is empty: " + stack.isEmpty());
        System.out.println(stack.pop());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("size: " + stack.size());

        System.out.println("stack: " + stack);
        System.out.println("is empty: " + stack.isEmpty());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
        System.out.println("size: " + stack.size());

        System.out.println("stack: " + stack);

        System.out.println("reverse giiib" + "\nresult: " + reverse("giiib"));

        System.out.println("reverse: \n" + reverse(" "));

    }

    public static String reverse(String str) {

        if (str == null || str.isEmpty() || str.isBlank()) {
            return "value is empty";
        }
        MyStackArray<Character> stack = new MyStackArray<>();
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
