/*
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * */
public class P064 {
	
    public int minPathSum(int[][] grid) {
        for(int i=1; i<grid[0].length; i++) {
        	grid[0][i]+=grid[0][i-1];
        }
        for(int i=1; i<grid.length; i++) {
        	grid[i][0] += grid[i-1][0];
        	for(int j=1; j<grid[i].length; j++) {
        		grid[i][j] += grid[i-1][j]<grid[i][j-1]?grid[i-1][j]:grid[i][j-1];
        	}
        }
        return grid[grid.length-1][grid[grid.length-1].length-1];
    }
    
	public static void main(String[] args) {

	}

}
