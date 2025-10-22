package iteration;

import java.util.NoSuchElementException;

public interface MyStack<E> extends MyIterable<E> {
    /**
     * Thêm một phần tử vào đỉnh của stack.
     */
    public void push(E element);
     /**
     * Lấy và xóa phần tử khỏi đỉnh của stack.
     * @throws NoSuchElementException nếu stack rỗng.
     */
    public E pop();
    /**
     * Lấy ra giá trị ở đỉnh Stack
     */
    public E peek();
    /**
     * Kiểm tra xem stack có rỗng không.
     */
    public boolean isEmpty();
    /**
     * Xem kích thước của stack.
     */
    public int size();
}
