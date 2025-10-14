package queue;

import java.util.NoSuchElementException;

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
        if (count == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        int rearIndex = (front + count) % capacity;
        queue[rearIndex] = element;
        count++;
    }
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E element = queue[front];
        queue[front] = null; 
        front = (front + 1) % capacity; 
        count--;
        return element;
    }
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
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
