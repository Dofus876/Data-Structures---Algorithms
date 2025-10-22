package tree;
@SuppressWarnings({})
class SumNumbersTest {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return sumNode(root, sum);
    }

    public int sumNode(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNode(root.left, sum) + sumNode(root.right, sum);
    }
}