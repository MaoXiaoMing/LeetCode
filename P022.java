import java.util.ArrayList;
import java.util.List;

/*
 * 22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class P022 {
	
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(n, 0, 0, "", res);
        return res;
    }
    
    public void generateParenthesis(int n, int l, int r, String inter, List<String> res) {
    	if(l == n) {
    		StringBuilder sb = new StringBuilder();
    		while(r < n) {
    			sb.append(")");
    			r++;
    		}
    		res.add(inter+sb.toString());
    		return ;
    	}
    	generateParenthesis(n, l+1, r, inter+"(", res);
    	if(r < l) generateParenthesis(n, l, r+1, inter+")", res);
    }
    
    
	public static void main(String[] args) {

	}

}
