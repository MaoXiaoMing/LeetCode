
/* 
 * Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.*/

public class P172 {
	public static int trailingZeroes(int n) {
        int res = 0;
		while(n>=5) {
			n /= 5;
        	res += n;
        }
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(30));
	}
}
