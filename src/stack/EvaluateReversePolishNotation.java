package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * Tính giá trị biểu thức được viết dưới dạng hậu tố
     * @param expression biểu thức hậu tố cần tính
     * @return giá trị biểu thức
     */
    public int evaluateReversePolishNotation(String expression) {
        int value = 0;
        String[] tokens = expression.trim().split("\\s+");
        Stack<Integer> values = new Stack<>();

        for (String token : tokens) {
            if (token.matches("-?\\d+")) { // regex for integers
                values.push(Integer.parseInt(token));
            }

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = values.pop();
                int a = values.pop();
                value = applyOperator(a, b, token);
                values.push(value);
            }
        }
        return value;
    }

    public int applyOperator(int a, int b, String str) {
        switch(str) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default:
                return 0;
        }
    }
}
