
/*312. Burst Balloons
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167*/

public class P312 {
	
    public int maxCoins(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
        int[] filter = new int[nums.length+2];
        filter[0] = 1;
        int count = 1;
        for(int num : nums) {
        	if(num != 0) filter[count++] = num;
        }
        filter[count++] = 1; 
        int noZeroNum = count-2;
        int[][] dp = new int[noZeroNum+2][noZeroNum+2];
        for(int len=1; len<=noZeroNum; len++) {
        	for(int start=1; start<=noZeroNum-len+1; start++) {
        		int max = -1;
        		for(int index=start; index<=start+len-1; index++) {
        			max = Math.max(max, dp[start][index-1]+dp[index+1][start+len-1]+filter[start-1]*filter[index]*filter[start+len]);
        		}
        		dp[start][start+len-1] = max;
        	}
        }
        return dp[1][noZeroNum];
    }
    
}
