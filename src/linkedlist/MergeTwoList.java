package linkedlist;

public class MergeTwoList {
    class Node {
        int data;
        Node next;
    }
    
    /**
     * Gộp hai danh sách liên kết đã được sắp xếp thành duy nhất một danh sách mới được sắp xếp
     * @param head1: Nút đầu danh sách thứ nhất
     * @param head2: Nút đầu danh sách thứ hai
     * @return Nút đầu danh sách mới đã được gộp và sắp xếp
     */
    public Node mergeTwoLists(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node newNode = null;
        if (head1.data < head2.data) {
            newNode = head1;
            head1 = head1.next;
        } else {
            newNode = head2;
            head2 = head2.next;
        }

        Node next = newNode;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                next.next = head1;
                head1 = head1.next;
            } else {
                next.next = head2;
                head2 = head2.next;
            }
            next = next.next;
        }

        if (head1 == null) {
            next.next = head2;
        } else {
            next.next = head1;
        }

        return newNode;
    }
}
