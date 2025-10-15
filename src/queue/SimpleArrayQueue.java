package queue;

public class SimpleArrayQueue<T> implements MyQueue<T> {
    private Object[] elements;
    private int front;
    private int size;
    private static final int DEFAULT_CAPACITY = 2;

    public SimpleArrayQueue() {
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        size = 0;
    }

    /**
     * Thêm một phần tử vào cuối hàng đợi.
     * @param item phần tử cần thêm
     */
    @Override
    public void enqueue(T item) {
        if (size == elements.length) {
            enlarge(); // Lưu ý: phương thức enlarge() không được định nghĩa trong ảnh
        }
        int rearIndex = (front + size) % elements.length;
        elements[rearIndex] = item;
        size++;
    }

    /**
     * Lấy và loại bỏ phần tử ở đầu hàng đợi.
     * @return phần tử ở đầu hàng đợi, hoặc null nếu hàng đợi rỗng
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = (T) elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    
    @Override
    public T peek() {
        T element = (T) elements[front];
        return element;
    }

    /**
     * Trả về số lượng phần tử hiện có trong hàng đợi.
     * @return số lượng phần tử trong hàng đợi
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Kiểm tra xem hàng đợi có rỗng hay không.
     * @return true nếu hàng đợi rỗng, false nếu không
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Trả về chuỗi mô tả các phần tử trong hàng đợi từ đầu đến cuối.
     * @return Chuỗi thể hiện trạng thái hiện tại của hàng đợi
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            sb.append(elements[index]);
            if (i < size - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Tăng gấp đôi kích thước mảng khi hàng đợi đầy.
     * Sao chép các phần tử từ front theo thứ tự đúng vào mảng mới
     * và đặt front về 0 để dễ quản lý
     */
    private void enlarge() {
        Object[] newArray = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(front + i) % elements.length];
        }
        elements = newArray;
        front = 0; // Reset front về đầu mảng mới
    }
}