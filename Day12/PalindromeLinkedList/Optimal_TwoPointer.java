package Day12.PalindromeLinkedList;

import java.util.Stack;

class Node {
    int val;
    Node next;
    Node(int value) {
        val = value;
        next = null;
    }
}

class Solution {
   public static Node reverseLL(Node head){
        Node temp=head,prev=null;
        while(temp!=null){
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public static boolean isPalindrome(Node head) {

        //Optimal Approach.
        /*Algorithm:
            1.Use two pointers ‘slow’ and ‘fast’ to find the middle node, where slow moves one step and fast moves two steps at a time.
            2.Reverse the second half of the linked list starting from the node after the middle (slow->next), preparing it for comparison.

            TC=O(N)  SC=O(1)
         */
         if(head==null || head.next==null)  return true;

        Node slow=head,fast=head;

        while(fast.next != null && fast.next.next != null){     //stop One Step earlier works for both odd and even length LL's
            slow=slow.next;
            fast=fast.next.next;
        }

        Node secondHalf=reverseLL(slow.next);

        Node firstHalfPointer = head;
        Node secondHalfPointer = secondHalf;


        while(secondHalfPointer!=null){
            if(firstHalfPointer.val!=secondHalfPointer.val){
                return false;
            }
            firstHalfPointer=firstHalfPointer.next;
            secondHalfPointer=secondHalfPointer.next;
        }
        return true;
    }
}

// Driver class to test the solution
public class Optimal_TwoPointer {
    public static void main(String[] args) {
       Solution sol = new Solution();

       // Create a linked list: 1 -> 2 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);


        // Call the isSubset function
        boolean ans = Solution.isPalindrome(head);

        // Output the result
        if (ans) {
            System.out.println("LL is Pallindrome");
        } else {
            System.out.println("LL is not a Pallindrome");
        }
    }
}


