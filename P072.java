
/*
 * 72. Edit Distance
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class P072 {
	
    public int minDistance(String word1, String word2) {
    	if(word1==null || word2==null || (word1.length()==0&&word2.length()==0)) return 0;
    	int[][] memo = new int[word1.length()][word2.length()];
        return dp(word1, word1.length()-1, word2, word2.length()-1, memo);
    }
    
    public int dp(String word1, int index1, String word2, int index2, int[][] memo) {
    	if(index1==-1||index2==-1) return Math.max(index1, index2)+1;
    	if(memo[index1][index2] != 0) return memo[index1][index2];
    	if(word1.charAt(index1) == word2.charAt(index2)) 
    		return memo[index1][index2] = dp(word1, index1-1, word2, index2-1, memo);
    	int insert1 = dp(word1, index1, word2, index2-1, memo)+1;
    	int insert2 = dp(word1, index1-1, word2, index2, memo)+1;
//    	int delete1 = dp(word1, index1-1, word2, index2, memo)+1;
//    	int delete2 = dp(word1, index1, word2, index2-1, memo)+1;
    	int replace = dp(word1, index1-1, word2, index2-1, memo)+1;
    	int min = Integer.MAX_VALUE;
    	min = min>insert1?insert1:min;
    	min = min>insert2?insert2:min;
//    	min = min>delete1?delete1:min;
//    	min = min>delete2?delete2:min;
    	min = min>replace?replace:min;
    	return memo[index1][index2] = min;
    }
    
	public static void main(String[] args) {
		P072 test = new P072();
		System.out.println(test.minDistance("fji", "fhi"));
	}

}
