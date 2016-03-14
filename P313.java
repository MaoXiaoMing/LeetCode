import java.util.Arrays;

public class P313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] memo = new int[n+1];
		int[] p = new int[primes.length];
		Arrays.fill(p, 1);
		memo[1] = 1;
		int count = 2;
		while(count <= n) {
			int next = memo[p[0]]*primes[0];
			for(int i=1; i<p.length; i++) {
				next = Math.min(next, memo[p[i]]*primes[i]);
			}
			for(int i=0; i<p.length; i++) {
				if(memo[p[i]]*primes[i]==next) p[i]++;
			}
			memo[count] = next;
			count++;
		}
		return memo[n];
    }
}