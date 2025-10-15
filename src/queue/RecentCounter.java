package queue;

import java.util.*;

class RecentCounter {

    Queue<Integer> recentCalls;

    public RecentCounter() {
        recentCalls = new LinkedList<Integer>();
    }

    /**
     * Thêm thời cuộc gọi tại thời điểm t và xóa các cuộc gọi đã quá 3000 ms trong recentCalls, trả về số cuộc gọi trong khoảng 3000ms
     * @param t thời điểm của cuộc gọi hiện tại
     * @return số cuộc gọi trong khoảng 3000ms tính cả cuộc gọi vừa thêm
     */
    public int ping(int t) {
        recentCalls.offer(t);
        if (recentCalls.size() == 1) return 1;
        while (recentCalls.peek() < t - 3000) {
            recentCalls.poll();
        }
        return recentCalls.size();
    }
}