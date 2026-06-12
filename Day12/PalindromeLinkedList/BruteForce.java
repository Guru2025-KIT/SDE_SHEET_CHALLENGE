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

// Solution class to check if arr1[] is a subset of arr2[]
class Solution {
    public static boolean isPalindrome(Node head) {
        /* Algorithm:
            1. Traverse the linked list from start to end, and push each node's value into a stack.
            2. then compare poped element with temp element and return true or false.

            TC=SC= O(N)    
        */

        Stack<Integer> stack=new Stack<>();
        Node temp=head;
        boolean isPalli=true;

        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            if(temp.val!=stack.pop()){
                isPalli=false;
                return isPalli;
            }else{
                isPalli=true;
            }
            temp=temp.next;
        }

        return isPalli;
        
    }
}

// Driver class to test the solution
public class BruteForce {
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

