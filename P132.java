
/*132. Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.*/
public class P132 {
	
    public int minCut(String s) {
    	if(s==null || s.length()==0) return 0;
    	char[] c = s.toCharArray();
    	int[] memo = new int[s.length()];
    	boolean[][] isPal = new boolean[s.length()][s.length()];
    	for(int end=1; end<s.length(); end++) {
    		int min = end;
    		for(int start=0; start<=end; start++) {
    			if(c[start]==c[end] && (start+1>end-1 || isPal[start+1][end-1])) {
    				isPal[start][end] = true;
    				//需要特别注意的地方
    				min = start==0?0:Math.min(min, memo[start-1]+1);
    			}
    		}
    		memo[end] = min;
    	}
    	return memo[s.length()-1];
/*    	for(int end=1; end<s.length(); end++) {
    		int min = end;
    		for(int start=0; start<=end; start++) {
    			if(s.charAt(start)==s.charAt(end) && (start+1>end-1 || isPal[start+1][end-1])) {
    				isPal[start][end] = true;
    				//需要特别注意的地方
    				min = start==0?0:Math.min(min, memo[start-1]+1);
    			}
    		}
    		memo[end] = min;
    	}
    	return memo[s.length()-1];*/
//    	int[][] memo = new int[s.length()][s.length()];
//    	for(int gap=1; gap<s.length(); gap++) {
//    		for(int start=0; start+gap<s.length(); start++) {
//    			if(s.charAt(start)==s.charAt(start+gap) && memo[start+1][start+gap-1]==0)
//    				continue;
//    			int min = Integer.MAX_VALUE;
//    			for(int k=start; k<start+gap; k++) 
//    				min = Math.min(min, memo[start][k]+memo[k+1][start+gap]+1);
//    			memo[start][start+gap] = min;
//    		}
//    	}
//    	return memo[0][s.length()-1];
    }
    
	public static void main(String[] args) {
		P132 test = new P132();
		System.out.println(test.minCut("abaaaaa"));
	}

}
