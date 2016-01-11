import java.util.Stack;


/*
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.*/

public class P155 {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> auxil = new Stack<>();
	
	public void push(int x) {
		stack.push(x);
		//可提前压入Integer_MAX
		if(auxil.isEmpty()) {
			auxil.push(x);
			return ;
		}
		if(x < auxil.peek()) {
			auxil.push(x);
		}else {
			auxil.push(auxil.peek());
		}
    }

    public void pop() {
        stack.pop();
        auxil.pop();
    }

    public int top() {
    	return stack.peek();
    }

    public int getMin() {
    	return auxil.peek();
    }
    
	public static void main(String[] args) {

	}

}
