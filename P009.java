
/*
 * Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.*/
public class P009 {

	public static boolean isPalindrome(int x) {
		int y = x;
		int result = 0;
        while(y>0) {
        	result = result*10+y%10;
        	y /= 10;
        }
        return x==result;
//	    int sum = 0,target = x;
//	    while (x > 0) {
//	        int temp = x % 10;
//	        x /= 10;
//	        sum = sum * 10 + temp;
//	    }
//	    return sum == target;
    }
	
	public static void main(String[] args) {
		isPalindrome(-2147447412);
		System.out.println(-13%10);
		System.out.println(-13/10);
	}

}
