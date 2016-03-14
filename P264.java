public class P264 {
    public int nthUglyNumber(int n) {
        int[] memo = new int[n+1];
		memo[1] = 1;
		int p2, p3, p5;
		p2 = p3 = p5 = 1;
		int count = 2;
		while(count <= n) {
			int next = Math.min(2*memo[p2], Math.min(3*memo[p3], 5*memo[p5]));
			if(2*memo[p2]==next) p2++;
			if(3*memo[p3]==next) p3++;
			if(5*memo[p5]==next) p5++;
			memo[count] = next;
			count++;
		}
		return memo[n];
    }
}