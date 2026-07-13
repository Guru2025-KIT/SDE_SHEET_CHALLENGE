import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    // Time Complexity: O(1) amortized
    // Space Complexity: O(H) where H is the height of the tree
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root); // Push all the left nodes of the root node.
    }

    public int next() {
        TreeNode temp = stack.pop(); // Get and remove the node at top
        pushAll(temp.right);         // Move to right and add all its left nodes to stack
        return temp.val;             // Return the value of the next node
    }

    public boolean hasNext() {
        return !(stack.isEmpty());   // When Stack is empty hasNext must be false and vice versa
    }

    private void pushAll(TreeNode node) {
        // Compact for loop to traverse and push all left children
        for (; node != null; stack.push(node), node = node.left);
    }
}

// Public class wrapper named exactly as requested
public class BST_Iterator {
    public static void main(String[] args) {
        /*
         * Constructing a sample Binary Search Tree:
         *         7
         *        / \
         *       3   15
         *          /  \
         *         9    20
         */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Initializing the iterator
        System.out.println("--- Initializing BSTIterator ---");
        BSTIterator obj = new BSTIterator(root);

        // Running the iterator operations
        System.out.println("next(): " + obj.next());    // Returns 3
        System.out.println("next(): " + obj.next());    // Returns 7
        System.out.println("hasNext(): " + obj.hasNext()); // Returns true
        System.out.println("next(): " + obj.next());    // Returns 9
        System.out.println("hasNext(): " + obj.hasNext()); // Returns true
        System.out.println("next(): " + obj.next());    // Returns 15
        System.out.println("hasNext(): " + obj.hasNext()); // Returns true
        System.out.println("next(): " + obj.next());    // Returns 20
        System.out.println("hasNext(): " + obj.hasNext()); // Returns false
    }
}
