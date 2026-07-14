import java.util.*;

// ========================================================
// 1. NODE DEFINITION
// ========================================================
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// ========================================================
// 2. STABLE CODEC CLASS
// ========================================================
class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "n";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                result.append("n ");
            } else {
                result.append(temp.val).append(" ");
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return result.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("n")) return null;
        
        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        
        int index = 1;
        while (!q.isEmpty() && index < values.length) {
            TreeNode node = q.poll();
            
            if (!values[index].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                node.left = left;
                q.add(left);
            }
            index++;
            
            if (index < values.length && !values[index].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                node.right = right;
                q.add(right);
            }
            index++;
        }
        return root;
    }
}

// ========================================================
// 3. RUNNER / TEST CLASS
// ========================================================
public class SerializeTree {
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Constructing tree:
        //        1
        //       / \
        //      2   3
        //         / \
        //        4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("--- Running Codec Serialization Tests ---");
        
        String serializedStr = codec.serialize(root);
        System.out.println("Serialized Output: [" + serializedStr + "]");
        
        TreeNode deserializedRoot = codec.deserialize(serializedStr);
        String reserializedStr = codec.serialize(deserializedRoot);
        
        if (serializedStr.equals(reserializedStr)) {
            System.out.println("Test Passed! Tree successfully encoded and decoded.");
        } else {
            System.out.println("Test Failed. Expected match, got deviation.");
        }
    }
}
