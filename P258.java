
/*
 * Add Digits
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/
public class P258 {
	
	//num = 1+(num-1)%9;
	
	public int addDigits(int num) {
        while(num > 9) {
        	int res = 0;
        	while(num > 0) {
        		res += num%10;
        		num /= 10;
        	}
        	num = res;
        }
        return num;
    }
	
	public static void main(String[] args) {
		Util.p(new P258().addDigits(38));
	}
}
