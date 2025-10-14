package stack;

public class SimpleArrayStack<T> implements SimpleStack<T> {
    private Object[] elements;
    private int top;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public SimpleArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
        top = -1;
        size = 0;
    }

    /**
     * Thêm một phần tử vào đỉnh ngăn xếp.
     * @param item phần tử cần thêm
     */
    @Override
    public void push(T item) {
        if (size >= elements.length) {
            enlarge();
        }
        top++;
        elements[top] = item;
        size++;
    }

    /**
     * Lấy và loại bỏ phần tử ở đỉnh ngăn xếp.
     * @return phần tử ở đỉnh ngăn xếp, hoặc null nếu ngăn xếp rỗng
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T element = (T) elements[top];
        top--;
        size--;
        return element;
    }

    /**
     * Trả về số lượng phần tử hiện có trong ngăn xếp.
     * @return số lượng phần tử trong ngăn xếp
     */
    public int size() {
        return size;
    }

    /**
     * Kiểm tra xem ngăn xếp có rỗng hay không.
     * @return true nếu ngăn xếp rỗng, false nếu không
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Trả về chuỗi mô tả các phần tử trong ngăn xếp từ đỉnh xuống đáy.
     * @return chuỗi thể hiện trạng thái hiện tại của ngăn xếp
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top; i >= 0; i--) {
            sb.append(elements[i]);
            if (i > 0) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Tăng gấp đôi kích thước mảng khi ngăn xếp đầy.
     */
    private void enlarge() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}