
/*
 * Search in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * */

public class P033 {
	
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
    	while(true) {
        	if(low > high) return -1;
        	int mid = (low+high)/2;
        	if(target == nums[mid]) return mid;
        	else {
        		if(nums[low] > nums[mid]) {
        			if(target < nums[mid]) {
        				high = mid-1;
        			}else if(target<=nums[high]) {
            			low = mid+1;
            		}else{
            			high = mid-1;
            		}
            	}else {
            		if(target > nums[mid]) {
            			low = mid+1;
            		}else if(target >= nums[low]) {
            			high = mid-1;
            		}else {
            			low = mid+1;
            		}
            	}
        	}
        }
    }
    
	public static void main(String[] args) {
		System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
	}

}
