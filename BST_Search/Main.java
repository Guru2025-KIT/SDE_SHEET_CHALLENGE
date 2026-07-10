package BST_Search;
import java.util.*;
// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    // Function to search a value in BST
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null ){
            return root;
        }

        TreeNode current=root;
        
        while(current!=null){
            if(current.val==val){
                return current;
            }else if(current.val<val){
                current=current.right;
            }else{
                current=current.left;
            }
        }
        return current;
    }
}

// Driver code
public class Main {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution obj = new Solution();
        TreeNode result = obj.searchBST(root, 2);

        if (result != null)
            System.out.println("Node found: " + result.val);
        else
            System.out.println("Node not found");
    }
}
