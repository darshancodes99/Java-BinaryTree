import java.util.LinkedList;
import java.util.Queue;

public class Build_Tree {
    public static void main(String[] args) {
        int[] nodeArr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodeArr);
        System.out.println(root.data);

        binaryTree.printPreOrder(root);
        System.out.println();

        binaryTree.printInOrder(root);
        System.out.println();

        binaryTree.printPostOrder(root);

        System.out.println();
        binaryTree.levelOrder(root);

        System.out.println();
        System.out.println( "height of tree : "  +  binaryTree.height(root));
    }

}

class BinaryTree {
    int ind = -1;

    public Node buildTree(int[] nodeArr) {
        ind++;
        if (nodeArr[ind] == -1) {
            return null;
        }
        Node nn = new Node(nodeArr[ind]);
        nn.left = buildTree(nodeArr);
        nn.right = buildTree(nodeArr);

        return nn;
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

    public void levelOrder(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            Node current = queue.remove();
            if (current == null){
                System.out.println();
                if (queue.isEmpty()){
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(current.data + " ");
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
        }
    }

    public  int height(Node root){
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
