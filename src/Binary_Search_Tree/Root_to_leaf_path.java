package Binary_Search_Tree;

import java.util.ArrayList;

public class Root_to_leaf_path {
    public static void main(String[] args) {
        BinaryST binaryST = new BinaryST();
        binaryST.root = new Node(5);
        binaryST.root.left = new Node(4);
        binaryST.root.right = new Node(8);
        binaryST.root.left.left = new Node(11);
        binaryST.root.left.left.left = new Node(7);
        binaryST.root.left.left.right = new Node(2);
        binaryST.root.right.left = new Node(13);
        binaryST.root.right.right = new Node(4);
        binaryST.root.right.right.right = new Node(1);

        printRootToLeavePatyh(binaryST.root, new ArrayList<>());

        System.out.println(printRootToLeavePathSum(binaryST.root,new ArrayList<>(), 22));

        System.out.println(hasPathSum(binaryST.root, 22));

    }

    public static void printRootToLeavePatyh(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.val);

        if (root.left == null && root.right == null){
            printPath(path);
        }
        printRootToLeavePatyh(root.left, path);
        printRootToLeavePatyh(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean printRootToLeavePathSum(Node root,ArrayList<Integer> path, int target){
        if (root == null){
            return false;
        }

        path.add(root.val);
        if (root.left == null && root.right == null){
            if (sumPath(path) == target){
                return true;
            }
        }

        if (printRootToLeavePathSum(root.left, path, target) || printRootToLeavePathSum(root.right, path, target)){
            return true;
        }

        path.remove(path.size() - 1);

      return  false;

    }

    private static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    private static int sumPath(ArrayList<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
       return sum;
    }


    // 0(1) space
    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);

        return leftSum || rightSum;
    }
}
