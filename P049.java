import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
public class P049 {
	class comp implements Comparator {
		@Override
		public int compare(Object arg0, Object arg1) {
			String s1 = arg0.toString();
			String s2 = arg1.toString();
			for(int i=0; i<s1.length()&&i<s2.length(); i++) {
				if(s1.charAt(i) < s2.charAt(i)) return -1;
				else if(s1.charAt(i) > s2.charAt(i)) return 1;
			}
			if(s1.length() == s2.length()) return 0;
			else if(s1.length()<s2.length()) return -1;
			else return 1;
		}
	}
	
	public String convert(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<nums.length; i++) {
			sb.append(i+""+nums[i]);
		}
		return sb.toString();
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[][] count = new int[strs.length][26];
        for(int i=0; i<strs.length; i++) {
        	for(int j=0; j<strs[i].length(); j++) count[i][strs[i].charAt(j)-'a']++;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
        	String key = convert(count[i]);
        	if(map.containsKey(key)) {
        		List<String> list = map.get(key);
        		list.add(strs[i]);
        	}else {
        		List<String> list = new ArrayList<>();
        		list.add(strs[i]);
        		map.put(key, list);
        	}
        }
        for(List<String> list : map.values()) {
        	list.sort(new comp());
        	res.add(list);
        }
        return res;
    }
	
	public static void main(String[] args) {
		P049 p = new P049();
		p.groupAnagrams(new String[]{"eat", "tea"});
	}

}
