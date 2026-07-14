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
// 2. FIXED NODE VALUE CLASS
// ========================================================
class NodeValue {
    public int minNode, maxNode, sum;
    public NodeValue(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}

// ========================================================
// 3. FIXED SOLUTION CLASS
// ========================================================
class Solution {
    // IMP STEP 1: Global variable tracks the absolute maximum valid BST sum across independent subtrees.
    // This solves the state-dropping bug where valid values were lost during validation failure returns.
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        maxSum = 0; // Reset state for safe, isolated executions across multiple test runs
        maxSumBSTHelper(root);
        return maxSum;
    }

    private NodeValue maxSumBSTHelper(TreeNode root) {
        // IMP STEP 2: Base case returns extreme inverse limits for null references.
        // - minNode is set to MAX_VALUE so that any parent node's right check (root.val < right.minNode) passes safely.
        // - maxNode is set to MIN_VALUE so that any parent node's left check (left.maxNode < root.val) passes safely.
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // IMP STEP 3: Execute bottom-up Postorder Traversal (Left, Right, then Root).
        // This lets us harvest subtree bounds and sums before evaluating the current parent node.
        NodeValue left = maxSumBSTHelper(root.left);
        NodeValue right = maxSumBSTHelper(root.right);

        // IMP STEP 4: Validate if the current node forms a valid BST with its children.
        // - Condition 1: Current value must be strictly greater than the absolute maximum on its left branch.
        // - Condition 2: Current value must be strictly smaller than the absolute minimum on its right branch.
        if (left.maxNode < root.val && root.val < right.minNode) {
            
            // Calculate total key sum of this valid subtree configuration
            int currentSum = root.val + left.sum + right.sum;
            
            // Instantly record it against our global max if it sets a new high score
            maxSum = Math.max(maxSum, currentSum);

            // IMP STEP 5: Calculate true spatial boundaries for the new valid BST subtree block.
            // Compare the root value with child boundary extremes to support deep level calculations.
            int minValue = Math.min(root.val, left.minNode);
            int maxValue = Math.max(root.val, right.maxNode);

            return new NodeValue(minValue, maxValue, currentSum);
        }

        // IMP STEP 6: Failure State — The current subtree is not a valid BST.
        // Return highly distorted, inverted bounds (MIN_VALUE for minimum, MAX_VALUE for maximum).
        // This ensures that all future parent nodes above it automatically fail their validation check.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}

// ========================================================
// 4. RUNNER / TEST CLASS
// ========================================================
public class maxSumBST {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Constructing your exact LeetCode failure test tree context structure
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(-5);
        root.left.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(-3);
        root.left.right.right.right = new TreeNode(10);

        System.out.println("--- Running LeetCode verified 1373 Test Scenario ---");
        
        int result = sol.maxSumBST(root);
        System.out.println("✅ Execution finished! Computed Maximum Sum BST: " + result);
    }
}
