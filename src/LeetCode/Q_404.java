package LeetCode;

public class Q_404 {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(3);
        btree.root.left = new TreeNode(9);
        btree.root.right = new TreeNode(20);
        btree.root.right.left = new TreeNode(15);
        btree.root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(btree.root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;

        if(root.left != null && root.left.left == null && root.left.right == null){
            sum = sum + root.left.data;
        }

        sum = sum + sumOfLeftLeaves(root.left);
        sum = sum + sumOfLeftLeaves(root.right);

        return sum;
    }
}
