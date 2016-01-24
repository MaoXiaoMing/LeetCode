import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 316. Remove Duplicate Letters
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/
public class P316 {
	
    public String removeDuplicateLetters(String s) {
    	char[] chars = s.toCharArray();
    	int length = s.length();
    	int end = -1;
    	int[] count = new int[26];
    	for(char c : chars) count[c-'a']++;
    	boolean[] isAccepted = new boolean[26];
    	for(int i=0; i<length; i++) {
    		char c = chars[i];
    		if(isAccepted[c-'a']==true) {
    			count[c-'a']--;
    			continue;
    		}
    		char pre;
    		while(end>=0 && (pre=chars[end])>c && count[pre-'a']>0) {
    			isAccepted[pre-'a'] = false;
    			end--;
    		}
    		chars[++end] = c;
    		count[c-'a']--;
    		isAccepted[c-'a'] = true;
    	}
    	return String.valueOf(chars).substring(0, end+1);
    }
    
	public static void main(String[] args) {
		P316 test = new P316();
		test.removeDuplicateLetters("bcabc");
	}

}
