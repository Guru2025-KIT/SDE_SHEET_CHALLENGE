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

    public Node removeNthFromEnd(Node head, int n) {

        /*The simplest way to delete the Nth node from the end is to delete the (L-N+1)th node from the start of the linked list, where L is the total length of the linked list.*/ 

        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        

        int NodeToDelete=count-n+1;         //4=5-2+1
        if(NodeToDelete==1){
            return head.next;
        }

        temp=head;
        for(int i=0;i<NodeToDelete-2;i++){
            temp=temp.next;
        }
        
        temp.next=temp.next.next;
        return head;
    }
}

// Main class to execute the program
public class BruteForce {
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
