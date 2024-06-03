package Tree_Implemenation;

import java.util.Deque;
import java.util.LinkedList;

public class spiral_level_traversal {
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
        binaryTree.root.right.right.right = new Node(100);



        SpiralTraversal(binaryTree.root);
    }

    public static void SpiralTraversal(Node root){
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        boolean flag = true;

        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                Node node;
                if (flag) {
                  node = deque.pollFirst();
                } else {
                   node = deque.pollLast();
                }

                System.out.print(node.data + " ");

                if (flag){
                    if (node.left != null){
                        deque.addLast(node.left);
                    }
                    if (node.right != null){
                        deque.addLast(node.right);
                    }
                } else {
                    if (node.right != null){
                        deque.addFirst(node.right);
                    }
                    if (node.left != null){
                        deque.addFirst(node.left);
                    }
                }
            }

            flag = !flag;
        }

    }
}
