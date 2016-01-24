import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 282. Expression Add Operators
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/
public class P282 {
	
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        recursion(num, target, "", 0, res, 0, 0);
        return res;
    }
    
    public void recursion(String num, int target, String path,
    		int start, List<String> res, long pre, long part) {
    	if(start == num.length()) {
    		if(pre == target) 
    			res.add(path);
    		return ;
    	}
    	for(int i=start; i<num.length(); i++) {
    		if(i!=start && num.charAt(start)=='0') break;
    		Long l = Long.parseLong(num.substring(start, i+1));
    		if(start == 0)
    			recursion(num, target, path+l, i+1, res, l, l);
    		else {
    			recursion(num, target, path+"+"+l, i+1, res, pre+l, l);
    			recursion(num, target, path+"-"+l, i+1, res, pre-l, -l);
    			recursion(num, target, path+"*"+l, i+1, res, pre-part+part*l, part*l);
    		}
    	}
    }
    
	public static void main(String[] args) {
		P282 test = new P282();
		Util.displayList(test.addOperators("123", 6));
	}

}
