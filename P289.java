import java.util.Arrays;

/*289. Game of Life
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/
public class P289 {
	
    public void gameOfLife(int[][] board) {
    	int[][] pre = new int[board.length+2][board[0].length+2];
    	for(int i=0; i<board.length; i++) 
    		for(int j=0; j<board[i].length; j++) 
    			pre[i+1][j+1] = board[i][j];
    	for(int i=1; i<pre.length-1; i++) {
    		for(int j=1; j<pre[i].length-1; j++) {
    			int result = liveNeighbor(pre, i, j);
    			if(pre[i][j]==0) {
    				if(result == 3)
    					board[i-1][j-1] = 1;
    			}else {
    				if(result<2 || result>3) 
    					board[i-1][j-1] = 0;
    				else board[i-1][j-1] = 1;
    			}
    		}
    	}
    }
    
    public int liveNeighbor(int[][] board, int row, int col) {
    	int result = 0;
    	result += board[row-1][col-1];
    	result += board[row-1][col+1];
    	result += board[row-1][col];
    	result += board[row][col-1];
    	result += board[row][col+1];
    	result += board[row+1][col-1];
    	result += board[row+1][col+1];
    	result += board[row+1][col];
    	return result;
    }
    
	public static void main(String[] args) {
		P289 test = new P289();
		test.gameOfLife(new int[][]{{1,1},{1,0}});
	}

}
