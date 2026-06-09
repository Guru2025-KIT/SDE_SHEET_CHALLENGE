package Day9.ReverseLL;


// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class Solution {
    // Recursive method to reverse linked list
    public ListNode reverseList(ListNode head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null)
            return head;

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Store reference to next node
        ListNode front = head.next;

        // Make the next node point to current node
        front.next = head;

        // Break original forward link
        head.next = null;

        // Return new head of reversed list
        return newHead;
    }
}

// Driver code
public class RecursiveBest {
    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        ListNode reversed = sol.reverseList(head);

        // Printing reversed list
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        System.out.println();
    }
}
