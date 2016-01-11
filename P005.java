/*
 * Longest Palindromic Substring
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * */

public class P005 {
	
    public static String longestPalindrome(String s) {
    	if(s==null || s.length()==1) return s;
    	int start = 0;
    	int length = 1;
    	boolean[][] mem = new boolean[s.length()][s.length()];
    	for(int i=1; i<s.length(); i++) {
    		mem[i][i] = true;
    		for(int j=0; j<s.length()-i; j++) {
    			if(s.charAt(j)==s.charAt(j+i)){
    				if(i <= 2 || mem[j+1][j+i-1]) { 
    					mem[j][j+i] = true; 
    					if(length < i+1) {
    						length = i+1;
    						start = j;
    					}
    				}
    			} 
    		}
    	}
        return s.substring(start, start+length);
    }
    
    public static void main(String[] args) {
    	System.out.println(longestPalindrome("abb"));
    }
    
}
