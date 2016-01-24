import java.util.Stack;

public class P032 {
	
    public int longestValidParentheses(String s) {
    	int max = 0;
    	int[] memo = new int[s.length()];
    	for(int i=1; i<s.length(); i++) {
    		if(s.charAt(i) == ')') {
    			int j=i-1;
    			boolean isMatch = false;
    			while(j >= 0) {
    				if(s.charAt(j) == '(') {
    					if(isMatch) break;
    					isMatch = true;
    					j--;
    				}else {
    					if(memo[j] == 0) break;
    					j -= memo[j];
    				}
    			}
    			if(isMatch) {
    				memo[i] = i-j;
    				max = Math.max(max,  memo[i]);
    			}
    		} 
    	}
    	return max;
    	//TLE
//    	Stack<Integer> stack = new Stack<>();
//    	int max = 0;
//    	int left = 0;
//    	for(int i=0; i<s.length(); i++) {
//    		char c = s.charAt(i);
//    		if(c=='(') stack.push(i);
//    		else {
//    			if(stack.isEmpty()) left = i;
//    			else {
//    				stack.pop();
//    				if(stack.empty()) max = Math.max(max, i-left);
//    				else max = Math.max(max, i-stack.peek());
//    			}
//    		}
//    	}
//    	return max;
    	//TLE
//        int max = 0;
//        int[] length = new int[s.length()];
//        for(int i=1; i<s.length(); i++) {
//        	if(s.charAt(i)=='(') length[i] = 0;
//        	else if(i-length[i-1]-1>=0 && s.charAt(i-length[i-1]-1)=='(') {
//        		if(i-length[i-1]-1==0) length[i] = i+1;
//        		else length[i] = length[i-1]+2+length[i-length[i-1]-2];
//        	}
//        	else length[i] = 0;
//        	max = max>length[i]?max:length[i];
//        }
//        return max;
    }
    
	public static void main(String[] args) {
		P032 test = new P032();
		test.longestValidParentheses("");
	}

}
