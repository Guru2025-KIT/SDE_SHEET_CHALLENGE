package BST.Inorder;
import java.util.ArrayList;
import java.util.List;

// Standard binary tree node structure
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Your tree traversal logic
class Solution { 
    private void inorder(TreeNode root, List<Integer> arr) { 
        if (root == null) { 
            return; 
        } 
        inorder(root.left, arr); 
        arr.add(root.val); 
        inorder(root.right, arr); 
    } 
    
    public List<Integer> inorderTraversal(TreeNode root) { 
        List<Integer> inorder = new ArrayList<>(); 
        inorder(root, inorder); 
        return inorder; 
    } 
}

// Executable wrapper class containing the main method
public class inorderR {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1. Build a sample binary tree
        //      1
        //    /   \
        //   2     3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 2. Execute the traversal logic
        List<Integer> result = solution.inorderTraversal(root);

        // 3. Print the output to the console
        System.out.println("Inorder Traversal Output: " + result);
    }
}
