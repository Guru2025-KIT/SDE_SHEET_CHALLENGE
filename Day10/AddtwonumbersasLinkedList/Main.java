package Day10.AddtwonumbersasLinkedList;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
     this.val = val; 
     this.next = next; 
    }
}

class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
    //TC=SC= O(max(len(l1),len(l2)))
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        int carry=0;
        

        while(l1!=null || l2!=null || carry!=0){        //execute for unequal lengths also
            int sum=carry;

            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            carry=sum/10;
            current.next=new ListNode(sum%10);
            current=current.next;

        }

        
        return dummy.next;  //we have to return dummy.next because current is updating on every iteration
    }
};
public class Main {
    static ListNode createList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }
}

