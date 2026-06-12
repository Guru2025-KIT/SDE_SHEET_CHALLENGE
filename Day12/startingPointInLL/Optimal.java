package Day12.startingPointInLL;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        /*Better Approach usig Tortoise and Hare Algorithm.
        Detect loops by slo and fast pointer approach. when they meet update slow to point head then update both by one now again //when they meet that is the starting point of Loop*/

        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            // If they meet, cycle is present
            if (slow == fast) {
                // Reset slow to head
                slow = head;

                // Move both one step to find start of loop
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the starting node of loop
                return slow;
            }
        }
        return null;

    }
}
public class Optimal {
    public static void main(String[] args) {
        // Creating linked list nodes
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating a cycle (tail connects to node index 1)
        head.next.next.next.next = head.next;

        Solution obj = new Solution();
        ListNode startNode = obj.detectCycle(head);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.val);
        else
            System.out.println("No cycle found.");
    }
}


