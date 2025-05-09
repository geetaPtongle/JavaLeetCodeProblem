package stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
        String s="3[a2[c]]";
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                // Get the string inside brackets
                StringBuilder substr = new StringBuilder();
                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    if (top.equals("[")) {
                        break;
                    }
                    substr.insert(0, stack.pop());
                }
                stack.pop(); // remove the '['

                // Get the number (could be multiple digits)
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    if (!Character.isDigit(top.charAt(0))) break;
                    k.insert(0, stack.pop());
                    System.out.println(k);
                }

                int repeat = Integer.parseInt(k.toString());
                StringBuilder expanded = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    expanded.append(substr);
                }

                stack.push(expanded.toString());
            }
        }

        // Join everything in the stack to form the final result
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }

        return result.toString();
    }
}
