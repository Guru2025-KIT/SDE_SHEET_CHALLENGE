// Definition for a binary tree node.
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

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.val) && 
               isValidBST(root.right, root.val, maxVal);
    }
}

// Driver class to test the solution
public class ValidateBST {
    public static void main(String[] args) {
        Solution solution = new Solution();

        /* 
           Constructing a VALID BST:
                 5
                / \
               3   7
        */
        TreeNode validTree = new TreeNode(5);
        validTree.left = new TreeNode(3);
        validTree.right = new TreeNode(7);

        System.out.println("Tree 1 is valid BST: " + solution.isValidBST(validTree)); 
        // Output: true


        /* 
           Constructing an INVALID BST:
                 5
                / \
               3   4   <-- 4 is invalid because it is in the right subtree of 5 but smaller than 5
        */
        TreeNode invalidTree = new TreeNode(5);
        invalidTree.left = new TreeNode(3);
        invalidTree.right = new TreeNode(4);

        System.out.println("Tree 2 is valid BST: " + solution.isValidBST(invalidTree)); 
        // Output: false
    }
}
