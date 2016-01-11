/*
55. Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class P055 {

    public static boolean canJump(int[] nums) {
    	int reach = 0;
    	for(int i=0; i<=reach&&i<nums.length; i++) {
    		reach = reach>i+nums[i]?reach:i+nums[i];
    	}
        return reach>=nums.length-1;
    }
	
	public static void main(String[] args) {
		canJump(new int[]{3,2,1,0,4});
	}

}
