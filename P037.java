
/*
 * 37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/

public class P037 {

    public void solveSudoku(char[][] board) {
    	dfs(board, 0, 0);
    }	
	
    public boolean dfs(char[][] board, int row, int col) {
    	if(row==board.length && col==0) return true;
    	if(board[row][col]=='.') {
    		for(int i=1; i<=9; i++) {
    			if(isVaild(board, row, col, i+'0')) {
    				board[row][col] = (char)(i+'0');
    				if(dfs(board, col==8?row+1:row, col==8?0:col+1))
    					return true;
    			}
    		}
    		board[row][col] = '.';
    		return false;
    	}
    	return dfs(board, col==8?row+1:row, col==8?0:col+1);
    }
    
    public boolean isVaild(char[][] board, int row, int col, int num) {
    	for(int i=0; i<board[row].length; i++) 
    		if(num==board[row][i]) 
    			return false;
    	for(int i=0; i<board.length; i++) 
    		if(num==board[i][col]) return false;
    	int startRow = row/3*3;
    	int startCol = col/3*3;
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<3; j++) {
    			if(board[startRow+i][startCol+j]==num)
    				return false;
    		}
    	}
    	return true;
    }
    
    public static char[][] convert(String[] input) {
    	char[][] result = new char[9][9];
    	for(int i=0; i<result.length; i++) {
    		for(int j=0; j<result[i].length; j++) {
    			result[i][j] = input[i].charAt(j);
    		}
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		P037 test = new P037();
		String[] input = new String[]{
				"53..7....",
				"6..195...",
				".98....6.",
				"8...6...3",
				"4..8.3..1",
				"7...2...6",
				".6....28.",
				"...419..5",
				"....8..79"};
		test.solveSudoku(convert(input));
	}

}
