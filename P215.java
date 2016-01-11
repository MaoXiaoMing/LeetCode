
/*
 * 215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class P215 {
	
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, 0, nums.length-1, k);
    }
    
    public int findKth(int[] nums, int start, int end, int k) {
    	if(start==end) return nums[start];
    	int index = start;
    	for(int i=start+1; i<=end; i++) {
    		if(nums[start] > nums[i]) {
    			int temp = nums[i];
    			nums[i] = nums[++index];
    			nums[index] = temp;
    		}
    	}
    	if(k == (end-index+1)) return nums[start];
    	int temp = nums[index];
    	nums[index] = nums[start];
    	nums[start] = temp;
    	if(k < (end-index+1)) return findKth(nums, index+1, end, k);
    	else return findKth(nums, start, index-1, k-(end-index+1));
    }
    
	public static void main(String[] args) {
		new P215().findKthLargest(new int[]{3,2,1}, 3);
	}

}
