// ========================================================
// 1. NODE DEFINITION
// ========================================================
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

// ========================================================
// 2. OPTIMAL IN-PLACE SOLUTION CLASS (O(1) Space)
// ========================================================
class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        
        while (current != null) {
            // If a left child exists, we need to relocate the right subtree
            if (current.left != null) {
                // Find the rightmost node in the left subtree (Inorder Predecessor)
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                // Connect the predecessor's right to current node's right subtree
                predecessor.right = current.right;
                
                // Move the left subtree to become the right subtree
                current.right = current.left;
                
                // CRITICAL STEP: Explicitly clear the left pointer to prevent infinite cycles
                current.left = null;
            }
            
            // Move down to the next node in the flattened sequence
            current = current.right;
        }
    }
}

// ========================================================
// 3. RUNNER / TEST CLASS
// ========================================================
public class FlattenTree {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ----------------------------------------------------
        // Constructing your exact LeetCode Case 1 tree:
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6
        // ----------------------------------------------------
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));

        System.out.println("--- Running Flatten Binary Tree Tests ---");
        
        // Execute flattening
        sol.flatten(root);
        
        // Print the flattened linked list structure
        System.out.print("Flattened List Sequence: ");
        TreeNode temp = root;
        boolean cycleDetected = false;
        int count = 0;
        
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            if (temp.left != null) {
                System.out.print("\nFAILED: A left child pointer was not set to null!");
                cycleDetected = true;
                break;
            }
            temp = temp.right;
            
            // Safety break against any unexpected loops during local testing
            if (++count > 20) { 
                System.out.print("\nFAILED: Infinite loop cycle detected!");
                cycleDetected = true;
                break;
            }
        }
        
        if (!cycleDetected) {
            System.out.println("null\nTEST PASSED: Tree successfully flattened in-place!");
        }
    }
}
