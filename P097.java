
/*
 * 97. Interleaving String
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
public class P097 {
    
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length()) return false;
		boolean[][] isMatch = new boolean[s1.length()+1][s2.length()+1];
		isMatch[0][0] = true;
		for(int row=1; row<=s1.length(); row++) 
			isMatch[row][0] = isMatch[row-1][0]&&s1.charAt(row-1)==s3.charAt(row-1);
		for(int col=1; col<=s2.length(); col++) 
			isMatch[0][col] = isMatch[0][col-1]&&s2.charAt(col-1)==s3.charAt(col-1);
		for(int row=1; row<=s1.length(); row++) {
			for(int col=1; col<=s2.length(); col++) {
				isMatch[row][col] = (isMatch[row-1][col]&&s3.charAt(row+col-1)==s1.charAt(row-1)) 
						|| (isMatch[row][col-1]&&s3.charAt(row+col-1)==s2.charAt(col-1));
			}
		}
		return isMatch[s1.length()][s2.length()];
//		if(s1.length()+s2.length() != s3.length()) return false;
//        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    
//	public boolean isInterleave(String s1, int index1, String s2, int index2,
//			String s3, int index3) {
////		if(index1==s1.length()&&index2==s2.length()&&index3==s3.length()) return true;
////		if(index1<s1.length()) {
////			if(s1.charAt(index1)==s3.charAt(index3) && isInterleave(s1, index1+1, s2, index2, s3, index3+1))
////				return true;
////		}
////		if(index2<s2.length()) {
////			if(s2.charAt(index2)==s3.charAt(index3) && isInterleave(s1, index1, s2, index2+1, s3, index3+1))
////				return true;
////		}
////		return false;
////		if(index1==s1.length()) 
////			return s2.charAt(index2)==s3.charAt(index2+index1)
////			&&isInterleave(s1, index1, s2, index2+1, s3, index3);
////		else if(index2==s2.length())
////			return s1.charAt(index1)==s3.charAt(index1+index2)
////			&&isInterleave(s1, index1+1, s2, index2, s3, index3);
////		else {
////			return (s1.charAt(index1)==s3.charAt(index1+index2)
////					&&isInterleave(s1, index1+1, s2, index2, s3, index3))
////					|| (s2.charAt(index2)==s3.charAt(index2+index1)
////							&&isInterleave(s1, index1, s2, index2+1, s3, index3));
//	}
	
	public static void main(String[] args) {
		P097 test = new P097();
		test.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
				"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
				"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
	}

}
