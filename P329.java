
/*329. Longest Increasing Path in a Matrix
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.*/
public class P329 {
	
    public int longestIncreasingPath(int[][] matrix) {
    	if(matrix==null ||matrix.length==0 || matrix[0].length==0) return 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        return helper(matrix, memo);
    }
    
    public int helper(int[][] matrix, int[][] memo) {
    	int max = 0;
    	for(int i=0; i<memo.length; i++) {
    		for(int j=0; j<memo[i].length; j++) {
    			if(memo[i][j]==0) {
    				max = Math.max(max, helper(matrix, memo, i, j));
    			}
    		}
    	}
    	return max;
    }
    
    public int helper(int[][] matrix, int[][] memo, int row, int col) {
    	if(memo[row][col] != 0) return memo[row][col];
    	int max = 1;
    	if(row-1>=0 && matrix[row][col]<matrix[row-1][col]) 
    		max = Math.max(max, helper(matrix, memo, row-1, col)+1); 
    	if(row+1<matrix.length && matrix[row][col]<matrix[row+1][col])
    		max = Math.max(max, helper(matrix, memo, row+1, col)+1);
    	if(col-1>=0 && matrix[row][col]<matrix[row][col-1])
    		max = Math.max(max, helper(matrix, memo, row, col-1)+1);
    	if(col+1<matrix[row].length && matrix[row][col]<matrix[row][col+1])
    		max = Math.max(max, helper(matrix, memo, row, col+1)+1);
    	return memo[row][col]=max;
    }
    
	public static void main(String[] args) {
		P329 test = new P329();
		System.out.println(test.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
	}

}
