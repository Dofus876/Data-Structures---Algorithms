package tree;

import java.util.LinkedList;
@SuppressWarnings({})
public class CheckLevel {
    LinkedList<Integer> list = new LinkedList<>();
    public boolean isSameLevel(Node root, int val1, int val2) {
        if (val1 == val2) return true;
        return level(root, val1, 0) == level(root, val2, 0) && level(root, val1, 0) != 0;
    }

    public int level(Node root, int val, int level) {
        if (root == null) {
            return -1;
        }
        if (root.value == val) {
            return level;
        }
        int levels = level(root.left, val, level + 1);
        if (levels != -1) return levels;
        return level(root.right, val, level + 1);
    }
}
