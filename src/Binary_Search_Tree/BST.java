package Binary_Search_Tree;

public class BST {

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        BinaryST binaryST = new BinaryST();
        binaryST.printInOrder(root);

        System.out.println(searchNode(root, 4));
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean searchNode(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        if (root.val > val) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }

}

class BinaryST {
    Node root;

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

}

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}