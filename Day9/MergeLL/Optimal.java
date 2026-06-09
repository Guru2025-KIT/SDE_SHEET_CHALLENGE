package Day9.MergeLL;

// Node class represents a
// node in a linked list
class Node {
    // data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

// Class to merge two sorted linked lists
class MergeLinkedLists {

    // Function to merge two sorted linked lists
    static Node sortTwoLinkedLists(Node list1, Node list2) {
        //Optimal Solution TC=O(n1+n2) SC=O(1)

        Node temp1=list1,temp2=list2;
        Node dummy=new Node(-1),temp=dummy;


       while (temp1 != null && temp2 != null) {
            // Use <= to handle equal numbers correctly
            if (temp1.data <= temp2.data) {
                temp.next = temp1; // Point to the existing node directly
                temp1 = temp1.next;
            } else {
                temp.next = temp2; 
                temp2 = temp2.next;
            }
        //Move merger pointer forward!
            temp = temp.next; 
        }
        
    // Stitch any leftover nodes
        if(temp1!=null){
            temp.next=temp1;
        }else{
            temp.next = temp2;
        }
        

        return dummy.next;
    }

    // Function to print the linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Linked Lists
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        System.out.print("First sorted linked list: ");
        printLinkedList(list1);

        System.out.print("Second sorted linked list: ");
        printLinkedList(list2);

        Node mergedList = sortTwoLinkedLists(list1, list2);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(mergedList);
    }
}