import java.util.HashMap;
import java.util.Map;

/*
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * */

public class P003 {

    public static int lengthOfLongestSubstring(String s) {
    	if(s==null || s.length()==0) return 0;
    	Map<Character, Integer> record = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
        	char chr = s.charAt(i);
        	if(record.containsKey(chr)) {
        		max = max<i-start?i-start:max;
        		start = start<=record.get(chr)?record.get(chr)+1:start;
        		record.put(chr, i);
        	}else {
        		record.put(chr, i);
        	}
        }
        max = max<s.length()-start?s.length()-start:max;
        return max;
    }
	
	public static void main(String[] args) {
		lengthOfLongestSubstring("abcabcbb");
	}

}
