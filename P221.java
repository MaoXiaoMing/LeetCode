public class P221 {
    public int maximalSquare(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return 0; 
        int[][] dp = new int[matrix.length][matrix[0].length];
		int max = 0;
		for(int i=0; i<matrix.length; i++) {
			dp[i][0]=matrix[i][0]-'0';
			max += dp[i][0];
		}
		for(int i=0; i<matrix[0].length; i++) {
			dp[0][i]=matrix[0][i]-'0';
		    max += dp[0][i];
		}
		max = max==0?0:1;
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				dp[i][j] = matrix[i][j]=='0'?0:Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1])+1;
				max = Math.max(max, dp[i][j]*dp[i][j]);
			}
		}
		return max;
    }
}