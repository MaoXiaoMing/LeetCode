
/*
 * 201. Bitwise AND of Numbers Range
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/
public class P201 {
	
    public int rangeBitwiseAnd(int m, int n) {
    	int result = 0;
        for(int i=0; i<30; i++) {
        	if(isOne(i, m, n)) result += 1<<i;
        }
        if(m>=1<<30) result += 1<<30;
        return result;
    }
    
    public boolean isOne(int index, int m, int n) {
    	if(n-m+1 > 1<<index) return false;
    	if((m&1<<index)!=0 && (n-m+(m&(~(-1<<index+1))))<(1<<(index+1))) return true;
    	return false;
    }
//    (n-m+1)&(~(Integer.MIN_VALUE>>(32-index)))+n-m)<(1<<(index+1)
	public static void main(String[] args) {
		P201 p = new P201();
		System.out.println(p.rangeBitwiseAnd(2147483646, 2147483647));
	}

}
