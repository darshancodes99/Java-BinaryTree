package Tree_Implemenation;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static int count = 0;
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.right.left = new Node(60);
        binaryTree.root.right.right = new Node(70);

        binaryTree.levelOrder();
        System.out.println();

        binaryTree.printPreOrder(binaryTree.root);
        System.out.println();

        binaryTree.printInOrder(binaryTree.root);
        System.out.println();

        binaryTree.printPostOrder(binaryTree.root);
        System.out.println();

        System.out.println( binaryTree.countNodes(binaryTree.root));

        findNthNode(binaryTree.root, 3);
    }

    public static void findNthNode(Node root, int n){
        if (root == null){
            return;
        }
        findNthNode(root.left, n);
        count++;
        if (count == n){
            System.out.print(root.data);
            return;
        }
        findNthNode(root.right, n);
    }
}

class BinaryTree {
    Node root;

    public void levelOrder(){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            if (n == null){
                return;
            }
            System.out.print(n.data + " ");
            if (n.left != null){
                queue.add(n.left);
            }
            if (n.right != null){
                queue.add(n.right);
            }
        }
    }

    public void printPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public void printPostOrder(Node root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public int countNodes(Node root){
        if (root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }

}

class Node {
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}
