package stack;

public class Stack<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node stack = null;
    private int size = 0;

    public void push(E element) {
        Node newNode = new Node(element);
        newNode.next = stack;
        stack = newNode;
        size++;
    }

    // Lấy phần tử ra khỏi stack
    public E pop() {
        if (isEmpty()) {
        throw new IllegalStateException("Stack is empty");
        }

        E element = stack.element;
        stack = stack.next;
        size--;
        return element; 
    }

    // Xem phần tử trên đỉnh
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        
        E element = stack.element;
        return element;
    }

    // Kiểm tra stack có rỗng không
    public boolean isEmpty() {
        return size == 0;
    }

    // Trả về số lượng phần tử hiện có
    public int size() {
        /*TO DO*/
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node node = stack;
        while (node != null) {
            stringBuilder.append(node.element);
            if (node.next != null) stringBuilder.append(", ");
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
