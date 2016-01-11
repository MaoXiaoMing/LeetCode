
/*
 * Search for a Range
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class P034 {

    public int[] searchRange(int[] nums, int target) {
    	int start = -1;
    	int end = -1;
    	int low = 0;
		int high = nums.length-1;
		while(true) {
			if(low > high) {
				break;
			}
			int mid = (low+high)/2;
			if(target < nums[mid]) {
				high = mid-1;
			}else if(target > nums[mid]) {
				low = mid+1;
			}else {
				if(mid!=low && nums[mid-1]==target) {
					high = mid-1;
				}else {
					start = mid;
					break;
				}
			}
		}
    	low = 0;
		high = nums.length-1;
		while(true) {
			if(low > high) {
				break;
			}
			int mid = (low+high)/2;
			if(target < nums[mid]) {
				high = mid-1;
			}else if(target > nums[mid]) {
				low = mid+1;
			}else {
				if(mid!=high && nums[mid+1] == target) {
					low = mid+1;
				}else {
					end = mid;
					break;
				}
			}
		}
		return new int[]{start, end};
    }
	
	public static void main(String[] args) {

	}

}
