package Day9.ReverseLL;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    // Constructor to initialize node value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    // Function to reverse a linked list iteratively
    public ListNode reverseList(ListNode head) {
        // Initialize previous pointer to null
        ListNode prev = null;

        // Start from the head of the list
        ListNode temp = head;

        // Traverse the list
        while (temp != null) {
            // Save the next node
            ListNode front = temp.next;

            // Reverse the current node's pointer
            temp.next = prev;

            // Move prev to current node
            prev = temp;

            // Move to the next node
            temp = front;
        }

        // Return new head (last node becomes first)
        return prev;
    }
}

// Driver class
public class OptimalInplace {
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        // Reversing the list
        ListNode newHead = sol.reverseList(head);

        // Printing the reversed list
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}

