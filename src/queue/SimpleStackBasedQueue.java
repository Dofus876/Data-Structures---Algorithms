package queue;

import java.util.Stack;

/**
 * Lớp này triển khai một hàng đợi (Queue) bằng cách sử dụng hai ngăn xếp (Stack).
 * Hành vi FIFO (First-In, First-Out) được mô phỏng bằng hai cấu trúc LIFO (Last-In, First-Out).
 */
public class SimpleStackBasedQueue {
    private Stack<Integer> stackIn;  // Nơi các phần tử mới được thêm vào
    private Stack<Integer> stackOut; // Nơi các phần tử được lấy ra

    /**
     * Hàm khởi tạo.
     */
    public SimpleStackBasedQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * Thêm một phần tử vào cuối hàng đợi.
     * @param item Phần tử cần thêm.
     */
    public void enqueue(int item) {
        stackIn.push(item);
    }

    /**
     * Lấy và xóa phần tử ở đầu hàng đợi.
     * @return Phần tử ở đầu hàng đợi.
     * @throws RuntimeException nếu hàng đợi rỗng.
     */
    public int dequeue() {
        // Nếu cả hai stack đều rỗng, không có gì để lấy ra
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Nếu stackOut rỗng, chuyển tất cả phần tử từ stackIn sang để đảo ngược thứ tự
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        // Bây giờ phần tử trên cùng của stackOut chính là phần tử đầu hàng đợi
        return stackOut.pop();
    }

    /**
     * Kiểm tra xem hàng đợi có rỗng hay không.
     * @return true nếu hàng đợi rỗng, ngược lại là false.
     */
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    /**
     * Trả về số lượng phần tử hiện có trong hàng đợi.
     * @return Số phần tử trong hàng đợi.
     */
    public int size() {
        return stackIn.size() + stackOut.size();
    }

    /**
     * Trả về một chuỗi biểu diễn trạng thái của hàng đợi từ đầu đến cuối.
     * Ví dụ: "[1 -> 2 -> 3]"
     * @return Chuỗi biểu diễn hàng đợi.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        // Duyệt stackOut từ đỉnh xuống đáy (đầu hàng đợi)
        for (int i = stackOut.size() - 1; i >= 0; i--) {
            sb.append(stackOut.get(i));
            // Thêm dấu "->" nếu đây không phải là phần tử cuối cùng
            if (i > 0 || !stackIn.isEmpty()) {
                sb.append(" -> ");
            }
        }

        // Duyệt stackIn từ đáy lên đỉnh (cuối hàng đợi)
        for (int i = 0; i < stackIn.size(); i++) {
            sb.append(stackIn.get(i));
            // Thêm dấu "->" nếu đây không phải là phần tử cuối cùng
            if (i < stackIn.size() - 1) {
                sb.append(" -> ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}