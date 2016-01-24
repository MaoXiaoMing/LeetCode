import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*140. Word Break II
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].*/
public class P140 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        memo.put(0, new ArrayList<>());
        int maxLength = getMaxLen(wordDict);
        for(int i=1; i<=s.length(); i++) {
        	List<Integer> list = new ArrayList<>();
        	for(int j=Math.max(0, i-maxLength); j<i; j++) {
        		String sub = s.substring(j, i);
        		if(memo.containsKey(j) && wordDict.contains(sub)) {
        			list.add(j);
        		}
        	}
        	if(list.size()!=0) {
        		memo.put(i, list);
        	}
        }
        List<String> result = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        inter.add("");
        genetor(s, memo, inter, result, s.length());
        return result;
    }
    
    public void genetor(String s, Map<Integer, List<Integer>> memo,
    		List<String> inter, List<String> result, int index) {
    	if(index==0) {
    		for(String str : inter) result.add(str.trim());
    		return ;
    	}
    	List<Integer> pre = memo.get(index);
    	if(pre == null) return ;
    	for(int start : pre) {
    		List<String> temp = new ArrayList<>();
    		for(String str : inter) {
    			temp.add(s.substring(start, index)+" "+str);
    		}
    		genetor(s, memo, temp, result, start);
    	}
    }
    
    private int getMaxLen(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(max, s.length());
        }
        return max;
    }
    
//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        List<String> result = new ArrayList<>();
//        Set<Integer> length = new HashSet<>();
//        for(String word : wordDict) length.add(word.length());
//        helper(s, wordDict, length, result, "", 0);
//        return result;
//    }
//    
//    public void helper(String s, Set<String> wordDict, Set<Integer> length,
//    		List<String> res, String inter, int start) {
//    	if(start == s.length()) {
//    		res.add(inter.trim());
//    		return ;
//    	}
//    	for(int step : length) {
//    		if(start+step<=s.length()) {
//    			String str = s.substring(start, start+step);
//    			if(wordDict.contains(str)) {
//    				helper(s, wordDict, length, res, inter+" "+str, start+step);
//    			}
//    		}
//    	}
//    }
    
    public static void genetorInput(String[] inputs, Set<String> wordDict) {
    	for(String str : inputs) 
    		wordDict.add(str);
    }
    
	public static void main(String[] args) {
		P140 test = new P140();
		Set<String> input = new HashSet<>();
		genetorInput(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}
		,input);
		test.wordBreak("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", input);
	}

}
