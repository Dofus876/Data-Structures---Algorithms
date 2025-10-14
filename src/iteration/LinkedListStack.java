package iteration;

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

// Interface Stack (dùng chung cho cả ArrayStack và LinkedListStack)
interface Stack<E> extends Iterable<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}

// Lớp LinkedListStack hoàn chỉnh và mạnh mẽ
public class LinkedListStack<E> implements Stack<E> {

    // Lớp Node nên là 'static' vì nó không cần truy cập vào instance của LinkedListStack
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    private Node<E> top = null;
    private int size = 0;

    // Biến đếm số lần thay đổi cấu trúc của stack
    private int modCount = 0;

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>();
        newNode.item = element;
        newNode.next = top;
        top = newNode;
        size++;
        modCount++; // Tăng biến đếm khi có thay đổi
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        E item = top.item;
        top = top.next; // GC sẽ tự động dọn dẹp node cũ
        size--;
        modCount++; // Tăng biến đếm khi có thay đổi
        return item;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.item;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator();
    }

    // --- Lớp nội tại Iterator với cơ chế Fail-Fast ---
    private class LinkedListStackIterator implements Iterator<E> {
        private Node<E> current = top;

        // Lưu lại số lần thay đổi tại thời điểm iterator được tạo ra
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            // Kiểm tra trước khi duyệt
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }
    }
}