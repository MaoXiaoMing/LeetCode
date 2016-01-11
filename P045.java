
/*
 * 45. Jump Game II
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]
Note:
You can assume that you can always reach the last index.
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class P045 {
	
    public int jump(int[] nums) {
        int step = 0;
        int left = 0;
        int right = 0;
        if(nums.length==1) return 0; 
        for(int i=0; i<nums.length; i++) {
        	step++;
        	int temp = left;
        	for(int j=left; j<=right; j++) {
        		if(j+nums[j]>=nums.length-1) return step;
        		right = right<j+nums[j]?j+nums[j]:right;
        	}
        	left = temp+1;
        }
        return 0;
    }	
    
	public static void main(String[] args) {
		P045 p = new P045();
		System.out.println(p.jump(new int[]{}));
	}
}
