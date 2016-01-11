
/*
 * 154. Find Minimum in Rotated Sorted Array II
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class P154 {
	
    public int findMin(int[] nums) {
    	int low = 0;
    	int high = nums.length-1;
    	while(true) {
    		if(low==high) return nums[low];
    		int mid = (low+high)/2;
    		if(nums[mid] > nums[high]) low=mid+1;
    		else if(nums[mid] < nums[high]) high = mid;
    		else high--;
    	}
    }
    
	public static void main(String[] args) {

	}

}
