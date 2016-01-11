/*
 * 268. Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * */
public class P268 {
	
    public int missingNumber(int[] nums) {
    	int count = 0;
    	for(int i=0; i<nums.length; i++) count += nums[i];
    	return nums.length*(nums.length+1)/2-count;
/*        int low = 0;
        int high = nums.length-1;
        while(true) {
        	if(low > high) return high+1;
        	int mid = (low+high)/2;
        	if(mid != nums[mid]) high = mid-1;
        	else low = mid+1;
        }*/
    }
    
	public static void main(String[] args) {

	}

}
