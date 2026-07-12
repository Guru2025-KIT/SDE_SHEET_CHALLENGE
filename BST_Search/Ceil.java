// ========================================================
// 1. NODE DEFINITION
// ========================================================
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) { 
        this.val = val; 
    }
}

// ========================================================
// 2. BLANK SOLUTION CLASS (Fill in your code here)
// ========================================================
class Solution {
    public int ceil(TreeNode root, int key) {
        int ceil=-1;
        if(root==null){
            return -1;
        }

        while(root!=null){
            if(key==root.val){  
                ceil=root.val;
                return ceil; }

            if(key>root.val){  
                root=root.right;
            }else{  
                ceil=root.val;
                root=root.left;
            }
        }
        return ceil;

    }
}

// ========================================================
// 3. RUNNER / TEST CLASS
// ========================================================
public class Ceil {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Constructing Test BST:
        //        10
        //       /  \
        //      5    15
        //     / \
        //    2   8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        System.out.println("--- Running BST ceil Tests ---");

        // Test 1: Exact match
        runTest(sol, root, 8, 8, "Test 1 (Exact Match)");

        // Test 2: ceil is smaller than key
        runTest(sol, root, 9, 8, "Test 2 (Key not in tree)");

        // Test 3: Large key
        runTest(sol, root, 11, 10, "Test 3 (Key between nodes)");

        // Test 4: Key smaller than minimum element
        runTest(sol, root, 1, -1, "Test 4 (No ceil exists)");

        // Test 5: Empty Tree
        runTest(sol, null, 10, -1, "Test 5 (Null Root)");
    }

    private static void runTest(Solution sol, TreeNode root, int key, int expected, String testName) {
        int result = sol.ceil(root, key);
        if (result == expected) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED. Expected: " + expected + ", Got: " + result);
        }
    }
}
