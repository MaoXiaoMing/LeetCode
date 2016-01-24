
/*326. Power of Three
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?*/
public class P326 {

    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        double result = Math.log(n)/Math.log(3);
        return Math.abs(result-Math.rint(result))<=0.0000000000000001;
    }
	
	public static void main(String[] args) {
		P326 test = new P326();
		test.isPowerOfThree((int)Math.pow(3, 99));
	}

}
