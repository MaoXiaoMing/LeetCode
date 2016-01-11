
/*
 * 69. Sqrt(x)
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class P069 {

    public static int mySqrt(int x) {
        if(x<=0) return x;
        long t = x;
        long high = Integer.MAX_VALUE;
        long low = 0;
        while(low<=high) {
        	if(low*low<=t&&(low+1)*(low+1)>t) return (int)low;
        	long mid = (low+high)/2;
        	if(mid*mid < x) low = mid+1;
        	else high = mid-1;
        }
        return (int)(low*low>x?low-1:low);
    }
	
	public static void main(String[] args) {
		System.out.println(mySqrt(3));
	}

}
