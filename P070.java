
/*
 * Climbing Stairs
 * 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * */

public class P070 {
	
    public static int climbStairs(int n) {
    	int sum = 0;
        int num1 = 0;
        int num2 = 1;
        for(int i=0; i<n; i++) {
        	sum = num2+num1;
        	num1 = num2;
        	num2 = sum;
        }
        return sum;
    }
    
	public static void main(String[] args) {
		climbStairs(0);
	}

}
