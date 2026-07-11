// 1. Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 2. Your lowest common ancestor implementation
class Solution { 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
        if (root == null) return null; 
        
        int current = root.val; 
        if (current < p.val && current < q.val) { 
            return lowestCommonAncestor(root.right, p, q); 
        } 
        if (current > p.val && current > q.val) { 
            return lowestCommonAncestor(root.left, p, q); 
        } 
        return root; 
    } 
}

// 3. Test execution class containing the main method
public class LCA_IN_BST {

    // Helper method to insert nodes to build a Binary Search Tree (BST)
    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Helper method to look up a node reference in the tree
    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return findNode(root.left, val);
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Construct a standard LeetCode example BST
        //       6
        //     /   \
        //    2     8
        //   / \   / \
        //  0   4 7   9
        int[] treeValues = {6, 2, 8, 0, 4, 7, 9};
        TreeNode root = null;
        for (int val : treeValues) {
            root = insert(root, val);
        }

        // Get node references for the targets we want to test
        TreeNode p = findNode(root, 2);
        TreeNode q = findNode(root, 8);

        // Run the algorithm
        TreeNode result = solution.lowestCommonAncestor(root, p, q);

        // Print outputs to terminal
        System.out.println("--- BST Lowest Common Ancestor Test ---");
        System.out.println("Target Node P: " + p.val);
        System.out.println("Target Node Q: " + q.val);
        if (result != null) {
            System.out.println("Result LCA Node: " + result.val);
        } else {
            System.out.println("Result LCA Node: null");
        }
    }
}
