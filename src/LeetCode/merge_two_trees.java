package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class merge_two_trees {
    public static void main(String[] args) {
        Btree binaryTree1 = new Btree();
        binaryTree1.root = new TreeNode(1);
        binaryTree1.root.left = new TreeNode(3);
        binaryTree1.root.right = new TreeNode(2);
        binaryTree1.root.left.left = new TreeNode(5);

        Btree binaryTree2 = new Btree();
        binaryTree2.root = new TreeNode(2);
        binaryTree2.root.left = new TreeNode(1);
        binaryTree2.root.right = new TreeNode(3);
        binaryTree2.root.left.right = new TreeNode(4);
        binaryTree2.root.right.right = new TreeNode(7);

        mergeTrees(binaryTree1.root, binaryTree2.root);
        binaryTree1.levelOrder(binaryTree1.root);


    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()){
            TreeNode[] curr = queue.poll();
            TreeNode node1 = curr[0];
            TreeNode node2 = curr[1];

            node1.data += node2.data;
            if (node1.left != null && node2.left != null){
                queue.add(new TreeNode[]{node1.left, node2.left});
            } else if (node1.left == null) {
                node1.left = node2.left;
            }

            if (node1.right != null && node2.right != null){
                queue.add(new TreeNode[]{node1.right, node2.right});
            } else if (node1.right == null) {
                node1.right = node2.right;
            }

        }

        return root1;
    }



}
