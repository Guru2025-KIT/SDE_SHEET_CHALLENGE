package BST.PostOrder;

class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {

    // Function to return the postOrder traversal of a binary tree using two stacks
    public static java.util.List<Integer> postOrder(Node root) {
        java.util.List<Integer> postorder = new java.util.ArrayList<>();  // List to store the postorder traversal
        
        // If the tree is empty, return an empty traversal
        if (root == null) {
            return postorder;
        }

        java.util.Stack<Node> st1 = new java.util.Stack<>();  // First stack for iterative traversal
        java.util.Stack<Node> st2 = new java.util.Stack<>();  // Second stack to store the nodes in postorder

        // Push the root node onto the first stack
        st1.push(root);

        // Iterative traversal to populate st2 with nodes in postorder
        while (!st1.isEmpty()) {
            root = st1.pop();  // Get the top node from st1
            st2.push(root);  // Push the node onto st2

            // Push left child onto st1 if exists
            if (root.left != null) {
                st1.push(root.left);
            }

            // Push right child onto st1 if exists
            if (root.right != null) {
                st1.push(root.right);
            }
        }

        // Populate the postorder traversal list by popping st2
        while (!st2.isEmpty()) {
            postorder.add(st2.pop().data);  // Add the node's value to the postorder result
        }

        // Return the postorder traversal result
        return postorder;
    }
}

public class Main {

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting the postorder traversal
        java.util.List<Integer> result = Solution.postOrder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}