package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Q_226_Invert_Binary_Tree {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(4);
        btree.root.left = new TreeNode(2);
        btree.root.right = new TreeNode(7);
        btree.root.left.left = new TreeNode(1);
        btree.root.left.right = new TreeNode(3);
        btree.root.right.left = new TreeNode(6);
        btree.root.right.right = new TreeNode(9);

        invertTree(btree.root);

        invertTree2(btree.root);


        btree.levelOrder(btree.root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Swap nodes
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add left and right of this node to the queue
            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        return root;
    }
}
