package Tree_Implemenation;

import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static int count = 0;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.root = new Node(10);
        binaryTree1.root.left = new Node(20);
        binaryTree1.root.right = new Node(30);

        binaryTree.levelOrder(binaryTree.root);
        System.out.println();

        binaryTree.printPreOrder(binaryTree.root);
        System.out.println();

        binaryTree.printInOrder(binaryTree.root);
        System.out.println();

        binaryTree.printPostOrder(binaryTree.root);
        System.out.println();

        System.out.println(binaryTree.countNodes(binaryTree.root));

        findNthNode(binaryTree.root, 3);
        System.out.println();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Node node = binaryTree.createTreeFromArray(arr);
        System.out.println(node.data);

        binaryTree.levelOrder(node);
        System.out.println();

        binaryTree.printPreOrder(node);
        System.out.println();

        binaryTree.printInOrder(node);
        System.out.println();

        binaryTree.printPostOrder(node);

        System.out.println();
        System.out.println( binaryTree.isSameTree(binaryTree.root, binaryTree1.root));

        System.out.println(binaryTree.isSameTreeQueue(binaryTree.root, binaryTree1.root));

        System.out.println(findNthElement(binaryTree.root, 20));
    }

    public static void findNthNode(Node root, int n) {
        if (root == null) {
            return;
        }
        findNthNode(root.left, n);
        count++;
        if (count == n) {
            System.out.print(root.data);
            return;
        }
        findNthNode(root.right, n);
    }

    public static boolean findNthElement(Node root, int n) {
        if (root == null) {
            return false;
        }

        if (root.data == n) {
            return true;
        }

        return  findNthElement(root.left, n) || findNthElement(root.right, n);
    }

}

class BinaryTree {
    Node root;

    public Node createTreeFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            Node curr = q.remove();

            curr.left = new Node(arr[i++]);
            q.add(curr.left);

            if (i < arr.length) {
                curr.right = new Node(arr[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n == null) {
                return;
            }
            System.out.print(n.data + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
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

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }

    public boolean isSameTree(Node p, Node q){
        if(p == null && q == null){
            return true;
        }
        if (p == null || q == null || p.data != q.data){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeQueue(Node p, Node q){
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()){
            Node f = queue.poll();
            Node s = queue.poll();

            if (f == null && s == null){
                continue;
            } else if (f == null || s == null || f.data != s.data) {
                return false;
            }

            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }

        return true;
    }

}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
