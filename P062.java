/*
 * 62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
public class P062 {
	
    public int uniquePaths(int m, int n) {
        int[] count = new int[n];
        for(int i=0; i<n; i++) count[i] = 1;
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		count[j] += count[j-1];
        	}
        }
        return count[n-1];
    } 
    
	public static void main(String[] args) {

	}

}
