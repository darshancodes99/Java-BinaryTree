package LeetCode;

public class Q_100_same_tree {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(1);
        btree.root.left = new TreeNode(2);
        btree.root.right = new TreeNode(3);

        Btree btree1 = new Btree();
        btree1.root = new TreeNode(1);
        btree1.root.left = new TreeNode(2);
        btree1.root.right = new TreeNode(3);

        System.out.println(isSameTree(btree.root, btree1.root));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.data != q.data) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
