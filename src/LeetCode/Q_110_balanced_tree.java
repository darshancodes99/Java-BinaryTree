package LeetCode;

public class Q_110_balanced_tree {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(3);
        btree.root.left= new TreeNode(9);
        btree.root.right= new TreeNode(20);
        btree.root.right.left= new TreeNode(15);
        btree.root.right.right= new TreeNode(7);

        System.out.println(isBalanced(btree.root));
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = checkHeight(root.left);
        int right = checkHeight(root.right);

        if(left == -1 || right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left , right) + 1;
    }
}
