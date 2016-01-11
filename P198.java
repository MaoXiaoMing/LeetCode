
/*
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.*/

public class P198 {
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int first = nums[0];
        if(nums.length == 1) {
        	return first;
        }
        int second = nums[0]<nums[1]?nums[1]:nums[0];
        for(int i=2; i<nums.length; i++) {
        	if(nums[i]+first > second) {
        		int temp = second;
        		second = nums[i]+first;
        		first = temp;
        	}else{
        		first = second; 
        	}
        }
        return Math.max(first, second);
    }
}
