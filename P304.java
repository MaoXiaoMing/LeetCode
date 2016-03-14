
public class P304 {
	
	private int[][] memo;
	public P304(int[][] matrix) {
		memo = new int[matrix.length][matrix[0].length];
		memo[0][0] = matrix[0][0];
		for(int i=1; i<matrix.length; i++) memo[i][0] += memo[i-1][0];
		for(int i=1; i<matrix[0].length; i++) memo[0][i] += memo[0][i-1];
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				memo[i][j] = matrix[i][j]+memo[i-1][j]+memo[i][j-1]-memo[i-1][j-1];
			}
		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = memo[row2][col2];
		if(row1>0) res -= memo[row1-1][col2];
		if(col1>0) res -= memo[row2][col1-1];
		if(row1>0 && col1>0) res+=memo[row1][col1];
		return res;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);