package linkedlist;

public class DeleteDuplicates {
    class Node {
		int data;
		Node next;
	}
	
    /**
     * Xóa các phần tử trùng lặp trong sanh sách liên kết
     * @param head: Nút đầu của danh sách liên kết đã được sắp xếp
     * @return nút đầu mới của danh sách đã được xóa các phần tử trùng lặp
     */
    public Node deleteDuplicates(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
