package queue;

public class Queue<E> {

    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void enqueue(E element) {
        Node newNode = new Node(element);
        newNode.next = rear;
        rear = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E element = front.element;
        front = front.next;
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (front != null) {
            stringBuilder.append(front.element);
            if (front.next != null) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
