
/*
 * Search in Rotated Sorted Array II
 * 
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 * */

public class P081 {
	
    public boolean search(int[] nums, int target) {
    	int low = 0;
    	int high = nums.length-1;
    	while(true) {
    		if(low > high) return false;
    		int mid = (low+high)/2;
    		if(target == nums[mid]) return true;
    		if(nums[low] < nums[mid]) {
    			if(target>=nums[low] && target<nums[mid]) high = mid-1;
    			else low = mid+1;
    		}else if(nums[low] > nums[mid]){
    			if(target>nums[mid] && target<nums[low]) low = mid+1;
    			else high = mid-1;
    		}else {
    			low++;
    		}
    	}
    }
    
	public static void main(String[] args) {

	}

}
