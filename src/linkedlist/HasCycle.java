package linkedlist;

public class HasCycle {
    public static class Node {
        int data;
        Node next;
        Node(){}
    }

    /**
     * Kiểm tra xem cấu trúc liên kết có chứa chu trình không
     * @param head: Nút đầu của cấu trúc liên kết
     * @return true nếu có chu trình, false nếu trái lại
     *
     * 1 -> 2 -> 3 -> 4 -> 5 -> 2 : Có chu kỳ (5 bị nối lại sang 2)
     * 1 -> 2 -> 3 -> 4 -> 5 : Không có chu kỳ
     * Gợi ý: Dùng hai con trỏ, một đi từng bước và một đi hai bước,
     * nếu chúng gặp nhau thì danh sách có chu kỳ, còn nếu con trỏ nhanh tới null thì không có chu kỳ.
     */
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
