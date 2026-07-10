import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node provided by LeetCode
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {

        if(root==null || root.left==null){  return root; }

        Queue<Node> q=new LinkedList<>();
        
        q.add(root);
        q.add(null);

        Node prev=null;

        while(q.size()>0){
            Node current=q.poll();

            if(current==null){

                if(q.size()==0){
                    break;
                }

                q.add(null);
                prev=null;
                continue;

            }else{
                if(current.left!=null){     q.add(current.left);}
                if(current.right!=null){    q.add(current.right);}

                if(prev!=null){     prev.next=current; }
            }

            prev=current;
        }

        return root;
    
    }
}

public class PopulatingNextRightPointers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Construct a perfect binary tree: [1, 2, 3, 4, 5, 6, 7]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Run the connect logic
        solution.connect(root);

        // Level-order traversal printing using 'next' pointers to verify correctness
        System.out.println("Tree levels connected via next pointers:");
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
            levelStart = levelStart.left; // Move down to the next level
        }
    }
}
