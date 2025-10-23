package stack;

import java.util.Stack;

/**
 * Hàm tìm độ dài của chuỗi con ngoặc đúng dài nhất trong chuỗi đầu vào.
 *
 * @param s Chuỗi đầu vào, chỉ bao gồm hai ký tự '(' và ')'.
 * @return Độ dài lớn nhất của một đoạn ngoặc đúng liên tiếp trong chuỗi.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Mốc cơ sở ban đầu

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else { // c == ')'
                stack.pop();
                if (stack.isEmpty()) {
                    // Dấu ')' này không hợp lệ, nó trở thành mốc cơ sở mới
                    stack.push(i);
                } else {
                    // Tính độ dài từ chỉ số hiện tại đến mốc trên đỉnh stack
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()((((())"));
    }
}
