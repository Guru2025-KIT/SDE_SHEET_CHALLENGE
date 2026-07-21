package Random_Problems;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1; // For Enqueue operations
    private Stack<Integer> stack2; // For Dequeue/Peek operations

    // Initialize your data structure here.
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Push element x to the back of the queue.
    public void push(int x) {
        stack1.push(x);
    }
    
    // Removes the element from the front of the queue and returns it.
    public int pop() {
        shiftStacks();
        return stack2.pop();
    }
    
    // Get the front element.
    public int peek() {
        shiftStacks();
        return stack2.peek();
    }
    
    // Returns whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Helper method to move elements from stack1 to stack2 when stack2 is empty
    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

}

public class ImplementQueueFromStack{


    // Main method to run and test in VS Code
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println("--- Queue Operations ---");
        
        queue.push(1); // Queue looks like: [1]
        System.out.println("Pushed: 1");
        
        queue.push(2); // Queue looks like: [1, 2]
        System.out.println("Pushed: 2");
        
        System.out.println("Peek front: " + queue.peek()); // Returns 1
        System.out.println("Popped front: " + queue.pop()); // Returns 1, Queue looks like: [2]
        
        System.out.println("Queue empty? " + queue.empty()); // Returns false
        System.out.println("Popped front: " + queue.pop()); // Returns 2, Queue is empty
        System.out.println("Queue empty? " + queue.empty()); // Returns true
        
        System.out.println("------------------------");
    }
}

