package Day13.RotateLL;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //BruteForce Approach
        //TC=O(k*n)     SC=O(1)
        /*we are essentially moving the last node to the front of the list, k times. Each rotation means: take the last node, disconnect it from the list, insert it at the front (head) of the list. We repeat this process k times.  */

        if(head==null || head.next==null || k==0){
            return head;
        }

        for(int i=0;i<k;i++){
            ListNode temp=head.next,pretemp=head;;

            while(temp.next!= null){
                pretemp=temp;
                temp=temp.next;
            }

            pretemp.next=null;
            temp.next=head;
            head=temp;
        }
        return head;
    }
}

// Driver class
public class BruteForce {
    public static void main(String[] args) {
        // Create linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        int k = 2;
        ListNode result = sol.rotateRight(head, k);

        // Print result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

