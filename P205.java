import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.*/
public class P205 {
	public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(!map.containsKey(c)) {
        		Collection<Character> set = map.values();
        		if(set.contains(t.charAt(i))) {
        			return false;
        		}else{
        			map.put(c, t.charAt(i));
        		}
        	}else {
        		if(map.get(c) != t.charAt(i)) {
        			return false;
        		}
        	}
        }
        return true;
    }
}
