package Day13.CopyListwithRandomPointer;

// ==========================================
// 1. NODE DEFINITION
// ==========================================
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// ==========================================
// 2. YOUR OPTIMIZED SOLUTION
// ==========================================
class Solution {
    public Node copyRandomList(Node head) {
        // TC=O(3N)  SC=O(1)
        // 1. Insert the copy Nodes in between.
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        } 

        // 2. Update the Random Pointers.
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next; // random.next links to the copied node instead of Original node   
            }
            temp = temp.next.next;
        }

        // 3. Update the Next Pointers.
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}

// ==========================================
// 3. TEST CLASS
// ==========================================
public class Optimal {
    public static void main(String[] args) {
        // Create nodes for list: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        // Connect next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Connect random pointers
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        // Run the solution
        Solution solution = new Solution();
        Node copiedHead = solution.copyRandomList(node1);

        // Verify the results
        System.out.println("--- Testing Deep Copy ---");
        
        boolean isSuccess = verifyCopy(node1, copiedHead);
        if (isSuccess) {
            System.out.println("Result: SUCCESS! The list was perfectly cloned.");
        } else {
            System.out.println("Result: FAILED! The clone is incorrect.");
        }
    }

    // Helper method to validate the deep copy
    private static boolean verifyCopy(Node original, Node copy) {
        Node t1 = original;
        Node t2 = copy;

        while (t1 != null && t2 != null) {
            // Check 1: Values must match
            if (t1.val != t2.val) {
                System.out.println("Fail: Values do not match.");
                return false;
            }
            // Check 2: Memory addresses must be different (Deep copy check)
            if (t1 == t2) {
                System.out.println("Fail: Copied node points to the original node memory location.");
                return false;
            }
            // Check 3: Random pointer values must match
            if (t1.random != null && t2.random != null) {
                if (t1.random.val != t2.random.val) {
                    System.out.println("Fail: Random pointer values do not match.");
                    return false;
                }
                if (t1.random == t2.random) {
                    System.out.println("Fail: Random pointer points to original list memory.");
                    return false;
                }
            } else if (t1.random != t2.random) {
                System.out.println("Fail: One random pointer is null while the other is not.");
                return false;
            }

            // Print step status
            System.out.println("Cloned Node [" + t2.val + "] works fine.");

            t1 = t1.next;
            t2 = t2.next;
        }

        // Check 4: Both lists must reach the end at the same time
        return t1 == null && t2 == null;
    }
}


