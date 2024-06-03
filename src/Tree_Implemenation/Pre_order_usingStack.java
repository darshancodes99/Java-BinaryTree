package Tree_Implemenation;

import java.util.Stack;

public class Pre_order_usingStack {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.right.left = new Node(60);
        binaryTree.root.right.right = new Node(70);
        binaryTree.root.left.left.left = new Node(80);

        preOrderStack(binaryTree.root);
    }

    public static void preOrderStack(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node remove = stack.pop();
            System.out.print(remove.data + " ");
            if (remove.right != null){
                stack.push(remove.right);
            }
            if (remove.left != null){
                stack.push(remove.left);
            }
        }
    }
}
