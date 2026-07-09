package BST.MorrisAlgorithm;

import java.util.ArrayList;
import java.util.List;

// TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

// Solution class
class Solution {
    // Function to perform iterative Morris Inorder Traversal

    public List<Integer> getInorder(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();

        TreeNode cur = root;

        // Loop until the current node is not NULL
        while (cur != null) {
            // If the current node's left child is NULL
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                // If the left child is not NULL, find the predecessor (rightmost node in the left subtree)
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the predecessor's right child is NULL, establish a temporary link and move to the left child
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    /*If the predecessor's right child
                    is already linked, remove the link,
                    add current node to inorder list,
                    and move to the right child*/

                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        // Return the inorder
        // traversal result
        return inorder;
    }
}

// Main class
public class morris {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        Solution sol = new Solution();

        List<Integer> inorder = sol.getInorder(root);

        System.out.print("Binary Tree Morris Inorder Traversal: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();
    }
}
