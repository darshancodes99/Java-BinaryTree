package LeetCode;

public class Q_938 {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(10);
        btree.root.left = new TreeNode(5);
        btree.root.right = new TreeNode(15);
        btree.root.left.left = new TreeNode(3);
        btree.root.left.right = new TreeNode(7);
        btree.root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(btree.root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0; // base case.
        if (root.data < L)
            return rangeSumBST(root.right, L, R); // left branch excluded.
        if (root.data > R)
            return rangeSumBST(root.left, L, R); // right branch excluded.
        return root.data + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); // count in both children.
    }
}
