package queue;

public class SimpleArrayQueue<E> implements Queue<E> {
    private E[] queue;
    private int capacity ;
    private int front = 0;
    private int count = 0;

    public SimpleArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) {
        if (count < capacity) {
            queue[(front + count) % capacity] = element;
            count++;
        }
    }
    @Override
    public E dequeue() {
        if (count > 0) {
            E element = queue[front];
            front++;
            count--;
            if (front == capacity) {
                front = 0;
            }
            return element;
        }
        return null;
    }
    @Override
    public E peek() {
        return queue[front];
    }
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    @Override
    public int size() {
        return count;
    }
}
