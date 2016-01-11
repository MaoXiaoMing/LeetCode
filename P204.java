/*
 * Count Primes
 * Count the number of prime numbers less than a non-negative number, n.*/
public class P204 {
	public static int countPrimes(int n) {
		boolean[] isPrimes = new boolean[n];
		for(int i=2; i<n; i++) {
			isPrimes[i] = true;
		}
		for(int i=2; i<n; i++) {
			for(int j=2*i; j<n; j+=i) {
				isPrimes[j] = false;
			}
		}
		
		int count = 0;
		for(int i=2; i<n; i++) {
			if(isPrimes[i]==true) {
				count++;
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		System.out.println(countPrimes(8));
	}
}
