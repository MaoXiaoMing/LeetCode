
/*
 * 53. Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * */
public class P053 {
	
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
        	if(sum < 0) sum = nums[i];
        	else sum += nums[i];
        	if(max < sum) max = sum;
        }
        return max;
    }
    
	public static void main(String[] args) {
		maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,-4});
	}

}
