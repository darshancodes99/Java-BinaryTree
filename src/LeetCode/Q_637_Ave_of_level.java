package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_637_Ave_of_level {
    public static void main(String[] args) {
        Btree binaryTree1 = new Btree();
        binaryTree1.root = new TreeNode(3);
        binaryTree1.root.left = new TreeNode(9);
        binaryTree1.root.right = new TreeNode(20);
        binaryTree1.root.right.left = new TreeNode(15);
        binaryTree1.root.right.right = new TreeNode(7);

        System.out.println( averageOfLevels(binaryTree1.root));

        System.out.println(averageOfLevelsAp2(binaryTree1.root));


    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        double sum = 0;
        double ave;
        int count = 0;
        List<Double> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null){
                ave = sum / count;
               list.add(ave);
               if (queue.isEmpty()){
                   break;
               } else {
                   queue.add(null);
               }
               sum = 0;
               count = 0;
            } else {
                sum += curr.data;
                count++;
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
        }

        return list;
    }

    public static List<Double> averageOfLevelsAp2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            int resizer = size;
            double sum = 0;
            while (resizer > 0){
                TreeNode curr = queue.poll();
                sum += curr.data;
                resizer--;

                if (resizer == 0){
                    list.add(sum / size);
                }
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
        }

        return list;
    }
}
