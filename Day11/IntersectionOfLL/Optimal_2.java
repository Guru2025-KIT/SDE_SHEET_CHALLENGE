package Day11.IntersectionOfLL;

class Node {
    int num;
    Node next;
    Node(int val) {
        num = val;
        next = null;
    }
}

class Solution {
    // Utility function to insert node at the end of the linked list
    public void insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Utility function to check presence of intersection
    public Node getIntersectionNode(Node headA, Node headB) {
    
    //TC= O(2 × max(length of list1, length of list2)), SC=O(1)
    /*Algorithm
        The difference of length method requires various steps to work on it. 

            1.Take two dummy nodes for each list. Point each to the head of the lists.
            2.Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
    */
        Node temp1=headA,temp2=headB;

        while(temp1!=temp2){
            
            if(temp1==null){
                temp1=headB;
            }else{
                temp1=temp1.next;
            }

            temp2=(temp2==null?headA:temp2.next);
        }

        return temp1;
        
    }

    // Utility function to print linked list
    public void printList(Node head) {
        while (head != null && head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.print(head.num);
        }
        System.out.println();
    }
}

public class Optimal_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Creation of both lists
        Node head = new Node(1);
        sol.insertNode(head, 3);
        sol.insertNode(head, 1);
        sol.insertNode(head, 2);
        sol.insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next;  // Intersection point
        Node headSec = new Node(3);
        Node head2 = headSec;
        headSec.next = head;  // Creating intersection

        // Printing the lists
        System.out.print("List1: ");
        sol.printList(head1);
        System.out.print("List2: ");
        sol.printList(head2);

        // Checking if intersection is present
        Node answerNode = sol.getIntersectionNode(head1, head2);
        if (answerNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerNode.num);
        }
    }
}
