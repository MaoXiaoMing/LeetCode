
/*
 * 63. Unique Paths II
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 * */

public class P063 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] count = new int[obstacleGrid[0].length];
        for(int i=0; i<count.length; i++) {
        	if(obstacleGrid[0][i] == 1) break;
        	count[i] = 1;
        }
        for(int i=1; i<obstacleGrid.length; i++) {
        	if(obstacleGrid[i][0]==1) count[0] = 0;
        	for(int j=1; j<obstacleGrid[i].length; j++) {
        		if(obstacleGrid[i][j]==1) count[j] = 0;
        		else count[j] += count[j-1];
        	}
        }
        return count[count.length-1];
    }
    
	public static void main(String[] args) {

	}

}
