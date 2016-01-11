import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

/*93. Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class P093 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, "", 0, 0);
        return res;
    }
	
    public void helper(List<String> res, String s, String inter, int part, int start) {
    	if(part==4) {
    		if(start == s.length()) res.add(inter.substring(1));
    		return ;
    	}
    	if(start+1 <= s.length()) helper(res, s, inter+"."+s.charAt(start), part+1, start+1);
    	if(start+2 <= s.length() && s.charAt(start)!='0') {
    		helper(res, s, inter+"."+Integer.parseInt(s.substring(start, start+2)), part+1, start+2);
    	}
    	if(start+3 <= s.length() && s.charAt(start)!='0') {
    		if(Integer.parseInt(s.substring(start, start+3)) < 256) {
    			helper(res, s, inter+"."+Integer.parseInt(s.substring(start, start+3)), part+1, start+3);
    		}
    	}
    }
    
	public static void main(String[] args) {
		P093 p = new P093();
		List<String> res = p.restoreIpAddresses("010010");
	}

}
