import java.util.HashSet;
import java.util.Set;

/*
 * Valid Sudoku
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.*/

public class P036 {
	
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++) {
        	Set<Character> row = new HashSet<Character>();
        	Set<Character> column = new HashSet<Character>();
        	for(int j=0; j<board.length; j++) {
        		if(board[i][j]!='.' && row.contains(board[i][j])) {
        			return false;
        		}else {
        			row.add(board[i][j]);
        		}
        		if(board[j][i]!='.' && column.contains(board[j][i])) {
        			return false;
        		}else {
        			column.add(board[j][i]);
        		}
        	}
        }
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		Set<Character> set = new HashSet<Character>();
        		for(int k=0; k<9; k++) {
        			if(board[i*3+k/3][j*3+k%3]!='.') {
        				if(set.contains(board[i*3+k/3][j*3+k%3])) {
        					return false;
        				}else {
        					set.add(board[i*3+k/3][j*3+k%3]);
        				}
        			}
        		}
        	}
        }
        return true;
    }
	
    public static char[][] convert(String[] input) {
    	char[][] result = new char[9][9];
    	for(int i=0; i<input.length; i++) {
    		for(int j=0; j<input[i].length(); j++) {
    			result[i][j] = input[i].charAt(j);
    		}
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		char[][] intput = convert(new String[]{"....5..1.",
							 ".4.3.....",
							 ".....3..1",
							 "8......2.",
							 "..2.7....",
							 ".15......",
							 ".....2...",
							 ".2.9.....",
							 "..4......"});
		System.out.println(isValidSudoku(intput));
	}

}
