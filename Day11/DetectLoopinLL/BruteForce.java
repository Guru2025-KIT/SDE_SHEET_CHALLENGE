package Day11.DetectLoopinLL;

import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // val stored in the node
    int val;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both val 
    // and next node as parameters
    Node(int val1, Node next1) {
        val = val1;
        next = next1;
    }

    // Constructor with only val as
    // a parameter, sets next to null
    Node(int val1) {
        val = val1;
        next = null;
    }
}

// Solution class with detectLoop function
class Solution {
    // function to detect loop in linked list
    public boolean hasCycle(Node head) {
        //Brute-Force Approach
        /*Using HashMap TC= O(N*LogN)  SC=O(N) */
        
        Map<Node,Integer> visited=new HashMap<>();
        Node temp=head;
        boolean isLoop=false;
        while(temp!=null){

            if(visited.containsKey(temp)){
                isLoop=true;
                return isLoop;
            }

            visited.put(temp,temp.val);
            temp=temp.next;
        }
         return isLoop;
    }
}

// Driver class
public class BruteForce {
    public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        Solution sol = new Solution();

        // Check if there is a loop 
        // in the linked list
        if (sol.hasCycle(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}

