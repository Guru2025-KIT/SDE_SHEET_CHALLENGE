package BST.Preorder;
import java.util.*;

// TreeTreeTreeTreeNode structure for
// the binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize
    // the TreeTreeTreeTreeNode with a value
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        TreeNode TreeNode=root;

        while(true){
            if(TreeNode!=null){
                preorder.add(TreeNode.val);
                stack.push(TreeNode);
                TreeNode=TreeNode.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                TreeNode=stack.pop();
                TreeNode=TreeNode.right;
            }
        }
        return preorder;
    }
}

// Main class
public class iterative {
    public static void main(String[] args) {

        // Creating a sample binary tree
       TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Getting preorder traversal
        Solution sol = new Solution();
        List<Integer> result = sol.preorderTraversal(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

