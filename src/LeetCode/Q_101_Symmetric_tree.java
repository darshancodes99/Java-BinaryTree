package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Q_101_Symmetric_tree {
    public static void main(String[] args) {
        Btree btree = new Btree();
        btree.root = new TreeNode(1);
        btree.root.left= new TreeNode(2);
        btree.root.right= new TreeNode(2);
        btree.root.left.left= new TreeNode(3);
        btree.root.left.right= new TreeNode(4);
        btree.root.right.left= new TreeNode(4);
        btree.root.right.right= new TreeNode(3);

        System.out.println(isSymmetric(btree.root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){
            TreeNode currLeft = queue.poll();
            TreeNode currRight = queue.poll();
            
            if (currLeft == null && currRight == null){
                continue;
            } else if (currLeft == null || currRight == null || currLeft.data != currRight.data) {
                return false;
            }

            queue.add(currLeft.left);
            queue.add(currRight.right);
            queue.add(currLeft.right);
            queue.add(currRight.left);
        }

        return true;


    }
}
