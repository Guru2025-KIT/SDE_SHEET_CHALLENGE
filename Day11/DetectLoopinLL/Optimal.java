package Day11.DetectLoopinLL;
// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data 
    // and next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

// Solution class with detectLoop function
class Solution {
    // function to detect loop in linked list
    public boolean hasCycle(Node head) {

        //Better Approach Using Slow and Fast Pointer.
        //TC=O(N)
        //SC=O(1)
        
        Node slow=head,fast=head;
        boolean isLoop=false;

        while(fast!=null && fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                isLoop=true;
                return isLoop;
            }
        }
        return isLoop;
        
    }
}

// Driver class
public class Optimal {
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

