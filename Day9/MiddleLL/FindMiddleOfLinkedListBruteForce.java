package Day9.MiddleLL;

// Node class represents a node in a linked list
class Node {
    int data; 
    Node next;     

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindMiddleOfLinkedListBruteForce {
    
    public static Node middleNode(Node head) {

            //BruteForce Approach TC=O(n+n/2) SC=O(1)
            int count = 0;
            Node temp = head;
            
            // 1. Count total nodes
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            
            // 2. Find middle index target
            int middleIndex = count / 2; 
            temp = head;
            
            // 3. Advance to the target node
            for (int i = 0; i < middleIndex; i++) {
                temp = temp.next;
            }
            
            return temp;
        }

    public static void main(String[] args) {
        // Creating a sample linked list:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Find the middle node
        Node middleNode = middleNode(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.data);
    }
}

                                