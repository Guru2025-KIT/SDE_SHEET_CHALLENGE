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

public static int lengthOfLL(Node head){

        /*
        Quite Costly because involve more steps.

        Time Complexity: O(2 × max(length of list1, length of list2)) + O(abs(length of list1 − length of list2)) + O(min(length of list1, length of list2)).

        SC=O(1)*/

        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        Node t1=headA,t2=headB;

        int l1=lengthOfLL(headA);
        int l2=lengthOfLL(headB);
        int positiveDiff=Math.abs(l1-l2);

        if(l1>=l2){
            for(int i=0;i<positiveDiff;i++){
                t1=t1.next;
            }
        }else{
            for(int i=0;i<positiveDiff;i++){
                t2=t2.next;
            }
        }


        while(t1!=null && t2!=null){
           if(t1==t2)   return t1;
           t1=t1.next;
           t2=t2.next;

        }
        return null;

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

public class Optimal_1 {
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
