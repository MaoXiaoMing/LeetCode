import java.util.ArrayList;
import java.util.List;

/*
 * 68. Text Justification
Given an array of words and a length L,
format the text such that each line has exactly L characters and is fully(left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words,
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
*/
		
public class P068 {
	
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList<>();
    	if(words==null || words.length==0) return res;
    	int wordLength = 0;
    	int start = 0;
    	int actLength = 0;
    	for(int i=0; i<words.length; i++) {
    		if(wordLength+words[i].length() > maxWidth) {
    			if(i-start == 1) {
    				StringBuilder sb = new StringBuilder();
    				sb.append(words[start]);
    				for(int j=words[start].length(); j<maxWidth; j++)
    					sb.append(' ');
    				res.add(sb.toString());
    			}else {
    				int spaceNums = maxWidth-actLength;
        			int spaceAve = spaceNums/(i-start-1);
        			int preCount = spaceNums-(i-start-1)*spaceAve;
        			StringBuilder sb = new StringBuilder();
        			String space = "";
        			for(int j=0; j<spaceAve; j++) space += " ";
        			sb.append(words[start]);
        			for(int j=0; j<preCount; j++) {
        				sb.append(space+" "+words[j+start+1]);
        			}
        			for(int j=start+preCount+1; j<i; j++) {
        				sb.append(space+words[j]);
        			}
        			for(int j=sb.length(); j<maxWidth; j++) sb.append(' ');
        			res.add(sb.toString());
    			}
    			start = i;
    			wordLength = 0;
    			actLength = 0;
    		}
    		wordLength += words[i].length()+1;
    		actLength += words[i].length();
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i=start; i<words.length; i++) {
    		sb.append(words[i]+" ");
    	}
    	sb.delete(sb.length()-1, sb.length());
    	for(int i=sb.length(); i<maxWidth; i++) sb.append(" ");
    	res.add(sb.toString());
    	return res;
    }
    
	public static void main(String[] args) {
		P068 test = new P068();
//		test.fullJustify(new String[]{"Testx", "a", "manyxv", "a","b","c"}, 6);
		test.fullJustify(new String[]{"a","b","c","aaaaa"}, 6);
	}

}
