import java.util.LinkedList;
import java.util.Queue;

/*
 * Implement Stack using Queues
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
*/

public class P225 {
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();
	
	public void push(int x) {
        if(!queue2.isEmpty()) {
        	queue2.offer(x);
        }else {
        	queue1.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue1.isEmpty()) {
        	int count = queue1.size()-1;
        	while(count > 0) {
        		queue2.offer(queue1.poll());
        		count--;
        	}
        	queue1.poll(); 
        }else {
        	int count = queue2.size()-1;
        	while(count > 0) {
        		queue1.offer(queue2.poll());
        		count--;
        	}
        	queue2.poll(); 
        }
    }

    // Get the top element.
    public int top() {
        if(!queue1.isEmpty()) {
        	int count = queue1.size()-1;
        	while(count > 0) {
        		queue2.offer(queue1.poll());
        		count--;
        	}
        	int res = queue1.poll();
        	queue2.offer(res);
        	return res;
        }else {
        	int count = queue2.size()-1;
        	while(count > 0) {
        		queue1.offer(queue2.poll());
        		count--;
        	}
        	int res = queue2.poll();
        	queue1.offer(res);
        	return res;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
        	return true;
        }else {
        	return false;
        }
    }
    
    public static void main(String[] args) {
    	P225  test = new P225();
    	test.push(1);
    	test.push(2);
    	System.out.println(test.top());
    }
    
}
