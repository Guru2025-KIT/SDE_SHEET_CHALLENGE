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
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// ========================================================
// 2. YOUR CORRECT SOLUTION CLASS
// ========================================================
class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode current = root;
        
        while (current != null) {
            if (current.left == null) {
                inorder.add(current.val);
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    inorder.add(current.val);
                    current = current.right;
                }
            }
        }
        return inorder.get(inorder.size() - k); 
    }
}

// ========================================================
// 3. CORRECTED RUNNER / TEST CLASS
// ========================================================
public class kthLargest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Tree Structure: [2, 5, 8, 10, 15]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        System.out.println("--- Running Kth Largest Element Tests ---");

        // Test 1: 1st Largest is 15
        runTest(sol, root, 1, 15, "Test 1 (1st Largest)");

        // Test 2: 3rd Largest is 8
        runTest(sol, root, 3, 8, "Test 2 (3rd Largest)");

        // Test 3: 4th Largest is 5
        runTest(sol, root, 4, 5, "Test 3 (4th Largest)");

        // Test 4: 5th Largest is 2
        runTest(sol, root, 5, 2, "Test 4 (5th Largest)");
    }

    private static void runTest(Solution sol, TreeNode root, int k, int expected, String testName) {
        int result = sol.kthLargest(root, k);
        if (result == expected) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED. Expected: " + expected + ", Got: " + result);
        }
    }
}
