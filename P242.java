import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.*/

public class P242 {
	/*public boolean isAnagram(String s, String t) {
        int[] sCharMap = new int[26]; // initialized to be 0s by default in Java!
        for(int i=0; i<s.length(); i++) {
            int mapIdx = s.charAt(i)-97;
            sCharMap[mapIdx] = sCharMap[mapIdx] + 1;
        }
        for (int i=0; i<t.length(); i++) {
            int mapIdx = t.charAt(i)-97;
            if (sCharMap[mapIdx] == 0)
                return false;
            else
                sCharMap[mapIdx] = sCharMap[mapIdx] - 1;
        }
        // verify the sCharMap
        int acc = 0;
        for (int i=0; i<sCharMap.length; i++)
            acc += sCharMap[i];
        return acc==0 ? true : false;
    }*/
	
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
        	return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
        	if(!mapS.containsKey(s.charAt(i))) {
        		mapS.put(s.charAt(i), 1);
        	}else {
        		mapS.put(s.charAt(i), mapS.get(s.charAt(i))+1);
        	}
        	if(!mapT.containsKey(t.charAt(i))) {
        		mapT.put(t.charAt(i), 1);
        	}else {
        		mapT.put(t.charAt(i), mapT.get(t.charAt(i))+1);
        	}
        }
        if(mapT.size() != mapS.size()) {
        	return false;
        }else {
        	Iterator<Character> iter = mapS.keySet().iterator();
        	while(iter.hasNext()) {
        		char key = iter.next();
        		if(!mapT.containsKey(key) || mapT.get(key).intValue() != mapS.get(key).intValue()) {
        			return false;
        		}
        	}
        	return true;
        }
    }
	
	public static void main(String[] args) throws Exception {
		String s1, s2;
		BufferedReader br = new BufferedReader(new FileReader("Path.txt"));
		s1 = br.readLine();
		s2 = br.readLine();
		br.close();
		Util.p(new P242().isAnagram(s1, s2));
	}
}
