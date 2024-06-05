package Binary_Search_Tree;

public class BST {

    public static void main(String[] args) {
        BinaryST binaryST = new BinaryST();
        binaryST.insert(80);
        binaryST.insert(60);
        binaryST.insert(100);

        binaryST.printInOrder(binaryST.root);

        System.out.println(binaryST.searchNode(binaryST.root, 80));

        binaryST.delete(60);

        binaryST.insert(10);
        binaryST.insert(20);
        binaryST.insert(90);
        binaryST.insert(120);

        binaryST.delete(100);

        binaryST.printInOrder(binaryST.root);





        // create tree from array
        BinaryST binaryST1 = new BinaryST();

        int[] arr = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i : arr) {
            root = binaryST1.insert(root, i);
        }

        System.out.println();
        System.out.println("Create BST From Array");

        binaryST1.printInOrder(root);

        System.out.println(binaryST1.searchNode(root, 4));

    }





}

class BinaryST {
    Node root;

    public void insert(int value){
        root = insert(root, value);
    }

    public Node insert(Node root, int value){
        if (root == null){
            root = new Node(value);
            return root;
        }

        if (value < root.val){
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public int minValue(Node root){
        int min = root.val;
        while (root.left != null){
            min = root.left.val;
        }
        return min;
    }

    public void delete(int value){
        root = delete(root, value);
    }

    public Node delete(Node root, int value){
        if (root == null){
            return root;
        }

        if (value > root.val){
            root.right = delete(root.right, value);
        } else if (value < root.val) {
            root.left = delete(root.left, value);
        } else {
            if (root.left == null && root.right == null){
                return null;
            }
            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
        }

        return root;
    }


    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public  boolean searchNode(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        if (root.val > val) {
            return searchNode(root.left, val);
        }
        return searchNode(root.right, val);
    }

}

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}