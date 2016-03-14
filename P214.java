
/*214. Shortest Palindrome
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".*/
public class P214 {
    public String shortestPalindrome(String s) {
        if(s==null || s.length()==0) return s;
    	String temp = s+"#"+new StringBuilder(s).reverse().toString();
    	int next[] = new int[temp.length()];
    	int index = 0;
    	for(int i=1; i<temp.length(); i++) {
    		if(temp.charAt(index) == temp.charAt(i)) {
    			next[i] = next[i-1]+1;
    			index++;
    		}else {
    			index = next[i-1];
    			while(index>0 && temp.charAt(index)!=temp.charAt(i))
    				index = next[index-1];
    			if(s.charAt(index) == s.charAt(i)) index++;
    			next[i] = index;
    		}
    	}
    	String patch = new StringBuilder(s.substring(next[temp.length()-1])).reverse().toString();
    	return patch+s;
    }
    
    public static void main(String[] args) {
    	P214 test = new P214();
    	test.shortestPalindrome("aacecaaa");
    }
    
}
