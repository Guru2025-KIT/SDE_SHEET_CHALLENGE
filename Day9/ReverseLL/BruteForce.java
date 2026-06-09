package Day9.ReverseLL;

import java.util.*;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        
        //Using Stack.  TC=O(2n) SC=O(n)
        //Reversing the Values only.

        ListNode temp=head;

        Deque<Integer> stack=new ArrayDeque<>();

        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            temp.val=stack.pop();
            temp=temp.next;
        } 

        return head;
        
    }
}

// Driver code
public class BruteForce {
    public static void main(String[] args) {
        // Creating linked list 1 -> 2 -> 3 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        Solution sol = new Solution();
        head = sol.reverseList(head);

        // Printing reversed list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

