
/*233. Number of Digit One
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.*/
public class P233 {
	
    public int countDigitOne(int n) {
        int res = 0;
        long mod = 1;
        while(mod <= n) {
        	long front = n / (mod*10);
        	long rear = n % 10;
        	long cur = (n/mod)%10;
        	if(cur > 1) {
        		res += (front+1)*mod;
        	}else if(cur == 1) {
        		res += front*mod+rear+1;
        	}else {
        		res += front*mod;
        	}
        	mod *= 10;
        }
        return res;
    }
}
