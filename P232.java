import java.util.Stack;

/*
 * Implement Queue using Stacks
 * Implement the following operations of a queue using stacks.

	push(x) -- Push element x to the back of queue.
	pop() -- Removes the element from in front of queue.
	peek() -- Get the front element.
	empty() -- Return whether the queue is empty.
	
	Notes:
	You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
*/

class MyQueue {
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	// Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack2.isEmpty()) {
        	stack2.pop();
        }else {
        	while(!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
        	stack2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!stack2.isEmpty()) {
        	return stack2.peek();
        }else {
        	while(!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
        	return stack2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
        	return true;
        }else{
        	return false;
        }
    }
}

public class P232 {
	
}
