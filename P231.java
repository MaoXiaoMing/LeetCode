
/*
 * Power of Two
 * Given an integer, write a function to determine if it is a power of two.*/

public class P231 {
	
/*	public int numOne(int num) {
		int count = 0;
		while(num != 0) {
			num = num&(num-1);
			count++;
		}
		return count;
	}
	
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) {
			return false;
		}else if(numOne(n) == 1) {
        	return true;
        }else {
        	return false;
        }
    }
	*/
	
	public boolean isPowerOfTwo(int n) {
		return n>0 && (n&(n-1))==0;
    }
	
	public static void main(String[] args) {
		System.out.println(new P231().isPowerOfTwo(2));
	}
}
