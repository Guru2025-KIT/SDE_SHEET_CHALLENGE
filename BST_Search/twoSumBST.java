import java.util.*;

// ========================================================
// 1. NODE DEFINITION
// ========================================================
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

// ========================================================
// 2. DESIGNED BST ITERATOR CLASS
// ========================================================
/**
 * A memory-efficient BST Iterator that can traverse a tree both forward 
 * (Inorder: Smallest to Largest) and backward (Reverse Inorder: Largest to Smallest).
 * 
 * Space Complexity: O(H) where H is the height of the tree.
 */
class BSTIterator {
    // Stack to track the current path from the root down to the next node
    private Stack<TreeNode> stack = new Stack<>();
    
    // Flag to determine traversal direction: 
    // false -> Forward Inorder (Left -> Root -> Right)
    // true  -> Reverse Inorder (Right -> Root -> Left)
    private boolean reverse = false;

    /**
     * Constructor initializes the iterator context.
     * @param root The root node of the Binary Search Tree.
     * @param isReversed Direction control configuration flag.
     */
    
    public BSTIterator(TreeNode root, boolean isReversed) {
        //Assign the reverse flag BEFORE executing pushAll.
        // If run afterwards, pushAll defaults to evaluating as a forward iterator.
        this.reverse = isReversed; 
        pushAll(root);
    }

    /**
     * Checks if there are more nodes left to process in the traversal.
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Retrieves the next value in sorted order and advances internal pointers.
     * Time Complexity: O(1) Amortized because each node is pushed/popped exactly once.
     */
    public int next() {
        // Pop the current top element from the stack (the next smallest or largest)
        TreeNode temp = stack.pop();
        
        // Advance the iterator path into the unvisited subtree branch:
        if (reverse) {
            // Reverse Iterator: We finished processing the Right Subtree and Root.
            // Now, we populate the stack with the extreme elements of the Left Subtree.
            pushAll(temp.left);
        } else {
            // Forward Iterator: We finished processing the Left Subtree and Root.
            // Now, we populate the stack with the extreme elements of the Right Subtree.
            pushAll(temp.right);
        }
        
        return temp.val;
    }

    /**
     * Helper method to populate the tracking stack along an extreme path branch.
     */
    private void pushAll(TreeNode node) {
        while (node != null) {
            //Push the active node itself to the stack to preserve pathing state
            stack.push(node);
            
            // Branch step direction matches requested iterator profile orientation
            if (reverse) {
                // If reverse, move down the extreme right branch to load maximum values first
                node = node.right;
            } else {
                // If forward, move down the extreme left branch to load minimum values first
                node = node.left;
            }
        }
    }
}

// ========================================================
// 3. TWO-POINTER SOLUTION CLASS
// ========================================================
class Solution {
    /**
     * Solves Two Sum IV using a dynamic two-pointer technique on the BST.
     * Time Complexity: O(N) where N is the total number of nodes in the tree.
     * Space Complexity: O(H) matching tree height bounds (Optimal).
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        
        // Instantiate two localized pointer-iterators moving from opposite ends
        BSTIterator left = new BSTIterator(root, false);  // Points to smallest elements
        BSTIterator right = new BSTIterator(root, true);  // Points to largest elements

        // Initialize state variables to values on boundaries
        int i = left.next();
        int j = right.next();

        // Standard classic two-pointer search iteration loop block
        while (i < j) {
            int currentSum = i + j;
            
            if (currentSum == k) {
                return true; // Target sum pair found successfully!
            } 
            else if (currentSum < k) {
                // Current combination is too small; advance left boundary upward
                i = left.next();
            } 
            else {
                // Current combination is too big; decrement right boundary downward
                j = right.next();
            }
        }
        return false; // Loop terminated without identifying matching nodes
    }
}

// ========================================================
// 4. RUNNER / TEST CLASS
// ========================================================
public class twoSumBST {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Constructing Test BST:
        //        10
        //       /  \
        //      5    15
        //     / \
        //    2   8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        System.out.println("--- Running Two Sum BST Tests ---");

        // Test Cases Verification Block
        runTest(sol, root, 13, true, "Test 1 (Target 13: 5 + 8)");
        runTest(sol, root, 25, true, "Test 2 (Target 25: 10 + 15)");
        runTest(sol, root, 6, false, "Test 3 (Target 6: Non-existent)");
        runTest(sol, root, 20, true, "Test 4 (Target 20: 5 + 15)");
    }

    private static void runTest(Solution sol, TreeNode root, int k, boolean expected, String testName) {
        boolean result = sol.findTarget(root, k);
        if (result == expected) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED. Expected: " + expected + ", Got: " + result);
        }
    }
}
