import java.util.HashMap;
import java.util.Map;

/*
 * 87. Scramble String
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
class Info{
	Info(int s1, int s2, int end) {
		this.start1 = s1;
		this.start2 = s2;
		this.end1 = end;
	}
	int start1;
	int start2;
	int end1;
}
public class P087 {
	
    public boolean isScramble(String s1, String s2) {
    	if(s1==null || s2==null) return false;
        Map<Info, Boolean> memo = new HashMap<>();
        return isScamble(memo, s1, s2, new Info(0, 0, s1.length()-1));
    }
    
    public boolean isScamble(Map<Info, Boolean> memo, String s1, String s2, Info key) {
    	if(memo.containsKey(key)) return memo.get(key); 
    	if(key.start1==key.end1) {
    		memo.put(key, s1.charAt(key.start1)==s2.charAt(key.start2));
    		return memo.get(key);
    	}
    	int[] count = new int[26];
    	for(int i=0; i<=key.end1-key.start1; i++) {
    		count[s1.charAt(i+key.start1)-'a']++;
    		count[s2.charAt(i+key.start2)-'a']--;
    	}
    	for(int i=0; i<count.length; i++) if(count[i]!=0) return false;
    	for(int i=key.start1; i<key.end1; i++) {
    		if((isScamble(memo, s1, s2, new Info(key.start1, key.start2, i)) 
    				&& isScamble(memo, s1, s2, new Info(i+1, key.start2+i+1-key.start1, key.end1))) 
    				|| (isScamble(memo, s1, s2, new Info(key.start1, key.start2+key.end1-i, i)) 
    						&& isScamble(memo, s1, s2, new Info(i+1, key.start2, key.end1)))) {
    			memo.put(key, true);
    			return true;
    		}
    	}
    	memo.put(key, false);
    	return false;
    }
    
	public static void main(String[] args) {
		P087 test = new P087();
		System.out.println(test.isScramble("abcdefghijklmn", "efghijklmncadb"));
	}
}
