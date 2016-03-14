import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*336. Palindrome Pairs
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]*/
public class P336 {
	
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) map.put(words[i], i);
        for(int i=0; i<words.length; i++) {
        	String rev = new StringBuilder(words[i]).reverse().toString();
        	if(map.containsKey(rev) && map.get(rev)!=i) {
        		List<Integer> list = new ArrayList<>();
        		list.add(i); list.add(map.get(rev));
        		res.add(list);
        	}
        	if(map.containsKey("") && rev.equals(words[i]) && map.get("")!=i) {
        		List<Integer> list = new ArrayList<>();
        		list.add(i); list.add(map.get(""));
        		res.add(list);
        		list = new ArrayList<>();
        		list.add(map.get("")); list.add(i); 
        		res.add(list);
        	}
        	int index = 0;
        	while(index < words[i].length()-1) {
        		String pre = rev.substring(0, index+1);
        		if(map.containsKey(pre)) {
        			String remainder = words[i].substring(0, words[i].length()-index-1);
        			if(rev.substring(index+1).equals(remainder)) {
        				List<Integer> list = new ArrayList<>();
        				list.add(map.get(pre)); list.add(i); 
        				res.add(list);
        			}
        		}
        		index++;
        	}
        	index = 0;
        	while(index < words[i].length()-1) {
        		String last = rev.substring(words[i].length()-1-index);
        		if(map.containsKey(last)) {
        			String rem = words[i].substring(index+1);
        			if(rev.substring(0, rev.length()-1-index).equals(rem)) {
        				List<Integer> list = new ArrayList<>();
        				list.add(i);  list.add(map.get(last)); 
        				res.add(list);
        			}
        		}
        		index++;
        	} 
        }
        return res;
    }
}
