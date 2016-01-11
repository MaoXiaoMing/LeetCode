
/*
 * 52. N-Queens II
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class P052 {

    public int totalNQueens(int n) {
        int[] cols = new int[n];
        return dfs(cols, 0, n);
    }
	
    public int dfs(int[] cols, int row, int n) {
    	if(row == n) return 1;
    	int count = 0;
    	for(int i=0; i<n; i++) {
    		if(isVaild(cols, row, i)) {
    			cols[row] = i;
    			count += dfs(cols, row+1, n);
    		}
    	}
    	return count;
    }
    
    public boolean isVaild(int[] cols, int row, int index) {
    	for(int i=0; i<row; i++) {
    		if(cols[i]==index || Math.abs(cols[i]-index)==row-i)  
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {

	}

}
