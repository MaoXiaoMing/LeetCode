public class P029 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
		if((dividend<0&&divisor>0) || (dividend>0&&divisor<0)) 
			return -helper(Math.abs((long)dividend), Math.abs((long)divisor));
		else return helper(Math.abs((long)dividend), Math.abs((long)divisor));
    }
	
	public int helper(long dividend, long divisor) {
		return (int)Math.floor(Math.pow(Math.E, Math.log(dividend)-Math.log(divisor)));
	}
}