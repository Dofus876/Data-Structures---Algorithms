package stack;

import java.util.Stack;

public class Expression {

    Stack<Character> stk = new Stack<>();

    public boolean isValidExpr(String expr) {

        for (int i = 0; i < expr.length(); i++) {
            if ('(' == expr.charAt(i)) {
                stk.push(expr.charAt(i));
            }

            if (')' == expr.charAt(i)) {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    stk.pop();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));

    }
}