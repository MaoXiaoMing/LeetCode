
/*
 * 44. Wildcard Matching
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class P044 {

    public boolean isMatch(String s, String p) {
    	boolean[][] isMatch = new boolean[s.length()+1][p.length()+1];
    	isMatch[0][0] = true;
    	for(int i=1; i<=p.length(); i++) 
    		if(p.charAt(i-1)=='*') 
    			isMatch[0][i] = true;
    		else break;
    	for(int i=1; i<=s.length(); i++) {
    		for(int j=1; j<=p.length(); j++) {
    			char c = p.charAt(j-1);
    			if(c=='*') {
    				isMatch[i][j] = isMatch[i][j-1] || isMatch[i-1][j];
    			}else {
    				if(isMatch[i-1][j-1] && (c=='?' || s.charAt(i-1)==c))
    					isMatch[i][j] = true;
    			}
    		}
    	}
    	return isMatch[s.length()][p.length()];
    }
	
//    public boolean isMatch(String s, String p) {
//        return helper(s, p, 0, 0);
//    }
//    
//    public boolean helper(String s, String p, int indexS, int indexP) {
//    	if(indexP==p.length()) return indexS==s.length();
//    	char cP = p.charAt(indexP);
//    	if(cP == '*') {
//    		for(int i=indexS; i<=s.length(); i++) {
//    			if(helper(s, p, i, indexP+1)) return true;
//    		}
//    		return false;
//    	}else if(cP == '?') {
//    		if(indexS == s.length()) return false;
//    		return helper(s, p, indexS+1, indexP+1);
//    	}else {
//    		if(indexS==s.length() || s.charAt(indexS)!=cP) return false;
//    		return helper(s, p, indexS+1, indexP+1);
//    	}
//    }
     
	public static void main(String[] args) {
		P044 test = new P044();
		System.out.println(test.isMatch("aab", "c*a*b"));
	}

}
