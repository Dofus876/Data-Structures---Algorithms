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
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E element = front.element;
        front = front.next;
        size--;
        if (front == null) rear = null;
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
        Node current = front;
        while (current != null) {
            stringBuilder.append(current.element);
            if (current.next != null) stringBuilder.append(", ");
            current = current.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
