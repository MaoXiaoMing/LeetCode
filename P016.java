import java.util.Arrays;

/*
 * 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */

public class P016 {
	
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minGap = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
        	int start = i+1;
        	int end = nums.length-1;
        	while(start<end) {
        		int sum = nums[i]+nums[start]+nums[end];
        		int gap = Math.abs(target-sum);
        		if(minGap > gap) {
        			res = sum;
        			minGap = gap;
        		}
        		if(sum > 0) {
        			end--;
        		}else {
        			start++;
        		}
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {
		threeSumClosest(new int[]{-1,2,1,-4}, 1);
	}

}
