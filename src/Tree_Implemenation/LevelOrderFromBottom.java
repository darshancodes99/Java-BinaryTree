package Tree_Implemenation;

import java.util.*;

public class LevelOrderFromBottom {
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

        levelOrderFromBottom(binaryTree.root);
    }

    public static void levelOrderFromBottom(Node root){
        if (root == null){
            System.out.println(false);
        }

        Queue<Node> q = new LinkedList<>();
        Stack<List<Node>> stack = new Stack<>();

        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node remove = q.poll();
                list.add(remove);
                if (remove.left != null){
                    q.add(remove.left);
                }

                if (remove.right != null){
                    q.add(remove.right);
                }
            }
            stack.push(list);
        }

        while (!stack.isEmpty()){
            List<Node> list = stack.pop();
            for (Node i : list){
                System.out.print(i.data + " ");
            }
        }
    }
}


