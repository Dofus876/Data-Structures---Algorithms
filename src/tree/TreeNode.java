package tree;

public class TreeNode {
    int val;    
    TreeNode left;  
    TreeNode right; 

    // Constructor mặc định
    public TreeNode() {
    }

    // Constructor để tạo một nút với một giá trị cụ thể
    public TreeNode(int val) {
        this.val = val;
    }

    // Constructor đầy đủ để tạo một nút với giá trị và các nút con
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}