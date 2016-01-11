
/*
 * 153. Find Minimum in Rotated Sorted Array
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Subscribe to see which companies asked this question
*/
public class P153 {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(true) {
        	if(low==high) return nums[low];
        	int mid = (low+high)/2;
        	if(nums[high] < nums[mid]) low = mid+1;
        	else high=mid;
        }
    }
	
	public static void main(String[] args) {
		findMin(new int[]{4,5,6,7,0,1,2});
	}	

}
