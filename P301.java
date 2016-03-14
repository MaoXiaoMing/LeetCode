import java.util.ArrayList;
import java.util.List;

/*301. Remove Invalid Parentheses
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]*/

public class P301 {
	
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    public void dfs(List<String> res, String string, int start, int pre, char[] par) {
    	int stack = 0;
    	for(int i=start; i<string.length(); i++) {
    		if(string.charAt(i) == par[0]) stack++;
    		if(string.charAt(i) == par[1]) stack--;
    		if(stack < 0) {
    			for(int j=pre; j<=i; j++) {
    				if(string.charAt(j)==par[1] && (j==pre || string.charAt(j-1)!=par[1])) {
    					dfs(res, string.substring(0, j)+string.substring(j+1, string.length()), i, j, par);
    				}
    			}
    			return ;
    		}
    	}
    	String reversed = new StringBuilder(string).reverse().toString();
    	if(par[0] == '(') {
    		dfs(res, reversed, 0, 0, new char[]{')', '('});
    	}else {
    		res.add(reversed);
    	}
    }
    
	public static void main(String[] args) {

	}

}
