class TreeNode { 
    int val; 
    TreeNode left; 
    TreeNode right; 
    TreeNode() {} 
    TreeNode(int val) { this.val = val; } 
    TreeNode(int val, TreeNode left, TreeNode right) { 
        this.val = val; 
        this.left = left; 
        this.right = right; 
    } 
} 

class Solution { 
    private TreeNode treeBuilder(int[] nums, int start, int end) { 
        if (start > end) { 
            return null; 
        } 
        int mid = start + (end - start) / 2; 
        TreeNode root = new TreeNode(nums[mid]); 
        root.left = treeBuilder(nums, start, mid - 1); 
        root.right = treeBuilder(nums, mid + 1, end); 
        return root; 
    } 
    
    public TreeNode sortedArrayToBST(int[] nums) { 
        return treeBuilder(nums, 0, nums.length - 1); 
    } 
} 

public class ConstructTree { 
    public static void main(String[] args) { 
        Solution solution = new Solution(); 
        
        // Test Case: Standard sorted array 
        int[] nums = {-10, -3, 0, 5, 9}; 
        TreeNode root = solution.sortedArrayToBST(nums); 
        
        // Quick validation check on the root node 
        if (root != null && root.val == 0) { 
            System.out.println("Success! Root value is correct: " + root.val); 
        } else { 
            System.out.println("Failure! Tree structure incorrect."); 
        } 
    } 
}
