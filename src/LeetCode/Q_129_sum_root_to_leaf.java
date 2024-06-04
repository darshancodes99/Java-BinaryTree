package LeetCode;

public class Q_129_sum_root_to_leaf {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(1);
        btree.root.left= new TreeNode(2);
        btree.root.right = new TreeNode(3);

        System.out.println(sumNumbers(btree.root));
    }
    public static int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public static int sum(TreeNode root, int value){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return value * 10 + root.data;
        }

        return sum(root.left, value * 10 + root.data) + sum(root.right, value * 10 + root.data);
    }
}
