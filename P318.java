
/*
 * 318. Maximum Product of Word Lengths
Given a string array words, find the maximum value of length(word[i]) * length(word[j])
where the two words do not share common letters. You may assume that each word will contain only lower case letters.
If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/
public class P318 {
	
    public int maxProduct(String[] words) {
        boolean[][] count = new boolean[words.length][26];
        letterCount(words, count);
        int max = 0;
        for(int i=0; i<words.length; i++) {
        	for(int j=1; j<words.length; j++) {
        		if(!containSameLetter(count, i, j)) {
        			max = Math.max(words[i].length()*words[j].length(), max);
        		}
        	}
        }
        return max;
    }
    
    public void letterCount(String[] words, boolean[][] count) {
    	for(int i=0; i<words.length; i++) {
    		for(int j=0; j<words[i].length(); j++) {
    			count[i][words[i].charAt(j)-'a'] = true;
    		}
    	}
    }
    
    public boolean containSameLetter(boolean[][] count, int index1, int index2) {
    	for(int i=0; i<26; i++) {
    		if(count[index1][i]&&count[index2][i])
    			return true;
    	}
    	return false;
    }
    
	public static void main(String[] args) {

	}

}
