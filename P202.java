import java.util.HashSet;
import java.util.Set;

/*
 * Happy Number
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1*/

public class P202 {
	private Set<Integer> set = new HashSet<Integer>();

	public int squareSum(int n) {
		int sum = 0;
		while(n != 0) {
			sum += Math.pow(n%10, 2);
			n /= 10;
		}
		return sum;
	}
	
	public boolean isHappy(int n) {
		if(n == 1) return true;
        if(!set.contains(n)) {
        	set.add(n);
        	int next = squareSum(n);
        	return isHappy(next);
        }else {
        	return false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(new P202().isHappy(10));
	}
}
