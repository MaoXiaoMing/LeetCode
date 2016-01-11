import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P017 {
	private Map<Character, char[]> cache = new HashMap<>();
	
    public List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<String>();
    	if(digits==null || digits.length()==0) return res;
    	cache.put('2', new char[]{'a', 'b', 'c'});
    	cache.put('3', new char[]{'d', 'e', 'f'});
    	cache.put('4', new char[]{'g', 'h', 'i'});
    	cache.put('5', new char[]{'j', 'k', 'l'});
    	cache.put('6', new char[]{'m', 'n', 'o'});
    	cache.put('7', new char[]{'p', 'q', 'r', 's'});
    	cache.put('8', new char[]{'t', 'u', 'v'});
    	cache.put('9', new char[]{'w', 'x', 'y', 'z'});
        String inter = "";
        dfs(digits, 0, inter, res);
        return res;
    }
    
    public void dfs(String digits, int start, String inter, List<String> res) {
    	if(start == digits.length()) {
    		res.add(inter);
    		return ;
    	}
    	char[] chars = cache.get(digits.charAt(start));
    	if(chars == null) return ;
    	for(char c : chars) {
    		dfs(digits, start+1, inter+c, res);
    	}
    }
    
	public static void main(String[] args) {

	}

}
