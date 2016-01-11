import java.util.Stack;

/*
 * Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
public class P020 {

	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
        	char next = s.charAt(i);
        	if(next=='('||next=='['||next=='{') {
        		stack.push(next);
        	}else {
        		if(stack.isEmpty()) return false;
        		if(next==')') {
        			if(stack.pop() != '(') return false;
        		}else if(next==']') {
        			if(stack.pop() != '[') return false;
        		}else if(next=='}') {
        			if(stack.pop() != '{') return false;
        		}else {
        		    return false;
        		}
        	}
        }
        return stack.isEmpty()?true:false;
    }
	
	public static void main(String[] args) {

	}

}
