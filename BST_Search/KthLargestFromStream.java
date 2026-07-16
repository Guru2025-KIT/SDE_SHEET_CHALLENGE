import java.util.PriorityQueue;

class KthLargest {

    //TC=O(NLogK)
    //SC=O(k)
    
    // Min-heap to store the 'k' largest elements seen so far
    private final PriorityQueue<Integer> minHeap;
    // The rank of the largest element we need to track
    private final int k;

    /**
     * Initializes the object with the integer k and the stream of integers nums.
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Populate the heap with initial array elements
        for (int num : nums) {
            add(num); 
        }
    }

    /**
     * Appends the integer val to the stream and returns the kth largest element.
     */
    public int add(int val) {
        // Condition 1: If the heap has fewer than 'k' elements, always add the new value
        if (minHeap.size() < k) {
            minHeap.add(val);
        } 
        // Condition 2: Heap is full (size == k). Only add if the new value is larger than the current kth largest
        else if (val > minHeap.peek()) {
            minHeap.poll(); // Evict the smallest of the top 'k' elements
            minHeap.add(val); // Insert the new, larger element
        }

        // The root of the min-heap always represents the kth largest element overall
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// Wrapper class containing the main method to execute the code in VS Code
public class KthLargestFromStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        
        System.out.println("Initializing KthLargest with k = 3 and nums = [4, 5, 8, 2]");
        KthLargest kthLargest = new KthLargest(k, nums);
        
        // Simulating the stream of additions and printing outputs
        System.out.println("Adding 3 -> Returns: " + kthLargest.add(3));   // returns 4
        System.out.println("Adding 5 -> Returns: " + kthLargest.add(5));   // returns 5
        System.out.println("Adding 10 -> Returns: " + kthLargest.add(10)); // returns 5
        System.out.println("Adding 9 -> Returns: " + kthLargest.add(9));   // returns 8
        System.out.println("Adding 4 -> Returns: " + kthLargest.add(4));   // returns 8
    }
}
