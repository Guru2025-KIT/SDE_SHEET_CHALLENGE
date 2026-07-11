// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        while (root != null) {
            if (p.val > root.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }
}

public class inorder_Successor_Predessor {
    public static void main(String[] args) {
        /*
                   20
                 /    \
                8      22
              /   \
             4     12
                  /  \
                 10   14
        */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        Solution solution = new Solution();

        // Target node is 8
        TreeNode target = root.left; 

        TreeNode succ = solution.inorderSuccessor(root, target);
        TreeNode pred = solution.inorderPredecessor(root, target);

        System.out.println("Target: " + target.val);
        System.out.println("Inorder Successor: " + (succ != null ? succ.val : "null"));
        System.out.println("Inorder Predecessor: " + (pred != null ? pred.val : "null"));
    }
}
