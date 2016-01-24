import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * 139. Word Break
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class P139 {
	
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] isVaild = new boolean[s.length()+1];
        isVaild[0] = true;
        for(int i=1; i<=s.length(); i++) {
        	for(int j=i-1; j>=0; j--) {
        		if(isVaild[j] && wordDict.contains(s.substring(j, i))) {
        			isVaild[i] = true;
        			break;
        		}
        	}
        }
        return isVaild[s.length()];
    }
	
//    public boolean wordBreak(String s, Set<String> wordDict) {
//        Set<Integer> length = new HashSet<>();
//        for(String word : wordDict) length.add(word.length());
//        return helper(s, wordDict, length, 0);
//    }
//    
//    public boolean helper(String s, Set<String> wordDict, Set<Integer> length, int start) {
//    	if(start==s.length()) return true;
//    	for(int step : length) {
//    		if(start+step<=s.length() && wordDict.contains(s.substring(start, start+step))) {
//    			if(helper(s, wordDict, length, start+step)) return true;
//    		}
//    	}
//    	return false;
//    }
    
	public static void main(String[] args) {
		P139 test = new P139();
		Set<String> input = new HashSet<>();
		input.add("aa");
		System.out.println(test.wordBreak("aaaaa", input));
	}

}
