package Day10.DeleteGivenNodeWhenHeadAccessIsNotProvided;

// Definition for singly-linked list
class ListNode {
    int val;           
    ListNode next;    
    ListNode(int x) { val = x; }
}

class Solution {
    // Function to delete a given node (not the tail)
    public void deleteNode(ListNode node) {
        /*Whenever there is Such kind of problems in which we have not given the 
        access to previous node we can simply copy the next node data to current node to
         delete and then delete the next node to the given node.*/
        
        //TC=SC= O(1)
        node.val=node.next.val;
        node.next=node.next.next;

    }
}

public class DeleteTheGivenNode_NodeIsGivenNotHead {
    public static void main(String[] args) {
        // Create a linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Delete node with value 5
        Solution sol = new Solution();
        sol.deleteNode(head.next);

        // Print updated list: expected output 4 -> 1 -> 9
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
