import java.util.Stack;

public class PrefixToPostfix {
    private static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();
        int length = prefix.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = op1 + op2 + c;
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixExp = "*-A/BC-/AKL";
        System.out.println("Postfix : " + convert(prefixExp));
    }
}
