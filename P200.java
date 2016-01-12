
/*
 * 200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
public class P200 {
	private int count;
	
    public int numIslands(char[][] grid) {
    	count = 0;
    	if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) return 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[i].length; j++) {
        		if(visit[i][j]==false && grid[i][j]=='1') {
        			count++;
        			visit[i][j] = true;
        			dfs(grid, visit, i, j);
        		}
        	}
        }
        return count;
    }
    
    public void dfs(char[][] grid, boolean[][] visit, int row, int col) {
    	if(row>0 && row<grid.length-1) {
    		if(!visit[row-1][col] && grid[row-1][col]=='1') {
    			visit[row-1][col] = true;
    			dfs(grid, visit, row-1, col);
    		}
    		if(!visit[row+1][col] && grid[row+1][col]=='1') {
    			visit[row+1][col] = true;
    			dfs(grid, visit, row+1, col);
    		}
    	}else if(row == 0 && row+1<grid.length) {
    		if(!visit[row+1][col] && grid[row+1][col]=='1') {
    			visit[row+1][col] = true;
    			dfs(grid, visit, row+1, col);
    		}
    	}else if(row>0 && row==grid.length-1) {
    		if(!visit[row-1][col] && grid[row-1][col]=='1') {
    			visit[row-1][col] = true;
    			dfs(grid, visit, row-1, col);
    		}
    	}
    	if(col>0 && col<grid[row].length-1) {
    		if(!visit[row][col-1] && grid[row][col-1]=='1') {
    			visit[row][col-1] = true;
    			dfs(grid, visit, row, col-1);
    		}
    		if(!visit[row][col+1] && grid[row][col+1]=='1') {
    			visit[row][col+1] = true;
    			dfs(grid, visit, row, col+1);
    		}
    	}else if(col == 0 && col+1<grid[row].length) {
    		if(!visit[row][col+1] && grid[row][col+1]=='1') {
    			visit[row][col+1] = true;
    			dfs(grid, visit, row, col+1);
    		}
    	}else if(col>0 && col==grid[row].length-1) {
    		if(!visit[row][col-1] && grid[row][col-1]=='1') {
    			visit[row][col-1] = true;
    			dfs(grid, visit, row, col-1);
    		}
    	}
    }
    
	public static void main(String[] args) {
		char[][] input = new char[][]{
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}};
		P200 p = new P200();
		System.out.println(p.numIslands(input));
	}

}
