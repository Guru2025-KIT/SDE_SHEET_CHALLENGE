import java.util.Stack;

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
// 2. FIXED STACK SOLUTION CLASS
// ========================================================
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            
            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;
        }
    }
}

// ========================================================
// 3. RUNNER / TEST CLASS
// ========================================================
public class FlattenTreeStack {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Constructing tree:
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));

        System.out.println("--- Running Stack-Based Flatten Tree Tests ---");
        
        sol.flatten(root);
        
        System.out.print("Flattened List Sequence: ");
        TreeNode temp = root;
        int count = 0;
        boolean passed = true;
        
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            if (temp.left != null) {
                System.out.println("\nFAILED: Found a non-null left pointer!");
                passed = false;
                break;
            }
            temp = temp.right;
            if (++count > 20) {
                System.out.println("\nFAILED: Infinite cycle tracking loop detected!");
                passed = false;
                break;
            }
        }
        
        if (passed) {
            System.out.println("null\n TEST PASSED: Tree successfully flattened using Stack structure!");
        }
    }
}
