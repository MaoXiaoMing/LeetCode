import java.util.Stack;

/*
 * 71. Simplify Path
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.
*/
public class P071 {
	
    public String simplifyPath(String path) {
        String[] tokens = path.split("\\/");
        Stack<String> stack = new Stack<>();
        for(String token : tokens) {
        	if(token.equals(".")) continue;
        	else if(token.equals("..")) {
        		if(!stack.isEmpty())
        			stack.pop();
        	}
        	else if(!token.equals("")) 
        		stack.push(token);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder("");
        for(String token : stack) {
        	sb.append('/'+token);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	P071 test = new P071();
    	System.out.println(test.simplifyPath("/.."));
    }
    
}
