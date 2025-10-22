package stack;

public interface SimpleStack<T> {
    void push(T item);
    T pop();
    int size();
    boolean isEmpty();
}