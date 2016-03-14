public class P279 {
    public int numSquares(int n) {
        int[] memo = new int[n+1];
		for(int i=1; i<=n; i++) {
			int sqrt = (int)Math.sqrt(i);
			int min = Integer.MAX_VALUE;
			for(int j=sqrt; j>0; j--) {
				min = Math.min(min, memo[i-j*j]+1);
			}
			memo[i] = min;
		}
		return memo[n];
    }
}