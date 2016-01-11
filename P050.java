
/*
 * Pow(x, n)
Implement pow(x, n).
*/

public class P050 {
	
    public static double myPow(double x, int n) {
    	if(n==0) return 1;
    	else if(n==1) return x;
    	else if(n==Integer.MIN_VALUE) {
    		double part = myPow(x, Math.abs(n>>1));
    		return 1/(part*part);
    	}else {
    		double part = myPow(x, Math.abs(n)>>1);
    		if(n < 0) {
    			if((n&1) == 1) return 1/(part*part*x);
    			else return 1/(part*part);
    		}else {
    			if((n&1) == 1) return part*part*x;
    			else return part*part;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myPow(34.00515, -3);
		System.out.println(Integer.MIN_VALUE>>>1);
	}

}
