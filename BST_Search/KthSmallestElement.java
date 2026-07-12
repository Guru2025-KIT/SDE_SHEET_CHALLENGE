import java.util.*;

// ========================================================
// 1. NODE DEFINITION
// ========================================================
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// ========================================================
// 2. YOUR CORRECTED SOLUTION CLASS
// ========================================================
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // Find the Inorder Using Morris Traversal and then return the element at index k-1;
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
        return inorder.get(k - 1);
    }
}

// ========================================================
// 3. RUNNER / TEST CLASS
// ========================================================
public class KthSmallestElement {
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

        System.out.println("--- Running Kth Smallest Element Tests ---");

        // Test 1: 1st smallest (should be 2)
        runTest(sol, root, 1, 2, "Test 1 (1st Smallest)");

        // Test 2: 3rd smallest (should be 8)
        runTest(sol, root, 3, 8, "Test 2 (3rd Smallest)");

        // Test 3: 4th smallest (should be 10)
        runTest(sol, root, 4, 10, "Test 3 (4th Smallest)");

        // Test 4: 5th smallest (should be 15)
        runTest(sol, root, 5, 15, "Test 4 (5th Smallest)");
    }

    private static void runTest(Solution sol, TreeNode root, int k, int expected, String testName) {
        int result = sol.kthSmallest(root, k);
        if (result == expected) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED. Expected: " + expected + ", Got: " + result);
        }
    }
}
