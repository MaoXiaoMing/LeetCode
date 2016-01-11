import java.util.HashMap;
import java.util.Map;

/*
 * Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

public class P290 {

	public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");
        char[] array = pattern.toCharArray();
        if(array.length != tokens.length) {
        	return false;
        }
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> stringMap = new HashMap<>();
        for(int i=0; i<array.length; i++) {
        	if(charMap.containsKey(array[i]) 
        			|| stringMap.containsKey(tokens[i])) {
        		if(!charMap.containsKey(array[i]) 
        			|| !stringMap.containsKey(tokens[i])) {
        			return false;
        		}
        	}else {
        		charMap.put(array[i], tokens[i]);
        		stringMap.put(tokens[i], array[i]);
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Util.p(new P290().wordPattern("abba", "dog dog dog dog"));
	}

}
