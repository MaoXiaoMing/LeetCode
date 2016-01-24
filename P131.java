import java.util.ArrayList;
import java.util.List;

public class P131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        dfs(s, 0, res, inter);
        return res;
    }
	
    public void dfs(String s, int start, List<List<String>> res, List<String> inter) {
    	if(start==s.length()) {
    		res.add(new ArrayList<>(inter));
    		return ;
    	}
    	for(int i=start; i<s.length(); i++) {
    		if(isPalindrome(s, start, i)) {
    			inter.add(s.substring(start, i+1));
    			dfs(s, i+1, res, inter);
    			inter.remove(inter.size()-1);
    		}
    	}
    }
    
    public boolean isPalindrome(String s, int start, int end) {
    	while(start<end) {
    		if(s.charAt(start)!=s.charAt(end)) return false;
    		start++;
    		end--;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		P131 test = new P131();
		test.partition("abcba");
	}

}
