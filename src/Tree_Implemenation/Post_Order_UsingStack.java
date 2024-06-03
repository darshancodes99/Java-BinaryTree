package Tree_Implemenation;

import java.util.Stack;

public class Post_Order_UsingStack {
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

        postOrderStack(binaryTree.root);
    }

    public static void postOrderStack(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()){
            Node remove = s1.pop();
            s2.push(remove);

            if (remove.left != null){
                s1.push(remove.left);
            }
            if (remove.right != null){
                s1.push(remove.right);
            }
        }

        while (!s2.isEmpty()){
            System.out.print(s2.pop().data + " ");
        }
    }
}
