package tree;
@SuppressWarnings({})
public class CheckSiblings {
    public boolean areSiblings(Node root, int val1, int val2) {
        return check(root, val1, val2);
    }
    
    public boolean check(Node root, int val1, int val2) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.right != null) {
            if ((root.left.value == val1 && root.right.value == val2) || (root.left.value == val2 && root.right.value == val1)) {
                return true;
            }
        }
        return check(root.right, val1, val2) || check(root.left, val1, val2);
    }
}