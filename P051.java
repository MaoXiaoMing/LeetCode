import java.util.ArrayList;
import java.util.List;

/*
 * 51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class P051 {
	private String string = "";
    public List<List<String>> solveNQueens(int n) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<n; i++) sb.append('.');
    	string = sb.toString();
        List<List<String>> res = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        dfs(res, inter, 0, n);
        return res;
    }
	
    public void dfs(List<List<String>> res, List<String> inter, int start, int n) {
    	if(start == n) {
    		res.add(new ArrayList<>(inter));
    		return ;
    	}
    	int[] vaild = vaildLocate(inter, start, n);
    	for(int i=0; i<vaild.length; i++) {
    		if(vaild[i] == 0) {
    			inter.add(string.substring(0, i)+'Q'+string.substring(i+1)); 
    			dfs(res, inter, start+1, n);
    			inter.remove(inter.size()-1);
    		}
    	}
    }
    
    public int[] vaildLocate(List<String> inter, int start, int n) {
    	int[] vaild = new int[n];
    	for(int i=0; i<inter.size(); i++) {
    		int locat = inter.get(i).indexOf('Q');
    		vaild[locat] = 1;
    		if(locat+start-i < n) vaild[locat+start-i] = 1;
    		if(locat-start+i >= 0) vaild[locat-start+i] = 1;
    	}
    	return vaild;
    }
    
	public static void main(String[] args) {
		List<List<String>> res = new P051().solveNQueens(4);
		for(List<String> part : res) {
			System.out.println("part start");
			for(String line : part) {
				System.out.println(line);
			}
			System.out.println("part end");
		}
	}

}
