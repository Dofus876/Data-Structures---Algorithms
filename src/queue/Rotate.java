package queue;

import java.util.*;

public class Rotate {

    /**
     * Dịch chuyển phần tử đầu tiên của queue xuống cuối queue, thực hiện k lần.
     * @param a mảng số nguyên đầu vào dùng để khởi tạo queue
     * @param n số lượng phần tử của mảng (độ dài queue ban đầu)
     * @param k số lần thực hiện phép biến đổi dịch chuyển
     * @return Queue sau khi đã xoay (rotate) k lần
     */
    public Queue<Integer> rotate(int a[], int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        // 1. Sử dụng tham số 'n' để giới hạn số phần tử nạp vào queue
        for (int i = 0; i < n && i < a.length; i++) {
            queue.offer(a[i]);
        }
        
        // Tránh trường hợp n = 0 gây lỗi chia cho 0
        if (n == 0) {
            return queue;
        }

        // 2. Tối ưu hóa số lần xoay
        int rotationCount = k % n;
        
        for (int i = 0; i < rotationCount; i++) {
            // Lấy phần tử đầu và chuyển nó xuống cuối
            queue.offer(queue.poll());
        }
        
        return queue;
    }
}
