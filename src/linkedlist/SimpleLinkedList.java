package linkedlist;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    /**
     * Thêm phần tử mới vào cuối danh sách
     * @param data phần tử cần thêm
     */
    public void add(T data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
    }

    /**
     * Thêm phần tử vào vị trí chỉ định (0-based)
     * @param index vị trí cần thêm (0 ≤ index ≤ size)
     * @param data phần tử cần thêm
     */
    public void addAt(int index, T data) {
        if (0 <= index && index <= size) {
            Node newNode = new Node(data);
            Node currentNode = head;
            
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            size++;
        }
    }

    /**
     * Lấy phần tử tại vị trí index (0-based)
     * @param index vị trí cần lấy
     * @return phần tử tại vị trí index
     */
    public T get(int index) {
        Node currentNode = head;
        if (index == 0) return currentNode.data;
        if (0 <= index && index <= size) {
            while (currentNode != null && index > 0) {
                currentNode = currentNode.next;
                index--;
            }
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    /**
     * Gán giá trị mới cho phần tử tại vị trí index
     * @param index vị trí cần gán
     * @param data giá trị mới
     */
    public void set(int index, T data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        if (0 <= index && index <= size) {
            while (currentNode != null && index > 0) {
                currentNode = currentNode.next;
                index--;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    /**
     * Xóa phần tử tại vị trí index
     * @param index vị trí cần xóa
     */
    public void remove(int index) {
        Node currentNode = head;
        if (0 <= index && index <= size) {
            while (currentNode != null && index > 0) {
                currentNode = currentNode.next;
                index--;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    /**
     * Trả về số phần tử trong danh sách
     * @return số lượng phần tử
     */
    public int size() {
        return size;
    }

    /**
     * Kiểm tra danh sách có rỗng hay không
     * @return true nếu rỗng, false nếu có phần tử
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Kiểm tra xem danh sách có chứa phần tử cụ thể không
     * @param data phần tử cần kiểm tra
     * @return true nếu có, false nếu không
     */
    public boolean contains(T data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.data == newNode.data) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Tìm vị trí (index) đầu tiên của phần tử trong danh sách
     * @param data phần tử cần tìm
     * @return vị trí nếu tìm thấy, -1 nếu không có
     */
    public int indexOf(T data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.data == newNode.data) return i;
            currentNode = currentNode.next;
        }
        return -1;
    }

    /**
     * Xóa toàn bộ danh sách, đưa về trạng thái rỗng
     */
    public void clear() {
        head = null;
    }

    /**
     * Trả về chuỗi biểu diễn danh sách liên kết, dùng để in ra
     * @return chuỗi dạng [a, b, c]
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.data);
            if (node.next != null) stringBuilder.append(", ");
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
