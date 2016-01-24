
/*
 * 79. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class P079 {

    public boolean exist(char[][] board, String word) {
    	if(word==null || word.length()==0) return true;
    	if(board==null || board.length==0 || board[0]==null || board[0].length==0) return false;
    	for(int i=0; i<board.length; i++) {
    		for(int j=0; j<board[i].length; j++) {
    			if(isVaild(board, i, j, word, 0)) return true;
    		}
    	}
        return false;
    }	
	
    public boolean isVaild(char[][] board, int row, int col,
    		String word, int index) {
    	if(board[row][col] != word.charAt(index)) return false;
    	else if(++index == word.length()) return true;
    	char memo = board[row][col];
    	board[row][col] = '#';
    	if(row>0 && board[row-1][col]!='#') {
    		if(isVaild(board, row-1, col, word, index)) return true;
    	}
    	if(row<board.length-1 && board[row+1][col]!='#') {
    		if(isVaild(board, row+1, col, word, index)) return true;
    	}
    	if(col>0 && board[row][col-1]!='#') {
    		if(isVaild(board, row, col-1, word, index)) return true;
    	}
    	if(col<board[row].length-1 && board[row][col+1]!='#') {
    		if(isVaild(board, row, col+1, word, index)) return true;
    	}
    	board[row][col] = memo;
    	return false;
    }
    
	public static void main(String[] args) {
		char[][] input = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		P079 test = new P079();
		System.out.println(test.exist(input, "ABCCED"));
	}

}
