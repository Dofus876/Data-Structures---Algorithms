package iteration;

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;


public class MyArrayStack<E> implements MyStack<E> {

    private E[] stack;
    private int top = 0;
    
    // Biến đếm số lần thay đổi cấu trúc của stack
    private int modCount = 0;

    public MyArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        stack = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        if (top == stack.length) {
            // Có thể cài đặt tự động tăng kích thước mảng ở đây
            throw new IllegalStateException("Stack is full.");
        }
        stack[top++] = element;
        modCount++; // Tăng biến đếm khi có thay đổi
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        E element = stack[--top];
        stack[top] = null; // Giúp trình dọn rác (Garbage Collector)
        modCount++; // Tăng biến đếm khi có thay đổi
        return element;
    }
    
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public MyIterator<E> iterator() {
        return new ArrayStackIterator();
    }

    // --- Lớp nội tại Iterator với cơ chế Fail-Fast ---
    private class ArrayStackIterator implements MyIterator<E> {
        private int i = top;
        
        // Lưu lại số lần thay đổi tại thời điểm iterator được tạo ra
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            // Trước khi kiểm tra, xem stack có bị thay đổi từ bên ngoài không
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return i > 0;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }
    }
}