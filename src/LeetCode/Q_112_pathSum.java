package LeetCode;

public class Q_112_pathSum {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(5);
        btree.root.left = new TreeNode(4);
        btree.root.right = new TreeNode(8);
        btree.root.left.left = new TreeNode(11);
        btree.root.left.left.right = new TreeNode(2);
        btree.root.left.left.left = new TreeNode(7);
        btree.root.right.left = new TreeNode(13);
        btree.root.right.right = new TreeNode(4);
        btree.root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(btree.root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.data;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.data);
        boolean rightSum = hasPathSum(root.right, targetSum - root.data);

        return leftSum || rightSum;
    }
}
