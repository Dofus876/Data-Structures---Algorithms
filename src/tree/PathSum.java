package tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root, targetSum);
    }

    public boolean check(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            return check(root.left, targetSum - root.val) || check(root.right, targetSum - root.val);
        }
    }
}