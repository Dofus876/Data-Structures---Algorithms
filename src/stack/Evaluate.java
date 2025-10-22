package stack;

import java.util.Stack;

public class Evaluate {

    /**
     * Tính giá trị biểu thức số học có ngoặc () và các phép toán + - * /.
     * Giả định: mỗi ký tự (số, toán tử, ngoặc) được cách nhau bởi 1 dấu cách.
     * @param expression biểu thức cần tính
     * @return giá trị biểu thức
     */
    public double evaluate(String expression) {
        double value = 0;
        String[] tokens = expression.trim().split("\\s+");
        Stack<Double> values = new Stack<>();
        Stack<String> operator = new Stack<>();
        for (String token : tokens) {
            if (token.matches("(-?\\d+(\\.\\d+)?)")) { // regex for numbers
                values.push(Double.parseDouble(token));
            }

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                operator.push(token);
            }

            if (token.equals(")")) {
                if (operator.isEmpty()) {
                    return value;
                }
                String ope = operator.pop();
                double b = values.pop();
                double a = values.pop();
                values.push(applyOperator(a, b, ope));
            }
        }
        return value;
    }

    public double applyOperator(double a, double b, String str) {
        switch(str) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default:
                return 0.0;
        }
    }
}
