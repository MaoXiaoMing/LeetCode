import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*241. Different Ways to Add Parentheses
Given a string of numbers and operators, return all possible results from computing all 
		the different possible ways to group numbers and operators. 
		The valid operators are +, - and *.*/
public class P241 {
	
    public List<Integer> diffWaysToCompute(String input) {
    	String[] split = input.split("(\\*|\\+|\\-)");
    	char[] oper = new char[split.length-1];
    	for(int i=0,index = split[0].length(); i<oper.length; i++, index+=split[i].length()+1)
    		oper[i] = input.charAt(index);
//    	Map<int[], List<Integer>> memo = new HashMap<>();
    	return helper(split, oper, 0, split.length-1);
    }
    
    public List<Integer> helper(String[] split, char[] oper,
    		int start, int end) {
    	List<Integer> res = new ArrayList<>();
    	if(start == end) {
    		res.add(Integer.parseInt(split[start]));
    		return res;
    	}
    	for(int i=start; i<end; i++) {
    		List<Integer> leftList = helper(split, oper, start, i);
    		List<Integer> rightList = helper(split, oper, i+1, end);
    		for(int left:leftList) {
    			for(int right:rightList) {
    				switch (oper[i]) {
    				case '+':
    					res.add(left+right);
    					break;
    				case '-':
    					res.add(left-right);
    					break;
    				case '*':
    					res.add(left*right);
    					break;
    				}
    			}
    		}
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		String input = "42-24+3-41";
		String[] split = input.split("(\\*|\\+|\\-)");
		P241 p = new P241();
		List<Integer> list = p.diffWaysToCompute(input);
	}

}
