package BST.Inorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Define the TreeNode structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> inorder=new ArrayList<>();

        TreeNode node=root;

        while(true){

            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }

                node=stack.pop();
                inorder.add(node.val);
                node=node.right;
            }
        }
        return inorder;
    }
}

// Main class for testing
public class iterative {
    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Initializing the Solution class
        Solution sol = new Solution();

        // Getting the inorder traversal
        List<Integer> result = sol.inorderTraversal(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

