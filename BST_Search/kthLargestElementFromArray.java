import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Keep the heap size equal to k
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }
        
        // The top of the heap is the kth largest element
        return minHeap.peek();
    }
}
public class kthLargestElementFromArray {
    public static void main(String[] args) {
    
        int[] arr1=new int[]{3,2,1,5,6,4};
        int[] arr2=new int[]{3,2,3,1,2,4,5,5,6};

        Solution sol=new Solution();
        System.out.println("Array 1 Answer:"+sol.findKthLargest(arr1,2));
        System.out.println("Array 2 Answer:"+sol.findKthLargest(arr2,4));
    
    }
}
