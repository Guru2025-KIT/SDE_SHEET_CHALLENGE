import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length <= 0) {
            return null;
        }
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorder(int[] preorder, int bound, int[] nodes) {
        if (nodes[0] == preorder.length || preorder[nodes[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[nodes[0]++]);
        
        // Corrected tracking: wire children together
        root.left = bstFromPreorder(preorder, root.val, nodes);
        root.right = bstFromPreorder(preorder, bound, nodes);

        return root;
    }
}

// Driver class to run and test the code
public class ConstructBSTPreorder {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample input array from LeetCode 1008
        int[] preorderInput = {8, 5, 1, 7, 10, 12};

        System.out.println("Building BST from preorder array: [8, 5, 1, 7, 10, 12]");
        TreeNode root = solution.bstFromPreorder(preorderInput);

        System.out.println("\nLevel-order traversal of the generated tree:");
        printLevelOrder(root);
    }

    // Helper method to print the tree layer by layer
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (current != null) {
                    System.out.print(current.val + " ");
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println(); // Move to the next row/level
        }
    }
}
