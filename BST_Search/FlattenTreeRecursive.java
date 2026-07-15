
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
// 2. FIXED RECURSIVE SOLUTION CLASS
// ========================================================
class Solution {
    private TreeNode prev = null; 

    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
    }
}

// ========================================================
// 3. RUNNER / TEST CLASS
// ========================================================
public class FlattenTreeRecursive {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Constructing tree matching LeetCode test criteria:
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));

        System.out.println("--- Running Recursive Flatten Tree Tests ---");
        
        sol.flatten(root);
        
        System.out.print("Flattened List Sequence: ");
        TreeNode temp = root;
        int count = 0;
        boolean passed = true;
        
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            if (temp.left != null) {
                System.out.println("\n FAILED: Found a non-null left pointer!");
                passed = false;
                break;
            }
            temp = temp.right;
            if (++count > 20) {
                System.out.println("\n FAILED: Infinite recursive cycle loops detected!");
                passed = false;
                break;
            }
        }
        
        if (passed) {
            System.out.println("null\n TEST PASSED: Tree successfully flattened using Reverse Postorder recursion!");
        }
    }
}
