package tree;

import java.util.*;
public class RightSideView {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        check(root, 0);
        return list;
    }

    public void check(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        check(root.right, level + 1);
        check(root.left, level + 1);
    }
}