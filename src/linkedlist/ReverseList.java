package linkedlist;

public class ReverseList{
    class Node {
		int data;
		Node next;
	}
	
    /**
     * Đảo ngược danh sách liên kết đơn
     * @param head: Nút đầu của danh sách
     * @return nút đầu mới của danh sách đã đảo ngược
     */
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next; 
            curr.next = prev;      
            prev = curr;          
            curr = next;           
        }
        return prev;
    }
}
