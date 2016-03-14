import java.util.ArrayList;
import java.util.List;

public class P212 {
	
	private class Node {
		String word;
		Node[] next = new Node[26];
	}
	
	private Node root;
	
	public void buildTrie(String[] words) {
		root = new Node();
		for(String word : words) {
			Node current = root;
			for(char c : word.toCharArray()) {
				int index = c-'a';
				if(current.next[index] == null) current.next[index] = new Node();
				current = current.next[index];
			}
			current.word = word;
		}
	}
	
	public void dfs(Node current, List<String> res, char[][] board, int row, int col) {
		char c = board[row][col];
		if(c=='#' || current.next[c-'a']==null) return ;
		current = current.next[c-'a'];
		if(current.word != null) {
			res.add(current.word);
			current.word = null;
			//return ;			//继续搜索下去
		}
		board[row][col] = '#';
		if(row>0) dfs(current, res, board, row-1, col);
		if(row<board.length-1) dfs(current, res, board, row+1, col);
		if(col>0) dfs(current, res, board, row, col-1);
		if(col<board[0].length-1) dfs(current, res, board, row, col+1);
		board[row][col] = c;
	}
	
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        buildTrie(words);
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		dfs(root, res, board, i, j);
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {

	}

}
