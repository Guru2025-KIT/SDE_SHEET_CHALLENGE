package Day10.DeleteFromEnd;

import java.util.*;

// Class representing a node in the linked list
class Node {
    int data;
    Node next;

    // Constructor for Node with data and next node
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor for Node with only data (next = null)
    Node(int data1) {
        data = data1;
        next = null;
    }
}

// Class to hold the solution logic
class Solution {

    // Function to print the linked list
    public void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Function to delete the Nth node from the end 
    // using the optimized two-pointer method
   public Node removeNthFromEnd(Node head, int n) {

        /*involve two pointers, a fast pointer and a slow pointer. The fast-moving pointer will initially be exactly N nodes ahead of the slow-moving pointer. After which, both of them will move one step at a time. When the fast pointer reaches the last node, i.e., the L-th node, the slow is guaranteed to be at the (L-N)-th node, where L is the total length of the linked list. */

        Node dummy=new Node(-1);
        Node slow=dummy,fast=dummy;
        dummy.next=head;
        if(head==null ){
            return null;
        }else if(head.next==null){
            return head.next;
        }

        for(int i=0;i<=n && fast!=null ;i++){
            fast=fast.next;
        }



        while(fast!=null && slow!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;

        return dummy.next;  //IMP We cant write head here because when 1st node deleted head will be cutout
    }
}

// Main class to execute the program
public class Optimal {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Create linked list manually
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));

        // Create Solution object
        Solution sol = new Solution();

        // Delete the Nth node from the end
        head = sol.removeNthFromEnd(head, N);

        // Print the modified linked list
        sol.printLL(head);
    }
}
