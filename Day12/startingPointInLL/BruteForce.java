package Day12.startingPointInLL;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {

        //Brute Force Approach TC=SC= O(N) Using HashMap
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;

        while(temp!=null){
            if(map.containsKey(temp)){
                return temp;
            }

            map.put(temp,temp.val);
            temp=temp.next;
        }

        return null;
        
    }
}

public class BruteForce {
    public static void main(String[] args) {
        // Creating linked list nodes
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating a cycle (tail connects to node index 1)
        head.next.next.next.next = head.next;

        Solution obj = new Solution();
        ListNode startNode = obj.detectCycle(head);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.val);
        else
            System.out.println("No cycle found.");
    }
}

