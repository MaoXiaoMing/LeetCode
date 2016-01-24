
/*
 * 130. Surrounded Regions
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
public class P130 {
	
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0]==null || board[0].length==0) return ;
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++) {
        	if(board[i][0]=='O') dfs(board, i, 0);
        	if(board[i][col-1]=='O') dfs(board, i, col-1);
        }
        for(int j=1; j<col-1; j++) {
        	if(board[0][j]=='O') dfs(board, 0, j);
        	if(board[row-1][j]=='O') dfs(board, row-1, j);
        }
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		if(board[i][j]=='I') board[i][j]='O';
        		else if(board[i][j]=='O') board[i][j]='X';
        	}
        }
    }	
    
    public void dfs(char[][] board, int row, int col) {
    	board[row][col] = 'I';
    	if(row>1 && board[row-1][col]=='O') dfs(board, row-1, col);
    	if(row<board.length-1 && board[row+1][col]=='O') dfs(board, row+1, col);
    	if(col>1 && board[row][col-1]=='O') dfs(board, row, col-1);
    	if(col<board[row].length-1 && board[row][col+1]=='O') dfs(board, row, col+1);
    }
    
	public static void main(String[] args) {
		char[][] input = new char[][]{{'O','O','O','O','X','X'}, {'O','O','O','O','O','O'},
			{'O','X','O','X','O','O'}, {'O','X','O','X','X','O'},
			{'O','X','O','X','O','O'}, {'O','X','O','O','O','O'}};
//		char[][] input = new char[][]{{'X','X','X','X'}, {'X','O','O','X'},
//			{'X','X','O','X'}, {'X','O','X','X'}};
//		char[][] input = new char[][]{{'O'}};

			P130 test = new P130();
//			test.solve(input);
	}

//    public void solve(char[][] board) {
//        if(board==null || board.length==0 || board[0]==null || board[0].length==0) 
//        	return ;
//    	for(int i=1; i<board.length; i++) {
//        	for(int j=1; j<board[i].length; j++) {
//        		if(board[i][j] == 'O')
//        			surround(board, i, j);
//        	}
//        }
//    	for(int i=1; i<board.length; i++) {
//    		for(int j=1; j<board[i].length; j++) {
//    			if(board[i][j] == '#') board[i][j] = 'O';
//    			else if(board[i][j] == '!') board[i][j] = 'X';
//    		}
//    	}
//    	System.out.println();
//    }
//    
//    public boolean surround(char[][] board, int row, int col) {
//    	if(board[row][col] == 'O') {
//    		if(row==0 || row==board.length-1 || col==0 || col==board[row].length-1) 
//    			return false;
//    		board[row][col] = '#';
//    		if(board[row+1][col]=='O'&&!surround(board, row+1, col)) return false;
//    		else if(board[row-1][col]=='O')
//    		if(!surround(board, row+1, col) || !surround(board, row-1, col)
//    				|| !surround(board, row, col+1) || !surround(board, row, col-1)) {
//    			return false;
//    		}
//    		board[row][col] = '!';
//    		return true;
//    	}
//    	return true;
//    }
    
}
